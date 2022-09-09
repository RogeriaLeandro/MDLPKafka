package br.mil.defesa.interc2.mdlp.br2;


import br.mil.defesa.interc2.mdlp.model.FactoryEad;
import br.mil.defesa.interc2.mdlp.model.MemberBr2;
//import br.mil.defesa.interc2.mdlp.model.TipoEad;
import br.mil.defesa.interc2.mdlp.utils.utils.DataLink;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Br2Tests {

    @Autowired
    private BoilerPlateBr2 boilerPlateBr2;
    private Logger logger = Logger.getLogger(Br2Tests.class.getName());



    @Test
    public void testVerifySizeOfMemberListBr2() throws JSONException {
        boilerPlateBr2.resetList();
        boilerPlateBr2.createArrayOfMemberListBr2("QUALQUER COISA 1", -37.50325, -42.0000, 2);
        boilerPlateBr2.createArrayOfMemberListBr2("QUALQUER COISA 2", -37.50325, -42.0000, 2);

        MemberBr2 br2 = (MemberBr2) FactoryEad.create(DataLink.BR2);
        br2.setTrackList(boilerPlateBr2.getListOfMemberListBr2());

        assertTrue(boilerPlateBr2.getListOfMemberListBr2().size()==br2.getTrackList().size());
    }

    @Test
    public void testVerifyMemberOfMemberListBr2() throws JSONException{
        boilerPlateBr2.resetList();
        boilerPlateBr2.createArrayOfMemberListBr2("QUALQUER COISA 1", -37.50325, -42.0000, 2);
        boilerPlateBr2.createArrayOfMemberListBr2("QUALQUER COISA 2", -37.50325, -42.0000, 2);

        MemberBr2 br2 = (MemberBr2) FactoryEad.create(DataLink.BR2);
        br2.setTrackList(boilerPlateBr2.getListOfMemberListBr2());

        assertTrue(boilerPlateBr2.getListOfMemberListBr2().equals(br2.getTrackList()));
    }

    @Test
    public void testVerifyMembersOfTrackList() throws JSONException{
        boilerPlateBr2.resetList();
        boilerPlateBr2.createArrayTrackList(15, -34.50325, -45.1392, 5000, 300, 0, 1);
        boilerPlateBr2.createArrayTrackList(10, -34.50325, -45.1392, 5000, 300, 0, 1);

        MemberBr2 br2 = (MemberBr2) FactoryEad.create(DataLink.BR2);
        br2.setMemberList(boilerPlateBr2.getListOfTrackList());

        assertTrue(boilerPlateBr2.getListOfTrackList().equals(br2.getMemberList()));
    }

    @Test
    public void testVerifyIfBr2ContainsListOfMemberListAndListOfTrackList() throws JSONException {
        boilerPlateBr2.resetList();
        boilerPlateBr2.createArrayOfMemberListBr2("QUALQUER COISA 1", -37.50325, -42.0000, 2);
        boilerPlateBr2.createArrayOfMemberListBr2("QUALQUER COISA 2", -37.50325, -42.0000, 2);
        boilerPlateBr2.createArrayTrackList(15, -34.50325, -45.1392, 5000, 300, 0, 1);
        boilerPlateBr2.createArrayTrackList(10, -34.50325, -45.1392, 5000, 300, 0, 1);

        MemberBr2 br2 = (MemberBr2) FactoryEad.create(DataLink.BR2);
        br2.setTrackList(boilerPlateBr2.getListOfMemberListBr2());
        br2.setMemberList(boilerPlateBr2.getListOfTrackList());

        assertTrue(boilerPlateBr2.getListOfMemberListBr2().equals(br2.getTrackList()) && boilerPlateBr2.getListOfTrackList().equals(
                br2.getMemberList()));
    }
}

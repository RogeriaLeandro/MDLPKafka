package br.mil.defesa.interc2.mdlp.sistram;

import br.mil.defesa.interc2.mdlp.model.FactoryEad;
//import br.mil.defesa.interc2.mdlp.model.TipoEad;
import br.mil.defesa.interc2.mdlp.model.MemberSistram;
import br.mil.defesa.interc2.mdlp.utils.utils.DataLink;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SistramTests {

    @Autowired
    private BoilerPlateSistram boilerPlate;
    private Logger logger = Logger.getLogger(SistramTests.class.getName());

    @Test
    public void testVerifyMemberOfJson(){
        boilerPlate.resetList();
        boilerPlate.createJson("ALGO 1", "-49.38933", "-34.13821", 29);
        boilerPlate.createJson("ALGO 2", "-49.38933", "-34.13821", 29);

        MemberSistram sistram = (MemberSistram) FactoryEad.create(DataLink.SISTRAM);
        sistram.setListOfMemberList(boilerPlate.getListOfJson());

        assertTrue(boilerPlate.getListOfJson().equals(sistram.getListOfJson()));
    }

}

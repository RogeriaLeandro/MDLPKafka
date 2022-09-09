package br.mil.defesa.interc2.mdlp;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public String[] devolveArrayTopics(String topics) {

        String[] listTopics = topics.split(",");
        return listTopics;
    }

}

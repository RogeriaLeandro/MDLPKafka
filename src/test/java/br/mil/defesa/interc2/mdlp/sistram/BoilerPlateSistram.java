package br.mil.defesa.interc2.mdlp.sistram;
import org.apache.camel.util.json.JsonObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoilerPlateSistram {

    private List<JsonObject> listOfJson = new ArrayList<JsonObject>();

    public void resetList() {
        listOfJson.clear();
    }

    public void createJson(String nome, String longitude, String latitude, Integer idOrigemDados) {
        JsonObject json = new JsonObject();

        json.put("nome_navio", nome);
        json.put("lon", longitude);
        json.put("lat", latitude);
        json.put("id_origem_dados", idOrigemDados);

        listOfJson.add(json);
    }

    public List<JsonObject> getListOfJson() {
        return listOfJson;
    }
}

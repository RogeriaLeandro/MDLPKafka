package br.mil.defesa.interc2.mdlp.br2;

import org.apache.camel.util.json.JsonObject;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoilerPlateBr2 {

    private List<JsonObject> listOfMemberList = new ArrayList<JsonObject>();
    private List<JsonObject> listOfJsons = new ArrayList<JsonObject>();
    private List<JsonObject> listOfTrackList = new ArrayList<JsonObject>();

    public void createArrayOfMemberListBr2(String callsign, Double latitude, Double longitude, Integer entityType) throws JSONException {
        JsonObject memberList = new JsonObject();

        memberList.put("callsign", callsign);
        memberList.put("latitude", latitude);
        memberList.put("longitude", longitude);
        memberList.put("entityTipe", entityType);

        listOfMemberList.add(memberList);
    }

    public List<JsonObject> getListOfMemberListBr2(){
        return listOfMemberList;
    }
    public List<JsonObject> getListOfTrackList(){
        return listOfTrackList;
    }

    public void resetList(){
        listOfMemberList.clear();
        listOfJsons.clear();
        listOfTrackList.clear();
    }

    public void createArrayTrackList(Integer trackId, Double latitude, Double longitude, Integer altitude, Integer velocity,
                                     Integer battleDomain, Integer entityType) throws JSONException{
        JsonObject trackList = new JsonObject();

        trackList.put("trackId", trackId);
        trackList.put("latitudade", latitude);
        trackList.put("longitude", longitude);
        trackList.put("altitude", altitude);
        trackList.put("velocity", velocity);
        trackList.put("battleDomain", battleDomain);
        trackList.put("entityType", entityType);

        listOfTrackList.add(trackList);

    }
}

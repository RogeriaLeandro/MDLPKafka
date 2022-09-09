package br.mil.defesa.interc2.mdlp.model;

import org.apache.camel.util.json.JsonObject;

public class MemberEadDTO {

    private String source;
    private String idSource;
    private Double latitude;
    private Double velocity;
    private Double longitude;

    public void setMemberEad(IMemberEad ead) {

    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getVelocity() {
        return velocity;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getSource() {
        return source;
    }

    public String getIdSource() {
        return IdSource;
    }

    public void setVelocity(Double velocity) {
        this.velocity=velocity;

    }

    public void setLongitude(Double longitude) {
        this.longitude=longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude=latitude;
    }

    public void setSource(String source) {
        this.source=source;
    }

    public void setIdSource(String idSource) {
        this.idSource=idSource;
    }


    public JsonObject getJson() {
        JsonObject json = new JsonObject();

        json.put("source", getSource());
        json.put("idSource", getIdSource());
        json.put("latitude", getLatitude());
        json.put("longitude", getLongitude());
        json.put("groundSpeed", getVelocity());

        return json;
    }
}

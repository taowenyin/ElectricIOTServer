package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AGpsResultEntity {
    @JsonProperty("id")
    private String id;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;
    @JsonProperty("radius")
    private String radius;
    @JsonProperty("address")
    private String address;
    @JsonProperty("roads")
    private String roads;
    @JsonProperty("rid")
    private String rid;
    @JsonProperty("rids")
    private String rids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoads() {
        return roads;
    }

    public void setRoads(String roads) {
        this.roads = roads;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRids() {
        return rids;
    }

    public void setRids(String rids) {
        this.rids = rids;
    }
}

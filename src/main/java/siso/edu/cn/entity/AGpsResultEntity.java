package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AGpsResultEntity {
    @JsonProperty("id")
    private String id;
    @JsonProperty("lat")
    private BigDecimal lat;
    @JsonProperty("lng")
    private BigDecimal lng;
    @JsonProperty("radius")
    private int radius;
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

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
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

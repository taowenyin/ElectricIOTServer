package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AGpsEntity {
    @JsonProperty("status")
    private String status;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("match")
    private String match;
    @JsonProperty("count")
    private String count;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("result")
    private List<AGpsResultEntity> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<AGpsResultEntity> getResult() {
        return result;
    }

    public void setResult(List<AGpsResultEntity> result) {
        this.result = result;
    }
}

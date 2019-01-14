package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeEntity {
    @JsonProperty("status")
    private int status;
    @JsonProperty("info")
    private String info;
    @JsonProperty("infocode")
    private int infocode;
    @JsonProperty("regeocode")
    private RegeocodeEntity regeocode;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getInfocode() {
        return infocode;
    }

    public void setInfocode(int infocode) {
        this.infocode = infocode;
    }

    public RegeocodeEntity getRegeocode() {
        return regeocode;
    }

    public void setRegeocode(RegeocodeEntity regeocode) {
        this.regeocode = regeocode;
    }
}
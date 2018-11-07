package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

public class ResultEntity {

    public static final int SUCCESS = 0;
    public static final int ACCOUNT_ERROR = 1;

    @JsonProperty("code")
    private int code = 0;
    @JsonProperty("msg")
    private String msg = "";
    @JsonProperty("data")
    private Object data = null;

    public ResultEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultEntity() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

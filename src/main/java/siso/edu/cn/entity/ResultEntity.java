package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultEntity {

    @JsonProperty("result")
    private int result;
    @JsonProperty("message")
    private String message;

    public ResultEntity() {

    }

    public ResultEntity(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

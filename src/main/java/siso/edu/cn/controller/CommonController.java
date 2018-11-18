package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import siso.edu.cn.entity.ResultEntity;

public class CommonController {

    public static ResultEntity CreateResultEntity(int resCode, JsonNode data) {
        ResultEntity resultEntity = new ResultEntity();

        resultEntity.setCode(resCode);
        resultEntity.setMsg(resultEntity.getCodeMsg(resCode));
        resultEntity.setData(data);

        return resultEntity;
    }

    public static ResultEntity CreateResultEntity(int resCode) {
        ResultEntity resultEntity = new ResultEntity();

        resultEntity.setCode(resCode);
        resultEntity.setMsg(resultEntity.getCodeMsg(resCode));
        resultEntity.setData(null);

        return resultEntity;
    }

}

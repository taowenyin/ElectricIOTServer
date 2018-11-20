package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import siso.edu.cn.entity.ResultEntity;

public abstract class IControllerImpl implements IController {
    @Override
    public ResultEntity createResultEntity(int resCode, JsonNode data) {
        ResultEntity resultEntity = new ResultEntity();

        resultEntity.setCode(resCode);
        resultEntity.setMsg(resultEntity.getCodeMsg(resCode));
        resultEntity.setData(data);

        return resultEntity;
    }

    @Override
    public ResultEntity createResultEntity(int resCode) {
        ResultEntity resultEntity = new ResultEntity();

        resultEntity.setCode(resCode);
        resultEntity.setMsg(resultEntity.getCodeMsg(resCode));
        resultEntity.setData(null);

        return resultEntity;
    }
}

package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import siso.edu.cn.entity.ResultEntity;

public interface IController {

    public ResultEntity createResultEntity(int resCode, JsonNode data);

    public ResultEntity createResultEntity(int resCode);

}

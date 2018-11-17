package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class FlagEntity {
    public static final int NO_DELETE = 0; // 非删除状态
    public static final int DELETE = 1; // 删除状态
}

package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeviceTypeClassifyEntity {
    @JsonProperty("type")
    private TypeEntity typeEntity;
    @JsonProperty("devices")
    private List<DeviceEntity> deviceEntityList;

    public TypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(TypeEntity typeEntity) {
        this.typeEntity = typeEntity;
    }

    public List<DeviceEntity> getDeviceEntityList() {
        return deviceEntityList;
    }

    public void setDeviceEntityList(List<DeviceEntity> deviceEntityList) {
        this.deviceEntityList = deviceEntityList;
    }
}

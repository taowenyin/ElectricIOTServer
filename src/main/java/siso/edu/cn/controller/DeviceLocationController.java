package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import siso.edu.cn.entity.DeviceLocationEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.service.DeviceLocationService;

import java.util.List;

/**
 * @apiDefine deviceLocationGroup 设备实时位置管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class DeviceLocationController extends IControllerImpl {

    private DeviceLocationService deviceLocationService;

    @Autowired
    public DeviceLocationController(DeviceLocationService deviceLocationService) {
        this.deviceLocationService = deviceLocationService;
    }

    /**
     * @api {get} /api/manage/location/:id 根据ID获取设备位置数据
     * @apiVersion 0.0.1
     * @apiName getDeviceLocationById
     * @apiGroup deviceLocationGroup
     *
     * @apiParam {Number} id 设备ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public ResultEntity getDeviceLocationById(@PathVariable("id") long id) {
        List<DeviceLocationEntity> deviceLocationEntityList = deviceLocationService.getLocationHistory(id);

        if (deviceLocationEntityList.size() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(deviceLocationEntityList, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }
}

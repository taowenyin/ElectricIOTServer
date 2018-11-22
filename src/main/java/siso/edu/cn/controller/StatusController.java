package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.DeviceEntity;
import siso.edu.cn.entity.FlagEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.entity.StatusEntity;
import siso.edu.cn.service.StatusService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @apiDefine statusGroup 设备状态管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class StatusController extends IControllerImpl {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    /**
     * @api {post} /api/manage/status 创建新设备状态
     * @apiVersion 0.0.1
     * @apiName createStatus
     * @apiGroup statusGroup
     *
     * @apiParam {String} [name] 设备名称
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public ResultEntity createStatus(@RequestParam(name = "name") String name) {
        ObjectMapper objectMapper = new ObjectMapper();

        // 构建实体对象
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setName(name);

        // 保存并更新实体
        statusService.save(statusEntity);

        // 返回保存的结果
        if (statusEntity.getId() > 0) {
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(statusEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
    }

    /**
     * @api {delete} /api/manage/status/:id 根据ID删除设备状态
     * @apiVersion 0.0.1
     * @apiName deleteStatusById
     * @apiGroup statusGroup
     *
     * @apiParam {Number} id 状态ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/status/{id}", method = RequestMethod.DELETE)
    public ResultEntity deleteStatusById(@PathVariable("id") long id) {
        StatusEntity statusEntity = statusService.findById(id);

        if (statusEntity == null) {
            return this.createResultEntity(ResultEntity.DELETE_ERROR);
        }

        statusEntity = statusService.delete(id);
        ObjectMapper objectMapper = new ObjectMapper();

        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(statusEntity, JsonNode.class));
    }

    /**
     * @api {put} /api/manage/status 根据ID修改设备状态信息
     * @apiVersion 0.0.1
     * @apiName modifyStatusById
     * @apiGroup statusGroup
     *
     * @apiParam {Number} id 设备ID
     * @apiParam {String} [name] 设备名称
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    public ResultEntity modifyStatusById(@RequestParam("id") long id, @RequestParam("name") String name) {
        ObjectMapper objectMapper = new ObjectMapper();

        StatusEntity entity = statusService.findById(id);
        if (entity == null) {
            return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
        }

        // 构建实体对象
        entity.setName(name);
        // 保存并更新实体
        entity = statusService.update(entity);

        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(entity, JsonNode.class));
    }

    /**
     * @api {get} /api/manage/status 获取所有设备状态信息
     * @apiVersion 0.0.1
     * @apiName getAllStatus
     * @apiGroup statusGroup
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ResultEntity getAllStatus() {
        List<StatusEntity> statusEntityList = statusService.findAll();

        if (statusEntityList.size() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(statusEntityList, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }
}

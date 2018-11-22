package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.entity.TypeEntity;
import siso.edu.cn.service.TypeService;

import java.util.List;

/**
 * @apiDefine typeGroup 设备类型管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class TypeController extends IControllerImpl {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    /**
     * @api {post} /api/manage/type 创建新设备类型
     * @apiVersion 0.0.1
     * @apiName createType
     * @apiGroup typeGroup
     *
     * @apiParam {String} name 设备类型名称
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/type", method = RequestMethod.POST)
    public ResultEntity createType(@RequestParam(name = "name") String name) {
        ObjectMapper objectMapper = new ObjectMapper();

        // 构建实体对象
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setName(name);

        // 保存并更新实体
        typeService.save(typeEntity);

        // 返回保存的结果
        if (typeEntity.getId() > 0) {
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(typeEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
    }

    /**
     * @api {delete} /api/manage/type/:id 根据ID删除设备类型
     * @apiVersion 0.0.1
     * @apiName deleteTypeById
     * @apiGroup typeGroup
     *
     * @apiParam {Number} id 类型ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/type/{id}", method = RequestMethod.DELETE)
    public ResultEntity deleteTypeById(@PathVariable("id") long id) {
        TypeEntity typeEntity = typeService.findById(id);

        if (typeEntity == null) {
            return this.createResultEntity(ResultEntity.DELETE_ERROR);
        }

        typeEntity = typeService.delete(id);
        ObjectMapper objectMapper = new ObjectMapper();

        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(typeEntity, JsonNode.class));
    }

    /**
     * @api {put} /api/manage/type 根据ID修改设备类型名称
     * @apiVersion 0.0.1
     * @apiName modifyTypeById
     * @apiGroup typeGroup
     *
     * @apiParam {Number} id 设备ID
     * @apiParam {String} name 类型名称
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/type", method = RequestMethod.PUT)
    public ResultEntity modifyTypeById(@RequestParam("id") long id, @RequestParam("name") String name) {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeEntity entity = typeService.findById(id);
        if (entity == null) {
            return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
        }

        // 构建实体对象
        entity.setName(name);
        // 保存并更新实体
        entity = typeService.update(entity);

        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(entity, JsonNode.class));
    }

    /**
     * @api {get} /api/manage/type 获取所有设备类型信息
     * @apiVersion 0.0.1
     * @apiName getAllType
     * @apiGroup typeGroup
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ResultEntity getAllType() {
        List<TypeEntity> typeEntityList = typeService.findAll();

        if (typeEntityList.size() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(typeEntityList, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }
}

package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.FlagEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.entity.RoleEntity;
import siso.edu.cn.service.RoleService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @apiDefine roleGroup 角色管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class RoleController extends IControllerImpl {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * @api {post} /api/manage/role 创建角色
     * @apiVersion 0.0.1
     * @apiName createRole
     * @apiGroup roleGroup
     *
     * @apiParam {String} name 角色名称
     * @apiParam {String} [comment] 角色说明
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResultEntity createRole(@RequestParam("name") String name,
                                   @RequestParam(name = "comment", required = false, defaultValue = "") String comment) {
        // 获取时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(name);
        roleEntity.setCreateTime(simpleDateFormat.format(new Date()));
        if (!comment.isEmpty()) {
            roleEntity.setComment(comment);
        }
        roleEntity.setIsDelete(FlagEntity.NO_DELETE);
        this.roleService.save(roleEntity);

        // 返回保存的结果
        if (roleEntity.getId() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(roleEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
    }

    /**
     * @api {delete} /api/manage/role/:id 根据ID删除角色
     * @apiVersion 0.0.1
     * @apiName deleteRoleById
     * @apiGroup roleGroup
     *
     * @apiParam {Number} id 角色ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public ResultEntity deleteRoleById(@PathVariable("id") long id) {
        RoleEntity roleEntity = roleService.findById(id);

        if (roleEntity == null) {
            return this.createResultEntity(ResultEntity.DELETE_ERROR);
        }

        roleEntity.setIsDelete(FlagEntity.DELETE);
        roleEntity = roleService.update(roleEntity);

        ObjectMapper objectMapper = new ObjectMapper();

        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(roleEntity, JsonNode.class));
    }

    /**
     * @api {put} /api/manage/role 根据ID修改角色信息
     * @apiVersion 0.0.1
     * @apiName modifyRoleById
     * @apiGroup roleGroup
     *
     * @apiParam {Number} id 角色id
     * @apiParam {String} [name] 角色名称
     * @apiParam {String} [comment] 角色说明
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public ResultEntity modifyRoleById(@RequestParam("id") long id,
                                       @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                       @RequestParam(name = "comment", required = false, defaultValue = "") String comment) {
        RoleEntity entity = roleService.findById(id);

        if (entity == null) {
            return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
        }

        if (!name.isEmpty()) {
            entity.setName(name);
        }
        if (!comment.isEmpty()) {
            entity.setComment(comment);
        }

        entity = roleService.update(entity);

        ObjectMapper objectMapper = new ObjectMapper();
        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(entity, JsonNode.class));
    }

    /**
     * @api {get} /api/manage/role/:id 根据ID获取角色信息
     * @apiVersion 0.0.1
     * @apiName getRoleById
     * @apiGroup roleGroup
     *
     * @apiParam {Number} id 用户ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public ResultEntity getRoleById(@PathVariable("id") long id) {
        RoleEntity roleEntity = roleService.findById(id);

        if (roleEntity != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(roleEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }

    /**
     * @api {get} /api/manage/role 根据所有角色信息
     * @apiVersion 0.0.1
     * @apiName getAllRole
     * @apiGroup roleGroup
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResultEntity getAllRole() {
        List<RoleEntity> roleEntityList = roleService.findAll();

        if (roleEntityList.size() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(roleEntityList, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }

}

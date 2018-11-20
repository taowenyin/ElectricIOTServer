package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.DepartmentEntity;
import siso.edu.cn.entity.FlagEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.service.DepartmentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @apiDefine departmentGroup 部门管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class DepartmentController extends IControllerImpl {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * @api {post} /api/manage/department 创建新部门
     * @apiVersion 0.0.1
     * @apiName createDepartment
     * @apiGroup departmentGroup
     *
     * @apiParam {String} name 部门名称
     * @apiParam {Number} level 部门层级
     * @apiParam {Number} parent_id="0" 父部门ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public ResultEntity createDepartment(@RequestParam("name") String name, @RequestParam("level") int level,
                                         @RequestParam("parent_id") long parentId) {
        // 获取时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 构建实体对象
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(name);
        departmentEntity.setLevel(level);
        departmentEntity.setCreateTime(simpleDateFormat.format(new Date()));
        departmentEntity.setParentId(parentId);

        // 保存并更新实体
        departmentService.save(departmentEntity);

        // 返回保存的结果
        if (departmentEntity.getId() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(departmentEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
    }

    /**
     * @api {delete} /api/manage/department/:id 根据ID删除部门
     * @apiVersion 0.0.1
     * @apiName deleteDepartmentById
     * @apiGroup departmentGroup
     *
     * @apiParam {Number} id 部门ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public ResultEntity deleteDepartmentById(@PathVariable("id") long id) {
        DepartmentEntity departmentEntity = departmentService.findById(id);

        if (departmentEntity == null) {
            return this.createResultEntity(ResultEntity.DELETE_ERROR);
        }

        departmentEntity.setIsDelete(FlagEntity.DELETE);
        departmentEntity = departmentService.update(departmentEntity);
        ObjectMapper objectMapper = new ObjectMapper();

        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(departmentEntity, JsonNode.class));
    }


    /**
     * @api {put} /api/manage/department 根据ID修改部门信息
     * @apiVersion 0.0.1
     * @apiName modifyDepartmentById
     * @apiGroup departmentGroup
     *
     * @apiParam {Number} id 部门id
     * @apiParam {String} [name] 部门名称
     * @apiParam {Number} [level] 部门层级
     * @apiParam {Number} [parent_id] 上级部门ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    public ResultEntity modifyDepartmentById(@RequestParam("id") long id,
                                             @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                             @RequestParam(name = "level", required = false, defaultValue = "-1") int level,
                                             @RequestParam(name = "parent_id", required = false, defaultValue = "-1") long parentId) {
        DepartmentEntity entity = departmentService.findById(id);

        if (entity == null) {
            return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
        }

        // 更新数据
        if (!name.isEmpty()) {
            entity.setName(name);
        }
        if (level != -1) {
            entity.setLevel(level);
        }
        if (parentId != -1) {
            entity.setParentId(parentId);
        }

        entity = departmentService.update(entity);

        ObjectMapper objectMapper = new ObjectMapper();
        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(entity, JsonNode.class));
    }

    /**
     * @api {get} /api/manage/department/:id 根据ID获取部门信息
     * @apiVersion 0.0.1
     * @apiName getDepartmentById
     * @apiGroup departmentGroup
     *
     * @apiParam {Number} id 部门ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public ResultEntity getDepartmentById(@PathVariable("id") long id) {
        DepartmentEntity departmentEntity = departmentService.findById(id);

        if (departmentEntity != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(departmentEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }

    /**
     * @api {get} /api/manage/department 获取部门组织结构
     * @apiVersion 0.0.1
     * @apiName getDepartment
     * @apiGroup departmentGroup
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResultEntity getDepartment() {
        return this.createResultEntity(ResultEntity.SUCCESS, departmentService.getOrganizationStructure());
    }
}

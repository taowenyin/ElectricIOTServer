package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.DepartmentEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.service.DepartmentService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @apiDefine departmentGroup 部门管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class DepartmentController {

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
        ResultEntity resultEntity = new ResultEntity();

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
        if (departmentEntity.getId() != 0) {
            resultEntity.setCode(ResultEntity.SUCCESS);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode data = objectMapper.createObjectNode();
            data.put("id", departmentEntity.getId());
            resultEntity.setData(data);
        } else {
            resultEntity.setCode(ResultEntity.SAVE_DATA_ERROR);
        }

        return resultEntity;
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
        ResultEntity resultEntity = new ResultEntity();

        DepartmentEntity departmentEntity = departmentService.findById(id);

        if (departmentEntity == null) {
            resultEntity.setCode(ResultEntity.DELETE_ERROR);
            return resultEntity;
        }

        departmentEntity.setIsDelete(1);
        departmentEntity = departmentService.update(departmentEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        resultEntity.setCode(ResultEntity.SUCCESS);
        resultEntity.setData(objectMapper.convertValue(departmentEntity, JsonNode.class));

        return resultEntity;
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
        ResultEntity resultEntity = new ResultEntity();

        DepartmentEntity entity = departmentService.findById(id);

        if (entity == null) {
            resultEntity.setCode(ResultEntity.NOT_FIND_ERROR);
            return resultEntity;
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

        DepartmentEntity departmentEntity = departmentService.update(entity);

        ObjectMapper objectMapper = new ObjectMapper();
        resultEntity.setCode(ResultEntity.SUCCESS);
        resultEntity.setData(objectMapper.convertValue(departmentEntity, JsonNode.class));

        return resultEntity;
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
        ResultEntity resultEntity = new ResultEntity();

        DepartmentEntity departmentEntity = departmentService.findById(id);

        if (departmentEntity != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            resultEntity.setCode(ResultEntity.SUCCESS);
            try {
                resultEntity.setData(objectMapper.readTree(objectMapper.writeValueAsString(departmentEntity)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            resultEntity.setCode(ResultEntity.NOT_FIND_ERROR);
        }

        return resultEntity;
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
        ResultEntity resultEntity = new ResultEntity();

        resultEntity.setCode(ResultEntity.SUCCESS);
        resultEntity.setData(departmentService.getOrganizationStructure());

        return resultEntity;
    }
}

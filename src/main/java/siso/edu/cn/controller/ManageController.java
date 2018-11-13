package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.DepartmentEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.service.DepartmentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @apiDefine group 管理接口
 * @apiDefine version 0.0.1
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class ManageController {

    private DepartmentService departmentService;

    @Autowired
    public ManageController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

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
     * @api {get} /api/manage/department/:id 根据ID获取部门信息
     * @apiName getDepartmentById
     * @apiGroup group
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
            resultEntity.setData(objectMapper.convertValue(departmentEntity, JsonNode.class));
        } else {
            resultEntity.setCode(ResultEntity.NOT_FIND_ERROR);
        }

        return resultEntity;
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public ResultEntity deleteDepartmentById(@PathVariable("id") long id) {
        ResultEntity resultEntity = new ResultEntity();

        DepartmentEntity departmentEntity = departmentService.findById(id);

        if (departmentEntity == null) {
            resultEntity.setCode(ResultEntity.DELETE_ERROR);
            return resultEntity;
        }

        departmentEntity.setDelete(true);
        departmentEntity = departmentService.update(departmentEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        resultEntity.setCode(ResultEntity.SUCCESS);
        resultEntity.setData(objectMapper.convertValue(departmentEntity, JsonNode.class));

        return resultEntity;
    }
}

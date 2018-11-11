package siso.edu.cn.controller;

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

@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class ManageController {

    private DepartmentService departmentService;

    @Autowired
    public ManageController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public ResultEntity department(@RequestParam("name") String name, @RequestParam("level") int level, @RequestParam("parent_id") long parentId) {
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

//    @RequestMapping(value = "/department", method = RequestMethod.GET)
//    public ResultEntity department(@RequestParam("id") long id) {
//        ResultEntity resultEntity = new ResultEntity();
//
//        DepartmentEntity departmentEntity = departmentService.findById(id);
//
//        return resultEntity;
//    }

//    @RequestMapping(value = "/{loginName}/{loginPassword}", method = RequestMethod.GET)
//    @ResponseBody
//    public String login(@PathVariable("loginName") String loginName, @PathVariable("loginPassword") String loginPassword) {
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        String data = simpleDateFormat.format(new Date());
//
//        return "用户名 = " + loginName + " 密码 = " + loginPassword;
//    }
}

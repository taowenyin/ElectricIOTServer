package siso.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.dao.DepartmentDao;
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
    public ResultEntity department(@RequestParam("name") String name, @RequestParam("level") int level,
                                   @RequestParam("user_id") long userId, @RequestParam("parent_id") long parentId) {
        ResultEntity resultEntity = new ResultEntity();

        // 获取时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setUid(4);
        departmentEntity.setName(name);
        departmentEntity.setLevel(level);
        departmentEntity.setCreateTime(simpleDateFormat.format(new Date()));
        departmentEntity.setModifyTime(simpleDateFormat.format(new Date()));
        departmentEntity.setModifyUserId(userId);
        departmentEntity.setCreateUserId(userId);
        departmentEntity.setParentId(parentId);

        departmentService.save(departmentEntity);

        long id = departmentEntity.getId();

        return resultEntity;
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResultEntity department(@RequestParam("id") long id) {
        ResultEntity resultEntity = new ResultEntity();

        DepartmentEntity departmentEntity = departmentService.findById(id);

        return resultEntity;
    }

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

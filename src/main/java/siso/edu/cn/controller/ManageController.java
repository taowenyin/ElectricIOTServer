package siso.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import siso.edu.cn.dao.DepartmentDao;

@Controller
@RequestMapping(value = "/api/manage", produces = "text/json;charset=UTF-8")
public class ManageController {

    private DepartmentDao departmentDao;

    @Autowired
    public ManageController(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @RequestMapping(value = "/{loginName}/{loginPassword}", method = RequestMethod.GET)
    @ResponseBody
    public String login(@PathVariable("loginName") String loginName, @PathVariable("loginPassword") String loginPassword) {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        String data = simpleDateFormat.format(new Date());

        return "用户名 = " + loginName + " 密码 = " + loginPassword;
    }
}

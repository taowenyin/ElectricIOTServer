package siso.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.entity.UserEntity;
import siso.edu.cn.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/login", produces = "application/json")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultEntity login(@RequestBody UserEntity userEntity) {
        ResultEntity resultEntity = new ResultEntity();

        if (userService.loginCheck(userEntity)) {
            resultEntity.setCode(ResultEntity.SUCCESS);
        } else {
            resultEntity.setCode(ResultEntity.ACCOUNT_ERROR);
        }

        return resultEntity;
    }

}

package siso.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.entity.UserEntity;
import siso.edu.cn.service.UserService;

import java.util.List;

/**
 * @apiDefine userGroup 用户接口
 */
@RestController
@RequestMapping(value = "/api/login", produces = "application/json")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @api {post} /api/login/ 用户登录
     * @apiVersion 0.0.1
     * @apiName login
     * @apiGroup userGroup
     *
     * @apiParam {String} login_name  登录用户名
     * @apiParam {String} login_password  登录用户密码
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultEntity login(@RequestParam("login_name") String loginName, @RequestParam("login_password") String loginPassword) {
        ResultEntity resultEntity = new ResultEntity();

        UserEntity userEntity = new UserEntity();
        userEntity.setLoginName(loginName);
        userEntity.setLoginPassword(loginPassword);

        if (userService.loginCheck(userEntity)) {
            resultEntity.setCode(ResultEntity.SUCCESS);
        } else {
            resultEntity.setCode(ResultEntity.ACCOUNT_ERROR);
        }

        return resultEntity;
    }

}

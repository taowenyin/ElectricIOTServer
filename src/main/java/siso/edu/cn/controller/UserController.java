package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siso.edu.cn.entity.FlagEntity;
import siso.edu.cn.entity.ResultEntity;
import siso.edu.cn.entity.UserEntity;
import siso.edu.cn.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @apiDefine userGroup 用户管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @api {post} /api/manage/user 创建新用户
     * @apiVersion 0.0.1
     * @apiName createUser
     * @apiGroup userGroup
     *
     * @apiParam {String} login_name 用户账号
     * @apiParam {String} login_password 用户密码
     * @apiParam {String} name 用户名
     * @apiParam {String} [mobile] 用户手机号
     * @apiParam {String} [email] 用户邮箱
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultEntity createUser(@RequestParam("login_name") String loginName,
                                   @RequestParam("login_password") String loginPassword,
                                   @RequestParam("name") String name,
                                   @RequestParam(name = "mobile", required = false, defaultValue = "") String mobile,
                                   @RequestParam(name = "email", required = false, defaultValue = "") String email) {
        ResultEntity resultEntity = new ResultEntity();

        // 获取时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        UserEntity userEntity = new UserEntity();
        userEntity.setLoginName(loginName);
        userEntity.setLoginPassword(loginPassword);
        userEntity.setName(name);
        // 获取当前时间和日期
        userEntity.setCreateTime(simpleDateFormat.format(new Date()));
        if (!mobile.isEmpty()) {
            userEntity.setMobile(mobile);
        }
        if (!email.isEmpty()) {
            userEntity.setEmail(email);
        }
        userEntity.setIsDelete(FlagEntity.NO_DELETE);

        this.userService.save(userEntity);

        // 返回保存的结果
        if (userEntity.getId() != 0) {
            resultEntity.setCode(ResultEntity.SUCCESS);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode data = objectMapper.createObjectNode();
            data.put("id", userEntity.getId());
            resultEntity.setData(data);
        } else {
            resultEntity.setCode(ResultEntity.SAVE_DATA_ERROR);
        }

        return resultEntity;
    }

}

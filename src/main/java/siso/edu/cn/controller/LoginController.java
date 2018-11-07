package siso.edu.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import siso.edu.cn.entity.UserEntity;
import siso.edu.cn.service.UserService;

@RestController
@RequestMapping(value = "/api/login", produces = "application/json")
public class LoginController {

    private UserService userDao;

    @Autowired
    public LoginController(UserService userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserEntity login(@RequestBody UserEntity userEntity) {

        UserEntity entity = userDao.findById(1);

//        String msg = userEntity.getLoginName() + " " + userEntity.getLoginPassword();

//        Serializable serializable = userDao.save(userEntity);

        return userEntity;
    }

}

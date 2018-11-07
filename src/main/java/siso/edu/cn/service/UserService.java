package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import siso.edu.cn.dao.UserDao;
import siso.edu.cn.entity.UserEntity;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService extends IServiceImpl<UserEntity> {
    public final static String SQL_LOGIN_CHECK =
            "SELECT user FROM UserEntity as user WHERE user.loginName='?1' AND user.loginPassword='?2'";

    private UserDao userDao = null;

    @Autowired
    public UserService(UserDao userDao) {
        super(userDao);

        this.userDao = userDao;
    }

    public boolean loginCheck(UserEntity userEntity) {
        List<UserEntity> userEntityList = userDao.findByParams(SQL_LOGIN_CHECK,
                new String[] {userEntity.getLoginName(), userEntity.getLoginPassword()});

        return false;
    }
}

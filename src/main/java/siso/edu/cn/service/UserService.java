package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.dao.UserDao;
import siso.edu.cn.entity.UserEntity;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService extends IServiceImpl<UserEntity> {

    @Autowired
    public UserService(UserDao userDao) {
        super(userDao);
    }
}

package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.UserDepartmentRelationDao;
import siso.edu.cn.entity.UserDepartmentRelationEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDepartmentRelationService extends IServiceImpl<UserDepartmentRelationEntity> {

    private UserDepartmentRelationDao dao;

    @Autowired
    public UserDepartmentRelationService(UserDepartmentRelationDao dao) {
        super(dao);

        this.dao = dao;
    }

}

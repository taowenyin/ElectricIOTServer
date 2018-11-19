package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.BindUserDepartmentRoleDao;
import siso.edu.cn.entity.BindUserDepartmentRoleEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BindUserDepartmentRoleService extends IServiceImpl<BindUserDepartmentRoleEntity> {

    private BindUserDepartmentRoleDao dao;

    @Autowired
    public BindUserDepartmentRoleService(BindUserDepartmentRoleDao dao) {
        super(dao);

        this.dao = dao;
    }

}

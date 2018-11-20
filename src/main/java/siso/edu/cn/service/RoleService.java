package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.RoleDao;
import siso.edu.cn.entity.RoleEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RoleService extends IServiceImpl<RoleEntity> {

    private RoleDao dao = null;

    @Autowired
    public RoleService(RoleDao dao) {
        super(dao);

        this.dao = dao;
    }

}

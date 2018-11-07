package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DepartmentDao;
import siso.edu.cn.entity.DepartmentEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentService extends IServiceImpl<DepartmentEntity> {

    private DepartmentDao departmentDao = null;

    @Autowired
    public DepartmentService(DepartmentDao dao) {
        super(dao);
        this.departmentDao = dao;
    }

}

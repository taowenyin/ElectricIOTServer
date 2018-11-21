package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.BindUserDepartmentRoleDao;
import siso.edu.cn.entity.BindUserDepartmentRoleEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BindUserDepartmentRoleService extends IServiceImpl<BindUserDepartmentRoleEntity> {

    public final static String SQL_FIND_BY_USER_DEPARTMENT =
            "SELECT bind FROM BindUserDepartmentRoleEntity bind WHERE bind.userId = ?1 AND bind.departmentId = ?2";

    private BindUserDepartmentRoleDao dao;

    @Autowired
    public BindUserDepartmentRoleService(BindUserDepartmentRoleDao dao) {
        super(dao);

        this.dao = dao;
    }

    public List<BindUserDepartmentRoleEntity> getBindUserDepartmentEntity(Long userId, Long departmentId) {
        List<BindUserDepartmentRoleEntity> bindUserDepartmentRoleEntityList = this.dao.findByParams(
                SQL_FIND_BY_USER_DEPARTMENT, new Object[] {userId, departmentId});

        return bindUserDepartmentRoleEntityList;
    }

}

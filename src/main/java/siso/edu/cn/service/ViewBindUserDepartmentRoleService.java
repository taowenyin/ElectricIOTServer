package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.ViewBindUserDepartmentRoleDao;
import siso.edu.cn.entity.ViewBindUserDepartmentRoleEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ViewBindUserDepartmentRoleService extends IServiceImpl<ViewBindUserDepartmentRoleEntity> {

    public final static String SQL_FIND_BY_DEPARTMENT_ID =
            "SELECT bind FROM ViewBindUserDepartmentRoleEntity bind WHERE bind.departmentId = ?1";

    private ViewBindUserDepartmentRoleDao dao;

    @Autowired
    public ViewBindUserDepartmentRoleService(ViewBindUserDepartmentRoleDao dao) {
        super(dao);
        this.dao = dao;
    }

    public List<ViewBindUserDepartmentRoleEntity> getUserByDepartmentId(Long departmentId) {
        List<ViewBindUserDepartmentRoleEntity> userList = this.dao.findByParams(SQL_FIND_BY_DEPARTMENT_ID, new Object[]{departmentId});

        return userList;
    }
}

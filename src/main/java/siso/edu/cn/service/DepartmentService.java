package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DepartmentDao;
import siso.edu.cn.entity.DepartmentEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentService extends IServiceImpl<DepartmentEntity> {

    public final static String SQL_MAX_LEVEL =
            "SELECT max(department.level) FROM DepartmentEntity as department";

    private DepartmentDao departmentDao = null;

    @Autowired
    public DepartmentService(DepartmentDao dao) {
        super(dao);
        this.departmentDao = dao;
    }

    /**
     * 获取层级的最大值，从0开始
     * @return 最大值层级值
     */
    public int maxLevel() {
        return departmentDao.findMaxValue(SQL_MAX_LEVEL);
    }
}

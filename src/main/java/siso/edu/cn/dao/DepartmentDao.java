package siso.edu.cn.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.entity.DepartmentEntity;

@Transactional
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentDao extends IDaoImpl<DepartmentEntity> {

}

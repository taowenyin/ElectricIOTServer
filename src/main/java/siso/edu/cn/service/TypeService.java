package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.TypeDao;
import siso.edu.cn.entity.TypeEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TypeService extends IServiceImpl<TypeEntity> {
    private TypeDao dao;

    @Autowired
    public TypeService(TypeDao dao) {
        super(dao);
        this.dao = dao;
    }
}

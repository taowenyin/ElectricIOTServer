package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.dao.StatusDao;
import siso.edu.cn.entity.StatusEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StatusService extends IServiceImpl<StatusEntity> {
    private StatusDao dao;

    @Autowired
    public StatusService(StatusDao dao) {
        super(dao);
        this.dao = dao;
    }
}

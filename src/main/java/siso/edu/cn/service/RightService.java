package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.RightDao;
import siso.edu.cn.entity.RightEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RightService extends IServiceImpl<RightEntity> {
    private RightDao dao;

    @Autowired
    public RightService(RightDao dao) {
        super(dao);

        this.dao = dao;
    }
}

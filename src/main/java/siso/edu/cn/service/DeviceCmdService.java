package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DeviceCmdDao;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.entity.DeviceCmdEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeviceCmdService extends IServiceImpl<DeviceCmdEntity> {

    private DeviceCmdDao dao;

    @Autowired
    public DeviceCmdService(DeviceCmdDao dao) {
        super(dao);

        this.dao = dao;
    }


}

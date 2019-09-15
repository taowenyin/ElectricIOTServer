package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.ReceiveDeviceDataDao;
import siso.edu.cn.entity.ReceiveDeviceDataEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReceiveDeviceDataService extends IServiceImpl<ReceiveDeviceDataEntity> {

    private ReceiveDeviceDataDao dao;

    @Autowired
    public ReceiveDeviceDataService(ReceiveDeviceDataDao dao) {
        super(dao);

        this.dao = dao;
    }

}

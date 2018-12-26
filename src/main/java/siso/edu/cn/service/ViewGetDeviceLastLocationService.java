package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.dao.ViewGetDeviceLastLocationDao;
import siso.edu.cn.entity.ViewGetDeviceLastLocationEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ViewGetDeviceLastLocationService extends IServiceImpl<ViewGetDeviceLastLocationEntity> {

    private ViewGetDeviceLastLocationDao dao;

    @Autowired
    public ViewGetDeviceLastLocationService(ViewGetDeviceLastLocationDao dao) {
        super(dao);

        this.dao = dao;
    }

}

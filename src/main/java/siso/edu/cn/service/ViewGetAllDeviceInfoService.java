package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.dao.ViewGetAllDeviceInfoDao;
import siso.edu.cn.entity.ViewGetAllDeviceInfoEntity;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ViewGetAllDeviceInfoService extends IServiceImpl<ViewGetAllDeviceInfoEntity> {

    private ViewGetAllDeviceInfoDao dao;

    @Autowired
    public ViewGetAllDeviceInfoService(ViewGetAllDeviceInfoDao dao) {
        super(dao);

        this.dao = dao;
    }

}

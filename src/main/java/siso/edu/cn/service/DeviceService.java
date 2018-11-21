package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DeviceDao;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.entity.DeviceEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeviceService extends IServiceImpl<DeviceEntity> {
    public final static String SQL_FIND_DEVICE_BY_IMSI =
            "SELECT device FROM DeviceEntity device WHERE device.imsi = ?1";

    private DeviceDao dao;

    @Autowired
    public DeviceService(DeviceDao dao) {
        super(dao);

        this.dao = dao;
    }

    public List<DeviceEntity> findDeviceByImsi(String imsi) {
        return this.dao.findByParams(SQL_FIND_DEVICE_BY_IMSI, new Object[]{imsi});
    }
}

package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DeviceLocationDao;
import siso.edu.cn.dao.IDaoImpl;
import siso.edu.cn.entity.DeviceLocationEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeviceLocationService extends IServiceImpl<DeviceLocationEntity> {

    public final static String SQL_GET_LOCATION_BY_DEVICE_ID =
            "SELECT location FROM DeviceLocationEntity location WHERE location.deviceId = ?1";

    public final static String SQL_GET_PREVIOUS_DATA_BY_DEVICE_ID =
            "SELECT location FROM DeviceLocationEntity location WHERE location.isDelete != 1 AND location.deviceId = ?1 AND location.id < ?2 ORDER BY location.id DESC";

    private DeviceLocationDao deviceLocationDao;

    @Autowired
    public DeviceLocationService(DeviceLocationDao dao) {
        super(dao);

        this.deviceLocationDao = dao;
    }

    /**
     * 根据设备ID获取运行位置
     * @param deviceId 设备ID
     * @return 设备位置列表信息
     */
    public List<DeviceLocationEntity> getLocationHistory(long deviceId) {
        return this.deviceLocationDao.findByParams(SQL_GET_LOCATION_BY_DEVICE_ID, new Object[]{deviceId});
    }

    /**
     * 获取当前数据的上一条数据
     * @param deviceId 设备ID
     * @param currentId 当前数据ID
     * @return 设备位置列表信息
     */
    public List<DeviceLocationEntity> getPreviousData(long deviceId, long currentId) {
        return this.deviceLocationDao.findByParams(SQL_GET_PREVIOUS_DATA_BY_DEVICE_ID, new Object[]{deviceId, currentId}, 1);
    }
}

package siso.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.ReceiveDeviceDataDao;
import siso.edu.cn.entity.ReceiveDeviceDataEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReceiveDeviceDataService extends IServiceImpl<ReceiveDeviceDataEntity> {

    public final static String SQL_FIND_COMMAND_BY_DEVICE =
            "SELECT receive FROM ReceiveDeviceDataEntity receive WHERE receive.deviceId = ?1 AND receive.isRead = 0 ORDER BY receive.createTime ASC";

    private ReceiveDeviceDataDao dao;

    @Autowired
    public ReceiveDeviceDataService(ReceiveDeviceDataDao dao) {
        super(dao);

        this.dao = dao;
    }

    public List<ReceiveDeviceDataEntity> getCommandDataList(Long deviceId) {
        return this.dao.findByParams(SQL_FIND_COMMAND_BY_DEVICE, new Object[] {deviceId}, 5);
    }

}

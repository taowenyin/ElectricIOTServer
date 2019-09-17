package siso.edu.cn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "receive_device_data", schema = "electric_iot", catalog = "")
public class ReceiveDeviceDataEntity {
    private long id;
    private String receiveData;
    private long deviceId;
    private int isRead;
    private String createTime;
    private DeviceEntity deviceByDeviceId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "receive_data", nullable = false, length = 45)
    public String getReceiveData() {
        return receiveData;
    }

    public void setReceiveData(String receiveData) {
        this.receiveData = receiveData;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "is_read", nullable = false)
    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiveDeviceDataEntity that = (ReceiveDeviceDataEntity) o;
        return id == that.id &&
                deviceId == that.deviceId &&
                isRead == that.isRead &&
                Objects.equals(receiveData, that.receiveData) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, receiveData, deviceId, isRead, createTime);
    }

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public DeviceEntity getDeviceByDeviceId() {
        return deviceByDeviceId;
    }

    public void setDeviceByDeviceId(DeviceEntity deviceByDeviceId) {
        this.deviceByDeviceId = deviceByDeviceId;
    }
}

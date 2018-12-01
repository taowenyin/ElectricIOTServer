package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "device_cmd", schema = "electric_iot", catalog = "")
public class DeviceCmdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("device_id")
    private long deviceId;
    @JsonProperty("get_imsi")
    private Integer getImsi;
    @JsonProperty("set_device_name")
    private String setDeviceName;
    @JsonProperty("get_device_name")
    private Integer getDeviceName;
    @JsonProperty("set_device_ip")
    private String setDeviceIp;
    @JsonProperty("set_device_port")
    private Integer setDevicePort;
    @JsonProperty("get_device_ip")
    private Integer getDeviceIp;
    @JsonProperty("get_device_port")
    private Integer getDevicePort;
    @JsonProperty("set_gps_record_interval")
    private Integer setGpsRecordInterval;
    @JsonProperty("get_gps_record_interval")
    private Integer getGpsRecordInterval;
    @JsonProperty("set_gps_send_interval")
    private Integer setGpsSendInterval;
    @JsonProperty("get_gps_send_interval")
    private Integer getGpsSendInterval;
    @JsonProperty("reset_device")
    private Integer resetDevice;
    @JsonProperty("set_power_tcp_live_interval")
    private Integer setPowerTcpLiveInterval;
    @JsonProperty("get_power_tcp_live_interval")
    private Integer getPowerTcpLiveInterval;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("send_time")
    private String sendTime;
    @JsonProperty("is_send")
    private Integer isSend;
    @JsonIgnore
    private DeviceEntity deviceByDeviceId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "get_imsi", nullable = true)
    public Integer getGetImsi() {
        return getImsi;
    }

    public void setGetImsi(Integer getImsi) {
        this.getImsi = getImsi;
    }

    @Basic
    @Column(name = "set_device_name", nullable = true, length = 45)
    public String getSetDeviceName() {
        return setDeviceName;
    }

    public void setSetDeviceName(String setDeviceName) {
        this.setDeviceName = setDeviceName;
    }

    @Basic
    @Column(name = "get_device_name", nullable = true)
    public Integer getGetDeviceName() {
        return getDeviceName;
    }

    public void setGetDeviceName(Integer getDeviceName) {
        this.getDeviceName = getDeviceName;
    }

    @Basic
    @Column(name = "set_device_ip", nullable = true, length = 45)
    public String getSetDeviceIp() {
        return setDeviceIp;
    }

    public void setSetDeviceIp(String setDeviceIp) {
        this.setDeviceIp = setDeviceIp;
    }

    @Basic
    @Column(name = "set_device_port", nullable = true)
    public Integer getSetDevicePort() {
        return setDevicePort;
    }

    public void setSetDevicePort(Integer setDevicePort) {
        this.setDevicePort = setDevicePort;
    }

    @Basic
    @Column(name = "get_device_ip", nullable = true)
    public Integer getGetDeviceIp() {
        return getDeviceIp;
    }

    public void setGetDeviceIp(Integer getDeviceIp) {
        this.getDeviceIp = getDeviceIp;
    }

    @Basic
    @Column(name = "get_device_port", nullable = true)
    public Integer getGetDevicePort() {
        return getDevicePort;
    }

    public void setGetDevicePort(Integer getDevicePort) {
        this.getDevicePort = getDevicePort;
    }

    @Basic
    @Column(name = "set_gps_record_interval", nullable = true)
    public Integer getSetGpsRecordInterval() {
        return setGpsRecordInterval;
    }

    public void setSetGpsRecordInterval(Integer setGpsRecordInterval) {
        this.setGpsRecordInterval = setGpsRecordInterval;
    }

    @Basic
    @Column(name = "get_gps_record_interval", nullable = true)
    public Integer getGetGpsRecordInterval() {
        return getGpsRecordInterval;
    }

    public void setGetGpsRecordInterval(Integer getGpsRecordInterval) {
        this.getGpsRecordInterval = getGpsRecordInterval;
    }

    @Basic
    @Column(name = "set_gps_send_interval", nullable = true)
    public Integer getSetGpsSendInterval() {
        return setGpsSendInterval;
    }

    public void setSetGpsSendInterval(Integer setGpsSendInterval) {
        this.setGpsSendInterval = setGpsSendInterval;
    }

    @Basic
    @Column(name = "get_gps_send_interval", nullable = true)
    public Integer getGetGpsSendInterval() {
        return getGpsSendInterval;
    }

    public void setGetGpsSendInterval(Integer getGpsSendInterval) {
        this.getGpsSendInterval = getGpsSendInterval;
    }

    @Basic
    @Column(name = "reset_device", nullable = true)
    public Integer getResetDevice() {
        return resetDevice;
    }

    public void setResetDevice(Integer resetDevice) {
        this.resetDevice = resetDevice;
    }

    @Basic
    @Column(name = "set_power_tcp_live_interval", nullable = true)
    public Integer getSetPowerTcpLiveInterval() {
        return setPowerTcpLiveInterval;
    }

    public void setSetPowerTcpLiveInterval(Integer setPowerTcpLiveInterval) {
        this.setPowerTcpLiveInterval = setPowerTcpLiveInterval;
    }

    @Basic
    @Column(name = "get_power_tcp_live_interval", nullable = true)
    public Integer getGetPowerTcpLiveInterval() {
        return getPowerTcpLiveInterval;
    }

    public void setGetPowerTcpLiveInterval(Integer getPowerTcpLiveInterval) {
        this.getPowerTcpLiveInterval = getPowerTcpLiveInterval;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "send_time", nullable = true)
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Basic
    @Column(name = "is_send", nullable = true)
    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceCmdEntity that = (DeviceCmdEntity) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (getImsi != null ? !getImsi.equals(that.getImsi) : that.getImsi != null) return false;
        if (setDeviceName != null ? !setDeviceName.equals(that.setDeviceName) : that.setDeviceName != null)
            return false;
        if (getDeviceName != null ? !getDeviceName.equals(that.getDeviceName) : that.getDeviceName != null)
            return false;
        if (setDeviceIp != null ? !setDeviceIp.equals(that.setDeviceIp) : that.setDeviceIp != null) return false;
        if (setDevicePort != null ? !setDevicePort.equals(that.setDevicePort) : that.setDevicePort != null)
            return false;
        if (getDeviceIp != null ? !getDeviceIp.equals(that.getDeviceIp) : that.getDeviceIp != null) return false;
        if (getDevicePort != null ? !getDevicePort.equals(that.getDevicePort) : that.getDevicePort != null)
            return false;
        if (setGpsRecordInterval != null ? !setGpsRecordInterval.equals(that.setGpsRecordInterval) : that.setGpsRecordInterval != null)
            return false;
        if (getGpsRecordInterval != null ? !getGpsRecordInterval.equals(that.getGpsRecordInterval) : that.getGpsRecordInterval != null)
            return false;
        if (setGpsSendInterval != null ? !setGpsSendInterval.equals(that.setGpsSendInterval) : that.setGpsSendInterval != null)
            return false;
        if (getGpsSendInterval != null ? !getGpsSendInterval.equals(that.getGpsSendInterval) : that.getGpsSendInterval != null)
            return false;
        if (resetDevice != null ? !resetDevice.equals(that.resetDevice) : that.resetDevice != null) return false;
        if (setPowerTcpLiveInterval != null ? !setPowerTcpLiveInterval.equals(that.setPowerTcpLiveInterval) : that.setPowerTcpLiveInterval != null)
            return false;
        if (getPowerTcpLiveInterval != null ? !getPowerTcpLiveInterval.equals(that.getPowerTcpLiveInterval) : that.getPowerTcpLiveInterval != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;
        if (isSend != null ? !isSend.equals(that.isSend) : that.isSend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (getImsi != null ? getImsi.hashCode() : 0);
        result = 31 * result + (setDeviceName != null ? setDeviceName.hashCode() : 0);
        result = 31 * result + (getDeviceName != null ? getDeviceName.hashCode() : 0);
        result = 31 * result + (setDeviceIp != null ? setDeviceIp.hashCode() : 0);
        result = 31 * result + (setDevicePort != null ? setDevicePort.hashCode() : 0);
        result = 31 * result + (getDeviceIp != null ? getDeviceIp.hashCode() : 0);
        result = 31 * result + (getDevicePort != null ? getDevicePort.hashCode() : 0);
        result = 31 * result + (setGpsRecordInterval != null ? setGpsRecordInterval.hashCode() : 0);
        result = 31 * result + (getGpsRecordInterval != null ? getGpsRecordInterval.hashCode() : 0);
        result = 31 * result + (setGpsSendInterval != null ? setGpsSendInterval.hashCode() : 0);
        result = 31 * result + (getGpsSendInterval != null ? getGpsSendInterval.hashCode() : 0);
        result = 31 * result + (resetDevice != null ? resetDevice.hashCode() : 0);
        result = 31 * result + (setPowerTcpLiveInterval != null ? setPowerTcpLiveInterval.hashCode() : 0);
        result = 31 * result + (getPowerTcpLiveInterval != null ? getPowerTcpLiveInterval.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        result = 31 * result + (isSend != null ? isSend.hashCode() : 0);
        return result;
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

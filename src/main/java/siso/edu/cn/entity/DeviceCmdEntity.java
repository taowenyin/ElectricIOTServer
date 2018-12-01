package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "device_cmd", schema = "electric_iot", catalog = "")
public class DeviceCmdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("device_id")
    private long deviceId;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("get_imsi")
    private Integer getImsi;
    @JsonProperty("set_device_name")
    private String setDeviceName;
    @JsonProperty("get_device_name")
    private Integer getDeviceName;
    @JsonProperty("set_device_ip")
    private String setDeviceIp;
    @JsonProperty("get_device_ip")
    private Integer getDeviceIp;
    @JsonProperty("set_gps_record_interval")
    private Integer setGpsRecordInterval;
    @JsonProperty("get_gps_record_interval")
    private Integer getGpsRecordInterval;
    @JsonProperty("set_gprs_send_interval")
    private Integer setGprsSendInterval;
    @JsonProperty("get_gprs_send_interval")
    private Integer getGprsSendInterval;
    @JsonProperty("reset_device")
    private Integer resetDevice;
    @JsonProperty("set_power_tcp_live_interval")
    private Integer setPowerTcpLiveInterval;
    @JsonProperty("get_power_tcp_live_interval")
    private Integer getPowerTcpLiveInterval;
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
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
    @Column(name = "get_device_ip", nullable = true)
    public Integer getGetDeviceIp() {
        return getDeviceIp;
    }

    public void setGetDeviceIp(Integer getDeviceIp) {
        this.getDeviceIp = getDeviceIp;
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
    @Column(name = "set_gprs_send_interval", nullable = true)
    public Integer getSetGprsSendInterval() {
        return setGprsSendInterval;
    }

    public void setSetGprsSendInterval(Integer setGprsSendInterval) {
        this.setGprsSendInterval = setGprsSendInterval;
    }

    @Basic
    @Column(name = "get_gprs_send_interval", nullable = true)
    public Integer getGetGprsSendInterval() {
        return getGprsSendInterval;
    }

    public void setGetGprsSendInterval(Integer getGprsSendInterval) {
        this.getGprsSendInterval = getGprsSendInterval;
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
        return id == that.id &&
                deviceId == that.deviceId &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(getImsi, that.getImsi) &&
                Objects.equals(setDeviceName, that.setDeviceName) &&
                Objects.equals(getDeviceName, that.getDeviceName) &&
                Objects.equals(setDeviceIp, that.setDeviceIp) &&
                Objects.equals(getDeviceIp, that.getDeviceIp) &&
                Objects.equals(setGpsRecordInterval, that.setGpsRecordInterval) &&
                Objects.equals(getGpsRecordInterval, that.getGpsRecordInterval) &&
                Objects.equals(setGprsSendInterval, that.setGprsSendInterval) &&
                Objects.equals(getGprsSendInterval, that.getGprsSendInterval) &&
                Objects.equals(resetDevice, that.resetDevice) &&
                Objects.equals(setPowerTcpLiveInterval, that.setPowerTcpLiveInterval) &&
                Objects.equals(getPowerTcpLiveInterval, that.getPowerTcpLiveInterval) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(isSend, that.isSend);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, deviceId, createTime, getImsi, setDeviceName, getDeviceName, setDeviceIp, getDeviceIp, setGpsRecordInterval, getGpsRecordInterval, setGprsSendInterval, getGprsSendInterval, resetDevice, setPowerTcpLiveInterval, getPowerTcpLiveInterval, sendTime, isSend);
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

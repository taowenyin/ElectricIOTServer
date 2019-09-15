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
    @JsonProperty("set_keep_live_interval")
    private Integer setKeepLiveInterval;
    @JsonProperty("get_keep_live_interval")
    private Integer getKeepLiveInterval;
    @JsonProperty("set_battery_sleep_time")
    private Integer setBatterySleepTime;
    @JsonProperty("get_battery_sleep_time")
    private Integer getBatterySleepTime;
    @JsonProperty("reset_device")
    private Integer resetDevice;
    @JsonProperty("set_battery_keep_live_time")
    private Integer setBatteryKeepLiveTime;
    @JsonProperty("get_battery_keep_live_time")
    private Integer getBatteryKeepLiveTime;
    @JsonProperty("send_time")
    private String sendTime;
    @JsonProperty("set_command")
    private String setCommand;
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
    @Column(name = "set_keep_live_interval", nullable = true)
    public Integer getSetKeepLiveInterval() {
        return setKeepLiveInterval;
    }

    public void setSetKeepLiveInterval(Integer setKeepLiveInterval) {
        this.setKeepLiveInterval = setKeepLiveInterval;
    }

    @Basic
    @Column(name = "get_keep_live_interval", nullable = true)
    public Integer getGetKeepLiveInterval() {
        return getKeepLiveInterval;
    }

    public void setGetKeepLiveInterval(Integer getKeepLiveInterval) {
        this.getKeepLiveInterval = getKeepLiveInterval;
    }

    @Basic
    @Column(name = "set_battery_sleep_time", nullable = true)
    public Integer getSetBatterySleepTime() {
        return setBatterySleepTime;
    }

    public void setSetBatterySleepTime(Integer setBatterySleepTime) {
        this.setBatterySleepTime = setBatterySleepTime;
    }

    @Basic
    @Column(name = "get_battery_sleep_time", nullable = true)
    public Integer getGetBatterySleepTime() {
        return getBatterySleepTime;
    }

    public void setGetBatterySleepTime(Integer getBatterySleepTime) {
        this.getBatterySleepTime = getBatterySleepTime;
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
    @Column(name = "set_battery_keep_live_time", nullable = true)
    public Integer getSetBatteryKeepLiveTime() {
        return setBatteryKeepLiveTime;
    }

    public void setSetBatteryKeepLiveTime(Integer setBatteryKeepLiveTime) {
        this.setBatteryKeepLiveTime = setBatteryKeepLiveTime;
    }

    @Basic
    @Column(name = "get_battery_keep_live_time", nullable = true)
    public Integer getGetBatteryKeepLiveTime() {
        return getBatteryKeepLiveTime;
    }

    public void setGetBatteryKeepLiveTime(Integer getBatteryKeepLiveTime) {
        this.getBatteryKeepLiveTime = getBatteryKeepLiveTime;
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
    @Column(name = "set_command", nullable = true, length = 45)
    public String getSetCommand() {
        return setCommand;
    }

    public void setSetCommand(String setCommand) {
        this.setCommand = setCommand;
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
                Objects.equals(setKeepLiveInterval, that.setKeepLiveInterval) &&
                Objects.equals(getKeepLiveInterval, that.getKeepLiveInterval) &&
                Objects.equals(setBatterySleepTime, that.setBatterySleepTime) &&
                Objects.equals(getBatterySleepTime, that.getBatterySleepTime) &&
                Objects.equals(resetDevice, that.resetDevice) &&
                Objects.equals(setBatteryKeepLiveTime, that.setBatteryKeepLiveTime) &&
                Objects.equals(getBatteryKeepLiveTime, that.getBatteryKeepLiveTime) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(setCommand, that.setCommand) &&
                Objects.equals(isSend, that.isSend);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, deviceId, createTime, getImsi, setDeviceName, getDeviceName, setDeviceIp, getDeviceIp, setKeepLiveInterval, getKeepLiveInterval, setBatterySleepTime, getBatterySleepTime, resetDevice, setBatteryKeepLiveTime, getBatteryKeepLiveTime, sendTime, setCommand, isSend);
    }

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    public DeviceEntity getDeviceByDeviceId() {
        return deviceByDeviceId;
    }

    public void setDeviceByDeviceId(DeviceEntity deviceByDeviceId) {
        this.deviceByDeviceId = deviceByDeviceId;
    }
}

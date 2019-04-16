package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "view_get_all_device_info", schema = "electric_iot", catalog = "")
public class ViewGetAllDeviceInfoEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("imsi")
    private String imsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("is_delete")
    private int isDelete;
    @JsonProperty("type_id")
    private Long typeId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status_id")
    private Long statusId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user")
    private String user;
    @JsonProperty("department_id")
    private Long departmentId;
    @JsonProperty("department")
    private String department;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("keep_live_interval")
    private int keepLiveInterval;
    @JsonProperty("battery_sleep_time")
    private int batterySleepTime;
    @JsonProperty("battery_keep_live_time")
    private int batteryKeepLiveTime;
    @JsonProperty("server_ip")
    private String serverIp;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid", nullable = true, length = 45)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "imsi", nullable = false, length = 45)
    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "serial_number", nullable = true, length = 200)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "is_delete", nullable = false)
    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status_id", nullable = true)
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user", nullable = false, length = 45)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "department_id", nullable = true)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department", nullable = false, length = 255)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 200)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
    @Column(name = "keep_live_interval", nullable = false)
    public int getKeepLiveInterval() {
        return keepLiveInterval;
    }

    public void setKeepLiveInterval(int keepLiveInterval) {
        this.keepLiveInterval = keepLiveInterval;
    }

    @Basic
    @Column(name = "battery_sleep_time", nullable = false)
    public int getBatterySleepTime() {
        return batterySleepTime;
    }

    public void setBatterySleepTime(int batterySleepTime) {
        this.batterySleepTime = batterySleepTime;
    }

    @Basic
    @Column(name = "battery_keep_live_time", nullable = false)
    public int getBatteryKeepLiveTime() {
        return batteryKeepLiveTime;
    }

    public void setBatteryKeepLiveTime(int batteryKeepLiveTime) {
        this.batteryKeepLiveTime = batteryKeepLiveTime;
    }

    @Basic
    @Column(name = "server_ip", nullable = false)
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewGetAllDeviceInfoEntity that = (ViewGetAllDeviceInfoEntity) o;
        return id == that.id &&
                isDelete == that.isDelete &&
                keepLiveInterval == that.keepLiveInterval &&
                batterySleepTime == that.batterySleepTime &&
                batteryKeepLiveTime == that.batteryKeepLiveTime &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(imsi, that.imsi) &&
                Objects.equals(name, that.name) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(statusId, that.statusId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(department, that.department) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(serverIp, that.serverIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, imsi, name, serialNumber, isDelete, typeId, type, statusId, status, userId, user, departmentId, department, comment, createTime, keepLiveInterval, batterySleepTime, batteryKeepLiveTime, serverIp);
    }
}

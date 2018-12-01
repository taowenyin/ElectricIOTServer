package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "device", schema = "electric_iot", catalog = "")
public class DeviceEntity {
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
    @JsonProperty("status_id")
    private Long statusId;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("department_id")
    private Long departmentId;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("battery_record_gps_interval")
    private int batteryRecordGpsInterval;
    @JsonProperty("power_record_gps_interval")
    private int powerRecordGpsInterval;
    @JsonProperty("battery_send_gprs_interval")
    private int batterySendGprsInterval;
    @JsonProperty("power_send_gprs_interval")
    private int powerSendGprsInterval;
    @JsonProperty("power_tcp_live_interval")
    private int powerTcpLiveInterval;
    @JsonIgnore
    private TypeEntity typeByTypeId;
    @JsonIgnore
    private StatusEntity statusByStatusId;
    @JsonIgnore
    private UserEntity userByUserId;
    @JsonIgnore
    private DepartmentEntity departmentByDepartmentId;
    @JsonIgnore
    private Collection<DeviceCmdEntity> deviceCmdsById;
    @JsonIgnore
    private Collection<DeviceLocationEntity> deviceLocationsById;

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
    @Column(name = "uid", nullable = true, length = 45)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "imsi", nullable = false, unique = true, length = 45)
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
    @Column(name = "status_id", nullable = true)
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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
    @Column(name = "department_id", nullable = true)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
    @Column(name = "battery_record_gps_interval", nullable = false)
    public int getBatteryRecordGpsInterval() {
        return batteryRecordGpsInterval;
    }

    public void setBatteryRecordGpsInterval(int batteryRecordGpsInterval) {
        this.batteryRecordGpsInterval = batteryRecordGpsInterval;
    }

    @Basic
    @Column(name = "power_record_gps_interval", nullable = false)
    public int getPowerRecordGpsInterval() {
        return powerRecordGpsInterval;
    }

    public void setPowerRecordGpsInterval(int powerRecordGpsInterval) {
        this.powerRecordGpsInterval = powerRecordGpsInterval;
    }

    @Basic
    @Column(name = "battery_send_gprs_interval", nullable = false)
    public int getBatterySendGprsInterval() {
        return batterySendGprsInterval;
    }

    public void setBatterySendGprsInterval(int batterySendGprsInterval) {
        this.batterySendGprsInterval = batterySendGprsInterval;
    }

    @Basic
    @Column(name = "power_send_gprs_interval", nullable = false)
    public int getPowerSendGprsInterval() {
        return powerSendGprsInterval;
    }

    public void setPowerSendGprsInterval(int powerSendGprsInterval) {
        this.powerSendGprsInterval = powerSendGprsInterval;
    }

    @Basic
    @Column(name = "power_tcp_live_interval", nullable = false)
    public int getPowerTcpLiveInterval() {
        return powerTcpLiveInterval;
    }

    public void setPowerTcpLiveInterval(int powerTcpLiveInterval) {
        this.powerTcpLiveInterval = powerTcpLiveInterval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceEntity that = (DeviceEntity) o;
        return id == that.id &&
                isDelete == that.isDelete &&
                batteryRecordGpsInterval == that.batteryRecordGpsInterval &&
                powerRecordGpsInterval == that.powerRecordGpsInterval &&
                batterySendGprsInterval == that.batterySendGprsInterval &&
                powerSendGprsInterval == that.powerSendGprsInterval &&
                powerTcpLiveInterval == that.powerTcpLiveInterval &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(imsi, that.imsi) &&
                Objects.equals(name, that.name) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(statusId, that.statusId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, imsi, name, serialNumber, isDelete, typeId, statusId, userId, departmentId, comment, createTime, batteryRecordGpsInterval, powerRecordGpsInterval, batterySendGprsInterval, powerSendGprsInterval, powerTcpLiveInterval);
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TypeEntity getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(TypeEntity typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", insertable = false, updatable = false)
    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", insertable = false, updatable = false)
    public DepartmentEntity getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(DepartmentEntity departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @OneToMany(mappedBy = "deviceByDeviceId")
    public Collection<DeviceCmdEntity> getDeviceCmdsById() {
        return deviceCmdsById;
    }

    public void setDeviceCmdsById(Collection<DeviceCmdEntity> deviceCmdsById) {
        this.deviceCmdsById = deviceCmdsById;
    }

    @OneToMany(mappedBy = "deviceByDeviceId")
    public Collection<DeviceLocationEntity> getDeviceLocationsById() {
        return deviceLocationsById;
    }

    public void setDeviceLocationsById(Collection<DeviceLocationEntity> deviceLocationsById) {
        this.deviceLocationsById = deviceLocationsById;
    }
}

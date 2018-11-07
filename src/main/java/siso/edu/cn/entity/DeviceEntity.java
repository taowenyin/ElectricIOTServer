package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
    private byte isDelete;
    @JsonProperty("type_id")
    private Long typeId;
    @JsonProperty("status_id")
    private Long statusId;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("battery_record_gps_interval")
    private int batteryRecordGpsInterval;
    @JsonProperty("power_record_gps_interval")
    private int powerRecordGpsInterval;
    @JsonProperty("battery_send_gps_interval")
    private int batterySendGpsInterval;
    @JsonProperty("power_send_gps_interval")
    private int powerSendGpsInterval;
    @JsonProperty("power_tcp_live_interval")
    private int powerTcpLiveInterval;

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
    public byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
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
    @Column(name = "comment", nullable = true, length = 200)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
    @Column(name = "battery_send_gps_interval", nullable = false)
    public int getBatterySendGpsInterval() {
        return batterySendGpsInterval;
    }

    public void setBatterySendGpsInterval(int batterySendGpsInterval) {
        this.batterySendGpsInterval = batterySendGpsInterval;
    }

    @Basic
    @Column(name = "power_send_gps_interval", nullable = false)
    public int getPowerSendGpsInterval() {
        return powerSendGpsInterval;
    }

    public void setPowerSendGpsInterval(int powerSendGpsInterval) {
        this.powerSendGpsInterval = powerSendGpsInterval;
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

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (batteryRecordGpsInterval != that.batteryRecordGpsInterval) return false;
        if (powerRecordGpsInterval != that.powerRecordGpsInterval) return false;
        if (batterySendGpsInterval != that.batterySendGpsInterval) return false;
        if (powerSendGpsInterval != that.powerSendGpsInterval) return false;
        if (powerTcpLiveInterval != that.powerTcpLiveInterval) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (imsi != null ? !imsi.equals(that.imsi) : that.imsi != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (imsi != null ? imsi.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (int) isDelete;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + batteryRecordGpsInterval;
        result = 31 * result + powerRecordGpsInterval;
        result = 31 * result + batterySendGpsInterval;
        result = 31 * result + powerSendGpsInterval;
        result = 31 * result + powerTcpLiveInterval;
        return result;
    }
}

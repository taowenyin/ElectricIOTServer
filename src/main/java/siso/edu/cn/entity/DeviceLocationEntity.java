package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "device_location", schema = "electric_iot", catalog = "")
public class DeviceLocationEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("device_id")
    private long deviceId;
    @JsonProperty("record_time")
    private String recordTime;
    @JsonProperty("signal_quality")
    private int signalQuality;
    @JsonProperty("device_on_off")
    private int deviceOnOff;
    @JsonProperty("battery_voltage")
    private int batteryVoltage;
    @JsonProperty("longitude")
    private BigDecimal longitude;
    @JsonProperty("latitude")
    private BigDecimal latitude;
    @JsonProperty("nation_num")
    private Integer nationNum;
    @JsonProperty("mobile_num")
    private Integer mobileNum;
    @JsonProperty("location_num")
    private Integer locationNum;
    @JsonProperty("community_num")
    private String communityNum;
    @JsonProperty("station_num")
    private String stationNum;
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
    @Column(name = "record_time", nullable = false)
    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "signal_quality", nullable = false)
    public int getSignalQuality() {
        return signalQuality;
    }

    public void setSignalQuality(int signalQuality) {
        this.signalQuality = signalQuality;
    }

    @Basic
    @Column(name = "device_on_off", nullable = false)
    public int getDeviceOnOff() {
        return deviceOnOff;
    }

    public void setDeviceOnOff(int deviceOnOff) {
        this.deviceOnOff = deviceOnOff;
    }

    @Basic
    @Column(name = "battery_voltage", nullable = false)
    public int getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(int batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 6)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 6)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "nation_num", nullable = true)
    public Integer getNationNum() {
        return nationNum;
    }

    public void setNationNum(Integer nationNum) {
        this.nationNum = nationNum;
    }

    @Basic
    @Column(name = "mobile_num", nullable = true)
    public Integer getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(Integer mobileNum) {
        this.mobileNum = mobileNum;
    }

    @Basic
    @Column(name = "location_num", nullable = true)
    public Integer getLocationNum() {
        return locationNum;
    }

    public void setLocationNum(Integer locationNum) {
        this.locationNum = locationNum;
    }

    @Basic
    @Column(name = "community_num", nullable = true, length = 45)
    public String getCommunityNum() {
        return communityNum;
    }

    public void setCommunityNum(String communityNum) {
        this.communityNum = communityNum;
    }

    @Basic
    @Column(name = "station_num", nullable = true, length = 45)
    public String getStationNum() {
        return stationNum;
    }

    public void setStationNum(String stationNum) {
        this.stationNum = stationNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceLocationEntity that = (DeviceLocationEntity) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (signalQuality != that.signalQuality) return false;
        if (deviceOnOff != that.deviceOnOff) return false;
        if (batteryVoltage != that.batteryVoltage) return false;
        if (recordTime != null ? !recordTime.equals(that.recordTime) : that.recordTime != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (nationNum != null ? !nationNum.equals(that.nationNum) : that.nationNum != null) return false;
        if (mobileNum != null ? !mobileNum.equals(that.mobileNum) : that.mobileNum != null) return false;
        if (locationNum != null ? !locationNum.equals(that.locationNum) : that.locationNum != null) return false;
        if (communityNum != null ? !communityNum.equals(that.communityNum) : that.communityNum != null) return false;
        if (stationNum != null ? !stationNum.equals(that.stationNum) : that.stationNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (recordTime != null ? recordTime.hashCode() : 0);
        result = 31 * result + signalQuality;
        result = 31 * result + deviceOnOff;
        result = 31 * result + batteryVoltage;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (nationNum != null ? nationNum.hashCode() : 0);
        result = 31 * result + (mobileNum != null ? mobileNum.hashCode() : 0);
        result = 31 * result + (locationNum != null ? locationNum.hashCode() : 0);
        result = 31 * result + (communityNum != null ? communityNum.hashCode() : 0);
        result = 31 * result + (stationNum != null ? stationNum.hashCode() : 0);
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

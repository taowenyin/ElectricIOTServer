package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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
    @JsonProperty("longitude_direction")
    private Integer longitudeDirection;
    @JsonProperty("latitude")
    private BigDecimal latitude;
    @JsonProperty("latitude_direction")
    private Integer latitudeDirection;
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
    @Column(name = "longitude_direction", nullable = true)
    public Integer getLongitudeDirection() {
        return longitudeDirection;
    }

    public void setLongitudeDirection(Integer longitudeDirection) {
        this.longitudeDirection = longitudeDirection;
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
    @Column(name = "latitude_direction", nullable = true)
    public Integer getLatitudeDirection() {
        return latitudeDirection;
    }

    public void setLatitudeDirection(Integer latitudeDirection) {
        this.latitudeDirection = latitudeDirection;
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
        return id == that.id &&
                deviceId == that.deviceId &&
                signalQuality == that.signalQuality &&
                deviceOnOff == that.deviceOnOff &&
                batteryVoltage == that.batteryVoltage &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(longitudeDirection, that.longitudeDirection) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(latitudeDirection, that.latitudeDirection) &&
                Objects.equals(nationNum, that.nationNum) &&
                Objects.equals(mobileNum, that.mobileNum) &&
                Objects.equals(locationNum, that.locationNum) &&
                Objects.equals(communityNum, that.communityNum) &&
                Objects.equals(stationNum, that.stationNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, deviceId, recordTime, signalQuality, deviceOnOff, batteryVoltage, longitude, longitudeDirection, latitude, latitudeDirection, nationNum, mobileNum, locationNum, communityNum, stationNum);
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

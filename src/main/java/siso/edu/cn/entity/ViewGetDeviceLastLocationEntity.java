package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "view_get_device_last_location", schema = "electric_iot", catalog = "")
public class ViewGetDeviceLastLocationEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("device_id")
    private long deviceId;
    @JsonProperty("record_time")
    private String recordTime;
    @JsonProperty("device_time")
    private String deviceTime;
    @JsonProperty("signal_quality")
    private int signalQuality;
    @JsonProperty("device_on_off")
    private int deviceOnOff;
    @JsonProperty("battery_voltage")
    private double batteryVoltage;
    @JsonProperty("longitude")
    private BigDecimal longitude;
    @JsonProperty("longitude_direction")
    private Integer longitudeDirection;
    @JsonProperty("latitude")
    private BigDecimal latitude;
    @JsonProperty("latitude_direction")
    private Integer latitudeDirection;
    @JsonProperty("agps_station_num")
    private Integer agpsStationNum;
    @JsonProperty("nation_num_1")
    private Integer nationNum1;
    @JsonProperty("mobile_num_1")
    private Integer mobileNum1;
    @JsonProperty("location_num_1")
    private Integer locationNum1;
    @JsonProperty("community_num_1")
    private Integer communityNum1;
    @JsonProperty("station_flag_1")
    private Integer stationFlag1;
    @JsonProperty("signal_strength_1")
    private Integer signalStrength1;
    @JsonProperty("nation_num_2")
    private Integer nationNum2;
    @JsonProperty("mobile_num_2")
    private Integer mobileNum2;
    @JsonProperty("location_num_2")
    private Integer locationNum2;
    @JsonProperty("community_num_2")
    private Integer communityNum2;
    @JsonProperty("station_flag_2")
    private Integer stationFlag2;
    @JsonProperty("signal_strength_2")
    private Integer signalStrength2;
    @JsonProperty("nation_num_3")
    private Integer nationNum3;
    @JsonProperty("mobile_num_3")
    private Integer mobileNum3;
    @JsonProperty("location_num_3")
    private Integer locationNum3;
    @JsonProperty("community_num_3")
    private Integer communityNum3;
    @JsonProperty("station_flag_3")
    private Integer stationFlag3;
    @JsonProperty("signal_strength_3")
    private Integer signalStrength3;
    @JsonProperty("nation_num_4")
    private Integer nationNum4;
    @JsonProperty("mobile_num_4")
    private Integer mobileNum4;
    @JsonProperty("location_num_4")
    private Integer locationNum4;
    @JsonProperty("community_num_4")
    private Integer communityNum4;
    @JsonProperty("station_flag_4")
    private Integer stationFlag4;
    @JsonProperty("signal_strength_4")
    private Integer signalStrength4;

    @Id
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
    @Column(name = "device_time", nullable = false)
    public String getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(String deviceTime) {
        this.deviceTime = deviceTime;
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
    @Column(name = "battery_voltage", nullable = false, precision = 0)
    public double getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(double batteryVoltage) {
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
    @Column(name = "agps_station_num", nullable = true)
    public Integer getAgpsStationNum() {
        return agpsStationNum;
    }

    public void setAgpsStationNum(Integer agpsStationNum) {
        this.agpsStationNum = agpsStationNum;
    }

    @Basic
    @Column(name = "nation_num_1", nullable = true)
    public Integer getNationNum1() {
        return nationNum1;
    }

    public void setNationNum1(Integer nationNum1) {
        this.nationNum1 = nationNum1;
    }

    @Basic
    @Column(name = "mobile_num_1", nullable = true)
    public Integer getMobileNum1() {
        return mobileNum1;
    }

    public void setMobileNum1(Integer mobileNum1) {
        this.mobileNum1 = mobileNum1;
    }

    @Basic
    @Column(name = "location_num_1", nullable = true)
    public Integer getLocationNum1() {
        return locationNum1;
    }

    public void setLocationNum1(Integer locationNum1) {
        this.locationNum1 = locationNum1;
    }

    @Basic
    @Column(name = "community_num_1", nullable = true)
    public Integer getCommunityNum1() {
        return communityNum1;
    }

    public void setCommunityNum1(Integer communityNum1) {
        this.communityNum1 = communityNum1;
    }

    @Basic
    @Column(name = "station_flag_1", nullable = true)
    public Integer getStationFlag1() {
        return stationFlag1;
    }

    public void setStationFlag1(Integer stationFlag1) {
        this.stationFlag1 = stationFlag1;
    }

    @Basic
    @Column(name = "signal_strength_1", nullable = true)
    public Integer getSignalStrength1() {
        return signalStrength1;
    }

    public void setSignalStrength1(Integer signalStrength1) {
        this.signalStrength1 = signalStrength1;
    }

    @Basic
    @Column(name = "nation_num_2", nullable = true)
    public Integer getNationNum2() {
        return nationNum2;
    }

    public void setNationNum2(Integer nationNum2) {
        this.nationNum2 = nationNum2;
    }

    @Basic
    @Column(name = "mobile_num_2", nullable = true)
    public Integer getMobileNum2() {
        return mobileNum2;
    }

    public void setMobileNum2(Integer mobileNum2) {
        this.mobileNum2 = mobileNum2;
    }

    @Basic
    @Column(name = "location_num_2", nullable = true)
    public Integer getLocationNum2() {
        return locationNum2;
    }

    public void setLocationNum2(Integer locationNum2) {
        this.locationNum2 = locationNum2;
    }

    @Basic
    @Column(name = "community_num_2", nullable = true)
    public Integer getCommunityNum2() {
        return communityNum2;
    }

    public void setCommunityNum2(Integer communityNum2) {
        this.communityNum2 = communityNum2;
    }

    @Basic
    @Column(name = "station_flag_2", nullable = true)
    public Integer getStationFlag2() {
        return stationFlag2;
    }

    public void setStationFlag2(Integer stationFlag2) {
        this.stationFlag2 = stationFlag2;
    }

    @Basic
    @Column(name = "signal_strength_2", nullable = true)
    public Integer getSignalStrength2() {
        return signalStrength2;
    }

    public void setSignalStrength2(Integer signalStrength2) {
        this.signalStrength2 = signalStrength2;
    }

    @Basic
    @Column(name = "nation_num_3", nullable = true)
    public Integer getNationNum3() {
        return nationNum3;
    }

    public void setNationNum3(Integer nationNum3) {
        this.nationNum3 = nationNum3;
    }

    @Basic
    @Column(name = "mobile_num_3", nullable = true)
    public Integer getMobileNum3() {
        return mobileNum3;
    }

    public void setMobileNum3(Integer mobileNum3) {
        this.mobileNum3 = mobileNum3;
    }

    @Basic
    @Column(name = "location_num_3", nullable = true)
    public Integer getLocationNum3() {
        return locationNum3;
    }

    public void setLocationNum3(Integer locationNum3) {
        this.locationNum3 = locationNum3;
    }

    @Basic
    @Column(name = "community_num_3", nullable = true)
    public Integer getCommunityNum3() {
        return communityNum3;
    }

    public void setCommunityNum3(Integer communityNum3) {
        this.communityNum3 = communityNum3;
    }

    @Basic
    @Column(name = "station_flag_3", nullable = true)
    public Integer getStationFlag3() {
        return stationFlag3;
    }

    public void setStationFlag3(Integer stationFlag3) {
        this.stationFlag3 = stationFlag3;
    }

    @Basic
    @Column(name = "signal_strength_3", nullable = true)
    public Integer getSignalStrength3() {
        return signalStrength3;
    }

    public void setSignalStrength3(Integer signalStrength3) {
        this.signalStrength3 = signalStrength3;
    }

    @Basic
    @Column(name = "nation_num_4", nullable = true)
    public Integer getNationNum4() {
        return nationNum4;
    }

    public void setNationNum4(Integer nationNum4) {
        this.nationNum4 = nationNum4;
    }

    @Basic
    @Column(name = "mobile_num_4", nullable = true)
    public Integer getMobileNum4() {
        return mobileNum4;
    }

    public void setMobileNum4(Integer mobileNum4) {
        this.mobileNum4 = mobileNum4;
    }

    @Basic
    @Column(name = "location_num_4", nullable = true)
    public Integer getLocationNum4() {
        return locationNum4;
    }

    public void setLocationNum4(Integer locationNum4) {
        this.locationNum4 = locationNum4;
    }

    @Basic
    @Column(name = "community_num_4", nullable = true)
    public Integer getCommunityNum4() {
        return communityNum4;
    }

    public void setCommunityNum4(Integer communityNum4) {
        this.communityNum4 = communityNum4;
    }

    @Basic
    @Column(name = "station_flag_4", nullable = true)
    public Integer getStationFlag4() {
        return stationFlag4;
    }

    public void setStationFlag4(Integer stationFlag4) {
        this.stationFlag4 = stationFlag4;
    }

    @Basic
    @Column(name = "signal_strength_4", nullable = true)
    public Integer getSignalStrength4() {
        return signalStrength4;
    }

    public void setSignalStrength4(Integer signalStrength4) {
        this.signalStrength4 = signalStrength4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewGetDeviceLastLocationEntity that = (ViewGetDeviceLastLocationEntity) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (signalQuality != that.signalQuality) return false;
        if (deviceOnOff != that.deviceOnOff) return false;
        if (Double.compare(that.batteryVoltage, batteryVoltage) != 0) return false;
        if (recordTime != null ? !recordTime.equals(that.recordTime) : that.recordTime != null) return false;
        if (deviceTime != null ? !deviceTime.equals(that.deviceTime) : that.deviceTime != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (longitudeDirection != null ? !longitudeDirection.equals(that.longitudeDirection) : that.longitudeDirection != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (latitudeDirection != null ? !latitudeDirection.equals(that.latitudeDirection) : that.latitudeDirection != null)
            return false;
        if (agpsStationNum != null ? !agpsStationNum.equals(that.agpsStationNum) : that.agpsStationNum != null)
            return false;
        if (nationNum1 != null ? !nationNum1.equals(that.nationNum1) : that.nationNum1 != null) return false;
        if (mobileNum1 != null ? !mobileNum1.equals(that.mobileNum1) : that.mobileNum1 != null) return false;
        if (locationNum1 != null ? !locationNum1.equals(that.locationNum1) : that.locationNum1 != null) return false;
        if (communityNum1 != null ? !communityNum1.equals(that.communityNum1) : that.communityNum1 != null)
            return false;
        if (stationFlag1 != null ? !stationFlag1.equals(that.stationFlag1) : that.stationFlag1 != null) return false;
        if (signalStrength1 != null ? !signalStrength1.equals(that.signalStrength1) : that.signalStrength1 != null)
            return false;
        if (nationNum2 != null ? !nationNum2.equals(that.nationNum2) : that.nationNum2 != null) return false;
        if (mobileNum2 != null ? !mobileNum2.equals(that.mobileNum2) : that.mobileNum2 != null) return false;
        if (locationNum2 != null ? !locationNum2.equals(that.locationNum2) : that.locationNum2 != null) return false;
        if (communityNum2 != null ? !communityNum2.equals(that.communityNum2) : that.communityNum2 != null)
            return false;
        if (stationFlag2 != null ? !stationFlag2.equals(that.stationFlag2) : that.stationFlag2 != null) return false;
        if (signalStrength2 != null ? !signalStrength2.equals(that.signalStrength2) : that.signalStrength2 != null)
            return false;
        if (nationNum3 != null ? !nationNum3.equals(that.nationNum3) : that.nationNum3 != null) return false;
        if (mobileNum3 != null ? !mobileNum3.equals(that.mobileNum3) : that.mobileNum3 != null) return false;
        if (locationNum3 != null ? !locationNum3.equals(that.locationNum3) : that.locationNum3 != null) return false;
        if (communityNum3 != null ? !communityNum3.equals(that.communityNum3) : that.communityNum3 != null)
            return false;
        if (stationFlag3 != null ? !stationFlag3.equals(that.stationFlag3) : that.stationFlag3 != null) return false;
        if (signalStrength3 != null ? !signalStrength3.equals(that.signalStrength3) : that.signalStrength3 != null)
            return false;
        if (nationNum4 != null ? !nationNum4.equals(that.nationNum4) : that.nationNum4 != null) return false;
        if (mobileNum4 != null ? !mobileNum4.equals(that.mobileNum4) : that.mobileNum4 != null) return false;
        if (locationNum4 != null ? !locationNum4.equals(that.locationNum4) : that.locationNum4 != null) return false;
        if (communityNum4 != null ? !communityNum4.equals(that.communityNum4) : that.communityNum4 != null)
            return false;
        if (stationFlag4 != null ? !stationFlag4.equals(that.stationFlag4) : that.stationFlag4 != null) return false;
        if (signalStrength4 != null ? !signalStrength4.equals(that.signalStrength4) : that.signalStrength4 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (recordTime != null ? recordTime.hashCode() : 0);
        result = 31 * result + (deviceTime != null ? deviceTime.hashCode() : 0);
        result = 31 * result + signalQuality;
        result = 31 * result + deviceOnOff;
        temp = Double.doubleToLongBits(batteryVoltage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (longitudeDirection != null ? longitudeDirection.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (latitudeDirection != null ? latitudeDirection.hashCode() : 0);
        result = 31 * result + (agpsStationNum != null ? agpsStationNum.hashCode() : 0);
        result = 31 * result + (nationNum1 != null ? nationNum1.hashCode() : 0);
        result = 31 * result + (mobileNum1 != null ? mobileNum1.hashCode() : 0);
        result = 31 * result + (locationNum1 != null ? locationNum1.hashCode() : 0);
        result = 31 * result + (communityNum1 != null ? communityNum1.hashCode() : 0);
        result = 31 * result + (stationFlag1 != null ? stationFlag1.hashCode() : 0);
        result = 31 * result + (signalStrength1 != null ? signalStrength1.hashCode() : 0);
        result = 31 * result + (nationNum2 != null ? nationNum2.hashCode() : 0);
        result = 31 * result + (mobileNum2 != null ? mobileNum2.hashCode() : 0);
        result = 31 * result + (locationNum2 != null ? locationNum2.hashCode() : 0);
        result = 31 * result + (communityNum2 != null ? communityNum2.hashCode() : 0);
        result = 31 * result + (stationFlag2 != null ? stationFlag2.hashCode() : 0);
        result = 31 * result + (signalStrength2 != null ? signalStrength2.hashCode() : 0);
        result = 31 * result + (nationNum3 != null ? nationNum3.hashCode() : 0);
        result = 31 * result + (mobileNum3 != null ? mobileNum3.hashCode() : 0);
        result = 31 * result + (locationNum3 != null ? locationNum3.hashCode() : 0);
        result = 31 * result + (communityNum3 != null ? communityNum3.hashCode() : 0);
        result = 31 * result + (stationFlag3 != null ? stationFlag3.hashCode() : 0);
        result = 31 * result + (signalStrength3 != null ? signalStrength3.hashCode() : 0);
        result = 31 * result + (nationNum4 != null ? nationNum4.hashCode() : 0);
        result = 31 * result + (mobileNum4 != null ? mobileNum4.hashCode() : 0);
        result = 31 * result + (locationNum4 != null ? locationNum4.hashCode() : 0);
        result = 31 * result + (communityNum4 != null ? communityNum4.hashCode() : 0);
        result = 31 * result + (stationFlag4 != null ? stationFlag4.hashCode() : 0);
        result = 31 * result + (signalStrength4 != null ? signalStrength4.hashCode() : 0);
        return result;
    }
}

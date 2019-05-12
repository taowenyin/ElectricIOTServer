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
    @JsonProperty("province")
    private String province;
    @JsonProperty("city")
    private String city;
    @JsonProperty("district")
    private String district;
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
    @JsonProperty("is_delete")
    private Integer isDelete;
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("humidity")
    private String humidity;
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
    @Column(name = "province", nullable = true, length = 45)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 45)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    @Basic
    @Column(name = "is_delete", nullable = true)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "temp", nullable = true, length = 45)
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Basic
    @Column(name = "humidity", nullable = true, length = 45)
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
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
                Double.compare(that.batteryVoltage, batteryVoltage) == 0 &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(deviceTime, that.deviceTime) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(longitudeDirection, that.longitudeDirection) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(latitudeDirection, that.latitudeDirection) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(district, that.district) &&
                Objects.equals(agpsStationNum, that.agpsStationNum) &&
                Objects.equals(nationNum1, that.nationNum1) &&
                Objects.equals(mobileNum1, that.mobileNum1) &&
                Objects.equals(locationNum1, that.locationNum1) &&
                Objects.equals(communityNum1, that.communityNum1) &&
                Objects.equals(stationFlag1, that.stationFlag1) &&
                Objects.equals(signalStrength1, that.signalStrength1) &&
                Objects.equals(nationNum2, that.nationNum2) &&
                Objects.equals(mobileNum2, that.mobileNum2) &&
                Objects.equals(locationNum2, that.locationNum2) &&
                Objects.equals(communityNum2, that.communityNum2) &&
                Objects.equals(stationFlag2, that.stationFlag2) &&
                Objects.equals(signalStrength2, that.signalStrength2) &&
                Objects.equals(nationNum3, that.nationNum3) &&
                Objects.equals(mobileNum3, that.mobileNum3) &&
                Objects.equals(locationNum3, that.locationNum3) &&
                Objects.equals(communityNum3, that.communityNum3) &&
                Objects.equals(stationFlag3, that.stationFlag3) &&
                Objects.equals(signalStrength3, that.signalStrength3) &&
                Objects.equals(nationNum4, that.nationNum4) &&
                Objects.equals(mobileNum4, that.mobileNum4) &&
                Objects.equals(locationNum4, that.locationNum4) &&
                Objects.equals(communityNum4, that.communityNum4) &&
                Objects.equals(stationFlag4, that.stationFlag4) &&
                Objects.equals(signalStrength4, that.signalStrength4) &&
                Objects.equals(isDelete, that.isDelete) &&
                Objects.equals(temp, that.temp) &&
                Objects.equals(humidity, that.humidity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, deviceId, recordTime, deviceTime, signalQuality, deviceOnOff, batteryVoltage, longitude, longitudeDirection, latitude, latitudeDirection, province, city, district, agpsStationNum, nationNum1, mobileNum1, locationNum1, communityNum1, stationFlag1, signalStrength1, nationNum2, mobileNum2, locationNum2, communityNum2, stationFlag2, signalStrength2, nationNum3, mobileNum3, locationNum3, communityNum3, stationFlag3, signalStrength3, nationNum4, mobileNum4, locationNum4, communityNum4, stationFlag4, signalStrength4, isDelete, temp, humidity);
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

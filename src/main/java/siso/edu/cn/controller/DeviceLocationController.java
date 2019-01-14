package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import siso.edu.cn.entity.*;
import siso.edu.cn.service.DeviceLocationService;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @apiDefine deviceLocationGroup 设备实时位置管理接口
 */
@RestController
@RequestMapping(value = "/api/manage", produces = "application/json;charset=utf-8")
public class DeviceLocationController extends IControllerImpl {

    // 基站信息转经纬度接口
    public static final String AGPS_CONVERT_URL = "http://api.gpsspg.com/bs/?oid=%s&key=9564xy0zx29yu427ywz50439u49uu16370yxx&type=%s&bs=%s&hex=%s&to=%s&output=%s";
    // 经纬度转地理信息接口
    public static final String GECODE_CONVERT_URL = "https://restapi.amap.com/v3/geocode/regeo?key=f11511080fd76b66485b50902cb00a75&location=%s";

    private DeviceLocationService deviceLocationService;
    private OkHttpClient httpClient = null;

    @Autowired
    public DeviceLocationController(DeviceLocationService deviceLocationService) {
        this.deviceLocationService = deviceLocationService;
        this.httpClient = new OkHttpClient();
    }

    /**
     * @api {post} /api/manage/location 创建设备的实时位置
     * @apiVersion 0.0.1
     * @apiName createLocation
     * @apiGroup deviceLocationGroup
     *
     * @apiParam {Number} device_id 设备ID
     * @apiParam {String} device_time 设备记录时间
     * @apiParam {Number} signal_quality 当前网络信号
     * @apiParam {Number} device_on_off 设备开关机状态
     * @apiParam {Number} battery_voltage 设备电压
     * @apiParam {Number} [longitude] 设备位置经度
     * @apiParam {Number} [longitude_direction] 设备位置经度方向
     * @apiParam {Number} [latitude] 设备位置纬度
     * @apiParam {Number} [latitude_direction] 设备位置纬度方向
     * @apiParam {Number} [agps_station_num] AGPS基站数量
     * @apiParam {Number} [nation_num_1] 设备的AGPS国家号1
     * @apiParam {Number} [mobile_num_1] 设备的AGPS移动网络号1
     * @apiParam {Number} [location_num_1] 设备的AGPS位置区域号1
     * @apiParam {Number} [community_num_1] 设备的AGPS小区号1
     * @apiParam {Number} [station_flag_1] 设备的AGPS基站标识号1
     * @apiParam {Number} [signal_strength_1] 设备的AGPS信号强度1
     * @apiParam {Number} [nation_num_2] 设备的AGPS国家号2
     * @apiParam {Number} [mobile_num_2] 设备的AGPS移动网络号2
     * @apiParam {Number} [location_num_2] 设备的AGPS位置区域号2
     * @apiParam {Number} [community_num_2] 设备的AGPS小区号2
     * @apiParam {Number} [station_flag_2] 设备的AGPS基站标识号2
     * @apiParam {Number} [signal_strength_2] 设备的AGPS信号强度2
     * @apiParam {Number} [nation_num_3] 设备的AGPS国家号3
     * @apiParam {Number} [mobile_num_3] 设备的AGPS移动网络号3
     * @apiParam {Number} [location_num_3] 设备的AGPS位置区域号3
     * @apiParam {Number} [community_num_3] 设备的AGPS小区号3
     * @apiParam {Number} [station_flag_3] 设备的AGPS基站标识号3
     * @apiParam {Number} [signal_strength_3] 设备的AGPS信号强度3
     * @apiParam {Number} [nation_num_4] 设备的AGPS国家号4
     * @apiParam {Number} [mobile_num_4] 设备的AGPS移动网络号4
     * @apiParam {Number} [location_num_4] 设备的AGPS位置区域号4
     * @apiParam {Number} [community_num_4] 设备的AGPS小区号4
     * @apiParam {Number} [station_flag_4] 设备的AGPS基站标识号4
     * @apiParam {Number} [signal_strength_4] 设备的AGPS信号强度4
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/location", method = RequestMethod.POST)
    public ResultEntity createLocation(@RequestParam("device_id") long deviceId,
                                       @RequestParam("device_time") String deviceTime,
                                       @RequestParam("signal_quality") int signalQuality,
                                       @RequestParam("device_on_off") int deviceOnOff,
                                       @RequestParam("battery_voltage") float batteryVoltage,
                                       @RequestParam(name = "longitude", required = false, defaultValue = "-1") BigDecimal longitude,
                                       @RequestParam(name = "longitude_direction", required = false, defaultValue = "-1") int longitudeDirection,
                                       @RequestParam(name = "latitude", required = false, defaultValue = "-1") BigDecimal latitude,
                                       @RequestParam(name = "latitude_direction", required = false, defaultValue = "-1") int latitudeDirection,
                                       @RequestParam(name = "agps_station_num", required = false, defaultValue = "-1") int agpsStationNum,
                                       @RequestParam(name = "nation_num_1", required = false, defaultValue = "-1") int nationNum1,
                                       @RequestParam(name = "mobile_num_1", required = false, defaultValue = "-1") int mobileNum1,
                                       @RequestParam(name = "location_num_1", required = false, defaultValue = "-1") int locationNum1,
                                       @RequestParam(name = "community_num_1", required = false, defaultValue = "-1") int communityNum1,
                                       @RequestParam(name = "station_flag_1", required = false, defaultValue = "-1") int stationFlag1,
                                       @RequestParam(name = "signal_strength_1", required = false, defaultValue = "-1") int signalStrength1,
                                       @RequestParam(name = "nation_num_2", required = false, defaultValue = "-1") int nationNum2,
                                       @RequestParam(name = "mobile_num_2", required = false, defaultValue = "-1") int mobileNum2,
                                       @RequestParam(name = "location_num_2", required = false, defaultValue = "-1") int locationNum2,
                                       @RequestParam(name = "community_num_2", required = false, defaultValue = "-1") int communityNum2,
                                       @RequestParam(name = "station_flag_2", required = false, defaultValue = "-1") int stationFlag2,
                                       @RequestParam(name = "signal_strength_2", required = false, defaultValue = "-1") int signalStrength2,
                                       @RequestParam(name = "nation_num_3", required = false, defaultValue = "-1") int nationNum3,
                                       @RequestParam(name = "mobile_num_3", required = false, defaultValue = "-1") int mobileNum3,
                                       @RequestParam(name = "location_num_3", required = false, defaultValue = "-1") int locationNum3,
                                       @RequestParam(name = "community_num_3", required = false, defaultValue = "-1") int communityNum3,
                                       @RequestParam(name = "station_flag_3", required = false, defaultValue = "-1") int stationFlag3,
                                       @RequestParam(name = "signal_strength_3", required = false, defaultValue = "-1") int signalStrength3,
                                       @RequestParam(name = "nation_num_4", required = false, defaultValue = "-1") int nationNum4,
                                       @RequestParam(name = "mobile_num_4", required = false, defaultValue = "-1") int mobileNum4,
                                       @RequestParam(name = "location_num_4", required = false, defaultValue = "-1") int locationNum4,
                                       @RequestParam(name = "community_num_4", required = false, defaultValue = "-1") int communityNum4,
                                       @RequestParam(name = "station_flag_4", required = false, defaultValue = "-1") int stationFlag4,
                                       @RequestParam(name = "signal_strength_4", required = false, defaultValue = "-1") int signalStrength4) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 获取时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        // 创建设备位置实体
        DeviceLocationEntity deviceLocationEntity = new DeviceLocationEntity();
        deviceLocationEntity.setDeviceId(deviceId);
        deviceLocationEntity.setRecordTime(simpleDateFormat.format(new Date()));
        deviceLocationEntity.setDeviceTime(deviceTime);
        deviceLocationEntity.setSignalQuality(signalQuality);
        deviceLocationEntity.setDeviceOnOff(deviceOnOff);
        deviceLocationEntity.setBatteryVoltage(batteryVoltage);
        if (longitude.compareTo(new BigDecimal(0)) > 0) {
            deviceLocationEntity.setLongitude(longitude);
        }
        if (longitudeDirection > 0) {
            deviceLocationEntity.setLongitudeDirection(longitudeDirection);
        }
        if (latitude.compareTo(new BigDecimal(0)) > 0) {
            deviceLocationEntity.setLatitude(latitude);
        }
        if (latitudeDirection > 0) {
            deviceLocationEntity.setLatitudeDirection(latitudeDirection);
        }
        if (agpsStationNum > 0) {
            deviceLocationEntity.setAgpsStationNum(agpsStationNum);
            String agps = "";

            if ((nationNum1 >= 0) &&
                    (mobileNum1 >= 0) &&
                    (locationNum1 >= 0) &&
                    (communityNum1 >= 0) &&
                    (stationFlag1 >= 0) &&
                    (signalStrength1 >= 0)) {
                deviceLocationEntity.setNationNum1(nationNum1);
                deviceLocationEntity.setMobileNum1(mobileNum1);
                deviceLocationEntity.setLocationNum1(locationNum1);
                deviceLocationEntity.setCommunityNum1(communityNum1);
                deviceLocationEntity.setStationFlag1(stationFlag1);
                deviceLocationEntity.setSignalStrength1(signalStrength1);

                agps += (nationNum1 + ",");
                agps += (String.format("%02d", mobileNum1) + ",");
                agps += (locationNum1 + ",");
                agps += (communityNum1 + ",");
                agps += (signalStrength1 * -1);
            }

            if ((nationNum2 >= 0) &&
                    (mobileNum2 >= 0) &&
                    (locationNum2 >= 0) &&
                    (communityNum2 >= 0) &&
                    (stationFlag2 >= 0) &&
                    (signalStrength2 >= 0)) {
                deviceLocationEntity.setNationNum2(nationNum2);
                deviceLocationEntity.setMobileNum2(mobileNum2);
                deviceLocationEntity.setLocationNum2(locationNum2);
                deviceLocationEntity.setCommunityNum2(communityNum2);
                deviceLocationEntity.setStationFlag2(stationFlag2);
                deviceLocationEntity.setSignalStrength2(signalStrength2);

                agps += ("|");
                agps += (nationNum2 + ",");
                agps += (String.format("%02d", mobileNum2) + ",");
                agps += (locationNum2 + ",");
                agps += (communityNum2 + ",");
                agps += (signalStrength2 * -1);
            }

            if ((nationNum3 >= 0) &&
                    (mobileNum3 >= 0) &&
                    (locationNum3 >= 0) &&
                    (communityNum3 >= 0) &&
                    (stationFlag3 >= 0) &&
                    (signalStrength3 >= 0)) {
                deviceLocationEntity.setNationNum3(nationNum3);
                deviceLocationEntity.setMobileNum3(mobileNum3);
                deviceLocationEntity.setLocationNum3(locationNum3);
                deviceLocationEntity.setCommunityNum3(communityNum3);
                deviceLocationEntity.setStationFlag3(stationFlag3);
                deviceLocationEntity.setSignalStrength3(signalStrength3);

                agps += ("|");
                agps += (nationNum3 + ",");
                agps += (String.format("%02d", mobileNum3) + ",");
                agps += (locationNum3 + ",");
                agps += (communityNum3 + ",");
                agps += (signalStrength3 * -1);
            }

            if ((nationNum4 >= 0) &&
                    (mobileNum4 >= 0) &&
                    (locationNum4 >= 0) &&
                    (communityNum4 >= 0) &&
                    (stationFlag4 >= 0) &&
                    (signalStrength4 >= 0)) {
                deviceLocationEntity.setNationNum4(nationNum4);
                deviceLocationEntity.setMobileNum4(mobileNum4);
                deviceLocationEntity.setLocationNum4(locationNum4);
                deviceLocationEntity.setCommunityNum4(communityNum4);
                deviceLocationEntity.setStationFlag4(stationFlag4);
                deviceLocationEntity.setSignalStrength4(signalStrength4);

                agps += ("|");
                agps += (nationNum4 + ",");
                agps += (String.format("%02d", mobileNum4) + ",");
                agps += (locationNum4 + ",");
                agps += (communityNum4 + ",");
                agps += (signalStrength4 * -1);
            }

            String url = String.format(
                    AGPS_CONVERT_URL,
                    (Object[]) new String[] {"9620", "gsm", agps, "10", "2", "json"});

            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();
            String data = response.body().string();
            AGpsEntity aGpsEntity = objectMapper.readValue(data, AGpsEntity.class);

            // 数据获取成功
            if (aGpsEntity.getStatus() == 200) {
                deviceLocationEntity.setLongitude(aGpsEntity.getLongitude());
                deviceLocationEntity.setLatitude(aGpsEntity.getLatitude());

                if (aGpsEntity.getLongitude().compareTo(new BigDecimal(0)) > 0) {
                    deviceLocationEntity.setLongitudeDirection(1);
                } else {
                    deviceLocationEntity.setLongitudeDirection(-1);
                }
                if (aGpsEntity.getLatitude().compareTo(new BigDecimal(0)) > 0) {
                    deviceLocationEntity.setLatitudeDirection(1);
                } else {
                    deviceLocationEntity.setLatitudeDirection(-1);
                }
            }
        }

        deviceLocationService.save(deviceLocationEntity);

        if (deviceLocationEntity.getId() > 0) {
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(deviceLocationEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
    }

    /**
     * @api {put} /api/manage/location 根据位置ID更新设备的实时位置
     * @apiVersion 0.0.1
     * @apiName updateDeviceLocationById
     * @apiGroup deviceLocationGroup
     *
     * @apiParam {Number} id 位置ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/location", method = RequestMethod.PUT)
    public ResultEntity updateDeviceLocationById(@RequestParam("id") long id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 获取当前要更新的位置数据
        DeviceLocationEntity locationEntity = deviceLocationService.findById(id);
        // Step1：获取获取当前设备的上一条位置数据
        List<DeviceLocationEntity> lastEntityList = deviceLocationService.getPreviousData(locationEntity.getDeviceId(), id);

        // 如果上一条数据的省市区没写则更新
        if (lastEntityList.size() == 1) {
            DeviceLocationEntity lastLocationEntity = lastEntityList.get(0);
            if (lastLocationEntity.getProvince() == null) {
                String gecodeUrl = String.format(
                        GECODE_CONVERT_URL,
                        (Object[]) new String[] {lastLocationEntity.getLongitude().toString() + "," + lastLocationEntity.getLatitude()});
                Request request = new Request.Builder().url(gecodeUrl).build();
                String data = httpClient.newCall(request).execute().body().string();

                // 获取JSON数据
                JsonNode geocodeNode = objectMapper.readTree(data);
                if (Integer.valueOf(geocodeNode.get("status").asText()) == 1) {
                    String province = geocodeNode.get("regeocode").get("addressComponent").get("province").isArray() ?
                            null : geocodeNode.get("regeocode").get("addressComponent").get("province").textValue();
                    String city = geocodeNode.get("regeocode").get("addressComponent").get("city").isArray() ?
                            null : geocodeNode.get("regeocode").get("addressComponent").get("city").textValue();
                    String district = geocodeNode.get("regeocode").get("addressComponent").get("district").isArray() ?
                            null : geocodeNode.get("regeocode").get("addressComponent").get("district").textValue();
                    // 如果数据有问题则删除数据
                    if (province != null && city != null && district != null) {
                        lastLocationEntity.setProvince(province);
                        lastLocationEntity.setCity(city);
                        lastLocationEntity.setDistrict(district);
                        this.deviceLocationService.update(lastLocationEntity);
                    } else {
                        this.deviceLocationService.delete(lastLocationEntity.getId());
                        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
                    }
                }
            }
        }

        // 如果该条数据既没有经纬度，有没有基站，那么数据就有问题，则删除
        if (locationEntity.getAgpsStationNum() <= 0) {
            return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
        }

        String agps = StringUtils.EMPTY;
        if ((locationEntity.getNationNum1() != null && locationEntity.getNationNum1() >= 0) &&
                (locationEntity.getMobileNum1() != null && locationEntity.getMobileNum1() >= 0) &&
                (locationEntity.getLocationNum1() != null && locationEntity.getLocationNum1() >= 0) &&
                (locationEntity.getCommunityNum1() != null && locationEntity.getCommunityNum1() >= 0) &&
                (locationEntity.getStationFlag1() != null && locationEntity.getStationFlag1() >= 0) &&
                (locationEntity.getSignalStrength1() != null && locationEntity.getSignalStrength1() >= 0)) {
            agps += (locationEntity.getNationNum1() + ",");
            agps += (String.format("%02d", locationEntity.getMobileNum1()) + ",");
            agps += (locationEntity.getLocationNum1() + ",");
            agps += (locationEntity.getCommunityNum1() + ",");
            agps += (locationEntity.getSignalStrength1() * -1);
        }

        if ((locationEntity.getNationNum2() != null && locationEntity.getNationNum2() >= 0) &&
                (locationEntity.getMobileNum2() != null && locationEntity.getMobileNum2() >= 0) &&
                (locationEntity.getLocationNum2() != null && locationEntity.getLocationNum2() >= 0) &&
                (locationEntity.getCommunityNum2() != null && locationEntity.getCommunityNum2() >= 0) &&
                (locationEntity.getStationFlag2() != null && locationEntity.getStationFlag2() >= 0) &&
                (locationEntity.getSignalStrength2() != null && locationEntity.getSignalStrength2() >= 0)) {
            agps += ("|");
            agps += (locationEntity.getNationNum2() + ",");
            agps += (String.format("%02d", locationEntity.getMobileNum2()) + ",");
            agps += (locationEntity.getLocationNum2() + ",");
            agps += (locationEntity.getCommunityNum2() + ",");
            agps += (locationEntity.getSignalStrength2() * -1);
        }

        if ((locationEntity.getNationNum3() != null && locationEntity.getNationNum3() >= 0) &&
                (locationEntity.getMobileNum3() != null && locationEntity.getMobileNum3() >= 0) &&
                (locationEntity.getLocationNum3() != null && locationEntity.getLocationNum3() >= 0) &&
                (locationEntity.getCommunityNum3() != null && locationEntity.getCommunityNum3() >= 0) &&
                (locationEntity.getStationFlag3() != null && locationEntity.getStationFlag3() >= 0) &&
                (locationEntity.getSignalStrength3() != null && locationEntity.getSignalStrength3() >= 0)) {
            agps += ("|");
            agps += (locationEntity.getNationNum3() + ",");
            agps += (String.format("%02d", locationEntity.getMobileNum3()) + ",");
            agps += (locationEntity.getLocationNum3() + ",");
            agps += (locationEntity.getCommunityNum3() + ",");
            agps += (locationEntity.getSignalStrength3() * -1);
        }

        if ((locationEntity.getNationNum4() != null && locationEntity.getNationNum4() >= 0) &&
                (locationEntity.getMobileNum4() != null && locationEntity.getMobileNum4() >= 0) &&
                (locationEntity.getLocationNum4() != null && locationEntity.getLocationNum4() >= 0) &&
                (locationEntity.getCommunityNum4() != null && locationEntity.getCommunityNum4() >= 0) &&
                (locationEntity.getStationFlag4() != null &&locationEntity.getStationFlag4() >= 0) &&
                (locationEntity.getSignalStrength4() != null && locationEntity.getSignalStrength4() >= 0)) {
            agps += ("|");
            agps += (locationEntity.getNationNum4() + ",");
            agps += (String.format("%02d", locationEntity.getMobileNum4()) + ",");
            agps += (locationEntity.getLocationNum4() + ",");
            agps += (locationEntity.getCommunityNum4() + ",");
            agps += (locationEntity.getSignalStrength4() * -1);
        }

        // Step2：根据基站数据获取高德的经纬度数据
        String aGpsUrl = String.format(
                AGPS_CONVERT_URL,
                (Object[]) new String[] {"9628", "gsm", agps, "10", "2", "json"});
        Request request = new Request.Builder().url(aGpsUrl).build();
        String data = httpClient.newCall(request).execute().body().string();
        AGpsEntity aGpsEntity = objectMapper.readValue(data, AGpsEntity.class);

        // 数据获取错误，说明数据有问题，则删除
        if (aGpsEntity.getStatus() != 200) {
            this.deviceLocationService.delete(locationEntity.getId());
            System.out.println(String.format("Status = %d, Msg = %s", aGpsEntity.getStatus(), aGpsEntity.getMsg()));
            return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
        }

        // Step3：把经纬度转化为地理信息
        String gecodeUrl = String.format(
                GECODE_CONVERT_URL,
                (Object[]) new String[] {aGpsEntity.getLongitude().toString() + "," + aGpsEntity.getLatitude()});
        request = new Request.Builder().url(gecodeUrl).build();
        data = httpClient.newCall(request).execute().body().string();
        JsonNode geocodeNode = objectMapper.readTree(data);

        // 转化为地理信息出错，说明数据有问题
        if (Integer.valueOf(geocodeNode.get("status").asText()) != 1) {
            this.deviceLocationService.delete(locationEntity.getId());
            System.out.println(String.format("Status = %d, Msg = %s", aGpsEntity.getStatus(), aGpsEntity.getMsg()));
            return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
        }

        // 获取地理信息中的省市县数据
        String province = geocodeNode.get("regeocode").get("addressComponent").get("province").isArray() ?
                null : geocodeNode.get("regeocode").get("addressComponent").get("province").textValue();
        String city = geocodeNode.get("regeocode").get("addressComponent").get("city").isArray() ?
                null : geocodeNode.get("regeocode").get("addressComponent").get("city").textValue();
        String district = geocodeNode.get("regeocode").get("addressComponent").get("district").isArray() ?
                null : geocodeNode.get("regeocode").get("addressComponent").get("district").textValue();

        // Step4：判断市是否相同
        // CASE1：只要有一个数据为空说明数据有问题，则删除
        if (province == null || city == null || district == null) {
            this.deviceLocationService.delete(locationEntity.getId());
            return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
        }
        // CASE2：判断省或市有一个相同，那么就保存
        if (city.equals(lastEntityList.get(0).getCity()) || province.equals(lastEntityList.get(0).getProvince())) {
            locationEntity.setProvince(province);
            locationEntity.setCity(city);
            locationEntity.setDistrict(district);

            locationEntity.setLongitude(aGpsEntity.getLongitude());
            locationEntity.setLatitude(aGpsEntity.getLatitude());

            if (aGpsEntity.getLongitude().compareTo(new BigDecimal(0)) > 0) {
                locationEntity.setLongitudeDirection((int) 'E');
            } else {
                locationEntity.setLongitudeDirection((int) 'W');
            }
            if (aGpsEntity.getLatitude().compareTo(new BigDecimal(0)) > 0) {
                locationEntity.setLatitudeDirection((int) 'N');
            } else {
                locationEntity.setLatitudeDirection((int) 'S');
            }

            locationEntity = deviceLocationService.update(locationEntity);
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(locationEntity, JsonNode.class));
        }

        // Step5：进一步判断所有基站是否相同
        List<String> cityList = new ArrayList<String>();
        // 利用Set唯一性判断数组元素是否全相同
        Set<String> cityEquals = new HashSet<String>();
        // 获取所有城市信息
        for (AGpsResultEntity resultEntity : aGpsEntity.getResult()) {
            String itemGecodeUrl = String.format(
                    GECODE_CONVERT_URL,
                    (Object[]) new String[] {resultEntity.getLng().toString() + "," + resultEntity.getLat().toString()});
            request = new Request.Builder().url(itemGecodeUrl).build();
            data = httpClient.newCall(request).execute().body().string();
            JsonNode itemGeocodeNode = objectMapper.readTree(data);

            String itemCity = itemGeocodeNode.get("regeocode").get("addressComponent").get("city").isArray() ?
                    null : itemGeocodeNode.get("regeocode").get("addressComponent").get("city").textValue();
            // 如果数据错误则删除
            if (itemCity == null) {
                this.deviceLocationService.delete(locationEntity.getId());
                System.out.println(String.format("Status = %d, Msg = %s", aGpsEntity.getStatus(), aGpsEntity.getMsg()));
                return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
            } else {
                cityList.add(itemCity);
                cityEquals.add(itemCity);
            }
        }

        // Step6：如果全部市数据相同，则保存
        // 如果满足条件说明城市有不同，则数据错误
        if (cityEquals.size() != 1) {
            this.deviceLocationService.delete(locationEntity.getId());
            System.out.println(String.format("Status = %d, Msg = %s", aGpsEntity.getStatus(), aGpsEntity.getMsg()));
            return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
        }

        locationEntity.setProvince(province);
        locationEntity.setCity(city);
        locationEntity.setDistrict(district);

        locationEntity.setLongitude(aGpsEntity.getLongitude());
        locationEntity.setLatitude(aGpsEntity.getLatitude());

        if (aGpsEntity.getLongitude().compareTo(new BigDecimal(0)) > 0) {
            locationEntity.setLongitudeDirection((int) 'E');
        } else {
            locationEntity.setLongitudeDirection((int) 'W');
        }
        if (aGpsEntity.getLatitude().compareTo(new BigDecimal(0)) > 0) {
            locationEntity.setLatitudeDirection((int) 'N');
        } else {
            locationEntity.setLatitudeDirection((int) 'S');
        }

        locationEntity = deviceLocationService.update(locationEntity);
        return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(locationEntity, JsonNode.class));
    }

    /**
     * @api {get} /api/manage/location/:id 根据ID获取设备位置数据
     * @apiVersion 0.0.1
     * @apiName getDeviceLocationById
     * @apiGroup deviceLocationGroup
     *
     * @apiParam {Number} id 设备ID
     *
     * @apiSuccess {String} code 返回码.
     * @apiSuccess {String} msg  返回消息.
     * @apiSuccess {Object} data  JSON格式的对象.
     */
    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public ResultEntity getDeviceLocationById(@PathVariable("id") long id) {
        List<DeviceLocationEntity> deviceLocationEntityList = deviceLocationService.getLocationHistory(id);

        if (deviceLocationEntityList.size() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            return this.createResultEntity(ResultEntity.SUCCESS,
                    objectMapper.convertValue(deviceLocationEntityList, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.NOT_FIND_ERROR);
    }
}

package siso.edu.cn.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import siso.edu.cn.entity.AGpsEntity;
import siso.edu.cn.entity.DeviceLocationEntity;
import siso.edu.cn.entity.ResultEntity;
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

            Map<String, String> urlVariables = new HashMap<String, String>();

            urlVariables.put("oid", "9620");
            urlVariables.put("key", "9557xx754z822y0wv8uz6x001u9yy4u2yz509");
            urlVariables.put("type", "gsm");
            urlVariables.put("bs", agps);
            urlVariables.put("hex", "10");
            urlVariables.put("to", "2");
            urlVariables.put("output", "json");

            String url = String.format(
                    "http://api.gpsspg.com/bs/?oid=%s&key=%s&type=%s&bs=%s&hex=%s&to=%s&output=%s",
                    (Object[]) new String[] {"9620", "9557xx754z822y0wv8uz6x001u9yy4u2yz509", "gsm", agps, "10", "2", "json"});

            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();

            JsonNode aGpsEntity = objectMapper.convertValue(response.body().string(), JsonNode.class);

            System.out.println(response.body().string());
        }

        deviceLocationService.save(deviceLocationEntity);

        if (deviceLocationEntity.getId() > 0) {
            return this.createResultEntity(ResultEntity.SUCCESS, objectMapper.convertValue(deviceLocationEntity, JsonNode.class));
        }

        return this.createResultEntity(ResultEntity.SAVE_DATA_ERROR);
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

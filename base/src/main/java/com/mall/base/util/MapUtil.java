package com.mall.base.util;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 地图转换工具
 * @Author HuangJiang
 * @Date 2018/9/4 11:18
 * @Version 1.0
 */
public class MapUtil {
	public static final String GAODEKEY = "4e1ff3c1f769782b09ec6032a6e94749";
	// 高德地图地址转经纬 get
	public static final String GAODE_GEO = "https://restapi.amap.com/v3/geocode/geo?address={address}&key=" + GAODEKEY;
	// 高德地图经纬转地址 get
	public static final String GAODE_REGEO = "https://restapi.amap.com/v3/geocode/regeo?location={location}&key=" + GAODEKEY;
	private static final RestTemplate restTemplate = new RestTemplate();
	private static final Logger LOGGER = LoggerFactory.getLogger(MapUtil.class);

	/**
	 * 地址转经纬度
	 * @param address
	 * @return Map  key lat 经度   key lng 纬度
	 */
	public static Map<String, Double> address2location(String address) {
		Map<String, String> urlParams = new HashMap<String, String>() {
			{
				put("address", address);
			}
		};
		String responseBody = restTemplate.getForObject(GAODE_GEO, String.class, urlParams);
		LOGGER.info("[请求网关: {}|响应数据: {}]", GAODE_GEO, responseBody);
		JsonObject jsonObject = JsonUtil.json2pojo(responseBody, JsonObject.class);
		JsonObject geocodes = jsonObject.getAsJsonArray("geocodes").get(0).getAsJsonObject();
		// 获取经纬度  "113.939945,22.540640"
		String[] locations = geocodes.get("location").getAsString().split(",");
		return new HashMap<String, Double>() {
			{
				put("lng", Double.valueOf(locations[0]));
				put("lat", Double.valueOf(locations[1]));
			}
		};
	}

	/**
	 * 经纬度转地址
	 * @param lng 经度
	 * @param lat 纬度
	 * @return address 详细地址, province 省, city 市, district 区, citycode 城市编码, adcode 行政区编码
	 */
	public static Map<String, String> location2address(String lng, String lat) {
		Map<String, String> result = new HashMap<String, String>();
		Map<String, String> urlParams = new HashMap<String, String>() {
			{
				put("location", lng + "," + lat);
			}
		};
		String responseBody = restTemplate.getForObject(GAODE_REGEO, String.class, urlParams);
		LOGGER.info("[请求网关: {}|响应数据: {}]", GAODE_REGEO, responseBody);
		JsonObject jsonObject = JsonUtil.json2pojo(responseBody, JsonObject.class);
		JsonObject regeocode = jsonObject.getAsJsonObject("regeocode");
		result.put("address", regeocode.get("formatted_address").getAsString());
		JsonObject addressComponent = regeocode.getAsJsonObject("addressComponent");
		result.put("province", addressComponent.get("province").getAsString());
		result.put("city", addressComponent.get("city").getAsString());
		result.put("district", addressComponent.get("district").getAsString());
		result.put("citycode", addressComponent.get("citycode").getAsString());
		result.put("adcode", addressComponent.get("adcode").getAsString());
		return result;
	}
}

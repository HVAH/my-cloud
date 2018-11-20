package com.mall.order.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;

/**
 * JSON工具
 * 
 * @author Cobain
 * @category 描述功能
 * @version 2016-11-03 初始化
 */
public final class JsonUtils {
	private static Gson gson = null;
	static {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(Long.class, new LongDeserializer());
		gb.registerTypeAdapter(Long.class, new LongSerialize());
		gson = gb.create();
	}

	static class LongDeserializer implements JsonDeserializer<Long> {

		@Override
		public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			return json.getAsLong();
		}

	}

	static class LongSerialize implements JsonSerializer<Long> {

		@Override
		public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(String.valueOf(src));
		}

	}

	/**
	 * 转成字符串
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Deprecated()
	public static String toJson(Object obj) {
		return obj2json(obj);
	}

	/**
	 * 对象转JSON字符串
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String obj2json(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 * JSON转对象
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T json2pojo(String jsonStr, Class<T> clazz) {
		return gson.fromJson(jsonStr, clazz);
	}

	/**
	 * JSON转MAP
	 * 
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@Deprecated()
	public static Map<String, String> json2map(String jsonStr) {
		return json2map(jsonStr, String.class);
	}

	/**
	 * JSON转MAP
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@Deprecated()
	public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
		return gson.fromJson(jsonStr, new TypeToken<HashMap<String, T>>() {
		}.getType());
	}

	/**
	 * JSON转列表
	 * 
	 * @param jsonArrayStr
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
		if (StringUtils.isBlank(jsonArrayStr)) {
			return null;
		}

		if (clazz == Date.class || clazz == String.class || clazz == Integer.class || clazz == Long.class || clazz == Float.class || clazz == Double.class || clazz == Boolean.class || clazz == BigDecimal.class) {
			TypeToken<List<T>> token = new TypeToken<List<T>>() {
			};
			return gson.fromJson(jsonArrayStr, token.getType());
		} else if (clazz.isInstance(Serializable.class)) {
			TypeToken<List<T>> token = new TypeToken<List<T>>() {
			};
			return gson.fromJson(jsonArrayStr, token.getType());
		} else {
			TypeToken<List<Map<String, Object>>> token = new TypeToken<List<Map<String, Object>>>() {
			};
			List<Map<String, Object>> list = gson.fromJson(jsonArrayStr, token.getType());
			List<T> result = new ArrayList<T>();
			for (Map<String, Object> map : list) {
				result.add(JsonUtils.json2pojo(gson.toJson(map), clazz));
			}
			return result;
		}
	}

	/**
	 * MAP转对象
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	@Deprecated()
	public static <T> T map2pojo(Map<?, ?> map, Class<T> clazz) {
		return json2pojo(obj2json(map), clazz);
	}
}

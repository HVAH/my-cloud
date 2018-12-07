package com.mall.base.utils;

import java.util.Map;

/**
 * @Description 集合工具类
 * @Author HuangJiang
 * @Date 2018/11/7 10:44
 * @Version 1.0
 */
public class CollectionUtils extends org.apache.commons.collections.CollectionUtils {

	/**
	 * @Title: isEmpty
	 * @Description: 判断集合类型为空
	 * @param map
	 * @return
	 */
	public static Boolean isEmpty(Map<?, ?> map) {
		return map == null || map.isEmpty();
	}

	/**
	 * @Title: isNotEmpty
	 * @Description: 判断集合类型不为空
	 * @param map
	 * @return
	 */
	public static Boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
}

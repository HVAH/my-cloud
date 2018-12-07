package com.mall.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Threadlocal
 * @Author HuangJiang
 * @Date 2018/11/7 10:44
 * @Version 1.0
 */
public class ThreadLocalUtils {
    private static ThreadLocal threadLocal = new ThreadLocal();


    private static final String KEY_USER_ID = "USER_ID";
    private static final String KEY_ROLES = "ROLES";

    private  static final Logger LOGGER = LoggerFactory.getLogger(ThreadLocalUtils.class);

    static{
        threadLocal.set(new HashMap<String,Object>());
    }



    public static void set(String key , Object object){
        HashMap<String, Object> map = getMap();
        map.put(key, object);
        LOGGER.debug("设置到本地线程缓存中，key:{} value:{}" , key , object);
    }

    private static HashMap<String ,Object> getMap(){
        HashMap<String,Object> map = ( HashMap<String,Object> )threadLocal.get();
        if (map == null) {
            map = new HashMap<String,Object>();
            threadLocal.set(map);
        }
        return map;
    }


    public static <T> T  get(String key) {
        HashMap<String,Object> map = ( HashMap<String,Object> )threadLocal.get();
        if (map == null) {
            return null;
        }
        return (T)map.get(key);
    }

    public static void remove(){
        Object obj = threadLocal.get();
        LOGGER.debug("开始从到本地线程缓存中移除!，计划移除对象：{}" , obj);
        threadLocal.remove();
        LOGGER.debug("已经从到本地线程缓存中移除!，移除后线程对象:" ,threadLocal.get());
    }

    public static void setUserId(Long userId) {
        set(KEY_USER_ID , userId);
    }
    public static void setRoles(Map<String, List<Long>> roles) {
        set(KEY_ROLES , roles);
    }

    public static Long getUserId() {
        return  get(KEY_USER_ID);
    }
    public static Map<String, List<Long>> getRoles() {
        return  get(KEY_ROLES);
    }
}

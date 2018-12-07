package com.mall.base.utils;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil{
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 批量删除对应的value
	 *
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 *
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}

	/**
	 * 删除对应的value
	 *
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 *
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 读取缓存
	 *
	 * @param key
	 * @return
	 */
	public Object get(final String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * get、set
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	public boolean setIfAbsent(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			result = operations.setIfAbsent(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 计数器
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	public Long incre(final String key, Long value, Long expireTime) {
		Long count = null;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			count = operations.increment(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public Long incre(final String key, Long value) {
		Long count = null;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			count = operations.increment(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
     * 指定时间类型---秒
     * @param key
     * @return
     */
    public long getExpireTimeTypeForSeconds(String key){
        long time = redisTemplate.getExpire(key,TimeUnit.SECONDS);
        return time;
    }
    
	public void publish(String channel,Object object) {
		redisTemplate.convertAndSend(channel, object);
	}
	
	/**
	 * @description: 批量插入(pipelined) 
	 * @author: huangjiang  2018年5月11日 下午2:48:47
	 *
	 * @param keyValueMap   Map 键值对    健和值都不能为null
	 * @param cover 是否覆盖相同key的值   true 是 false 否
	 * @param expireTime 过期时间 s  null 或 <= 0 表示不过期
	 * @return
	 */
	public Boolean batchInsert(final Map<String, Object> keyValueMap, final boolean cover, final Long expireTime) {
		@SuppressWarnings("unchecked")
		boolean result = (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {    
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {    
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                if (cover) {
                	if (expireTime != null && expireTime > 0) {
                		for (String keyStr : keyValueMap.keySet()) {    
		                    byte[] key  = serializer.serialize(keyStr);    
		                    byte[] value = serializer.serialize(keyValueMap.get(keyStr).toString());    
		                    connection.set(key, value);
		                    connection.expire(key, expireTime);
		                }    
		                return true;   
					} else {
						for (String keyStr : keyValueMap.keySet()) {    
		                    byte[] key  = serializer.serialize(keyStr);    
		                    byte[] value = serializer.serialize(keyValueMap.get(keyStr).toString());    
		                    connection.set(key, value); 
		                }    
		                return true;    
					}
				} else {
					if (expireTime != null && expireTime != 0) {
						for (String keyStr : keyValueMap.keySet()) {    
		                    byte[] key  = serializer.serialize(keyStr);    
		                    byte[] value = serializer.serialize(keyValueMap.get(keyStr).toString());    
		                    connection.setNX(key, value);
		                    connection.expire(key, expireTime);
		                }    
		                return true;   
					} else {
						for (String keyStr : keyValueMap.keySet()) {    
		                    byte[] key  = serializer.serialize(keyStr);    
		                    byte[] value = serializer.serialize(keyValueMap.get(keyStr).toString());    
		                    connection.setNX(key, value); 
		                }    
		                return true;   
					}
				}
                
                
            }    
        }, false, true);    
        return result;  
	}
}


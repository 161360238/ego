package com.ego.redis.dao;

public interface JedisDao {

	/**
	 * 判断是否存在
	 * 
	 * @param key
	 * @return
	 */
	Boolean exits(String key);

	/**
	 * 删除
	 * 
	 * @param key
	 * @return
	 */
	Long del(String key);

	/**
	 * 设置值
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);

	/**
	 * 取值
	 * @param key
	 * @return
	 */
	String get(String key);
}

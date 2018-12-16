package com.ecommerce.cn.config;

import redis.clients.jedis.Jedis;


public class RedisConfig {

	private static String ip = "192.168.168.106";
	private static int port = 6379;
	private static Jedis jedis;
	private static String productKey = "PRODUCT_DRINK_TEA";

	static {
		jedis = new Jedis(ip, port);
	}

	public static void init() {
		jedis.hset(productKey, "category", "drink");
		jedis.hset(productKey, "name", "tea");
		jedis.hset(productKey, "price", "10");
		jedis.hset(productKey, "volume", "100");
		jedis.hset(productKey, "unit", "罐");
		jedis.hset(productKey, "description", "茶是中国的传统特色文化，具有提神醒脑的效果。");
	}

	public static String hget(String key, String field) {
		String desc = jedis.hget(productKey, "description");
		return desc;
	}
	
}
package com.bet.cn.config;

import redis.clients.jedis.Jedis;



public class RedisConfig {

	private static String ip = "192.168.168.108";
	private static int port = 6379;
	public static Jedis jedis;

	static {
		jedis = new Jedis(ip, port);
	}

}
package com.bet.cn.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import com.bet.cn.config.RedisConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.beans.PropertyVetoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CorHostEngService {

	private RedisConfig redisConfig;
	
	
	
	public void service() {

		Jedis jedis = redisConfig.jedis;

		Map<String, String> map = jedis.hgetAll("");

	}

}
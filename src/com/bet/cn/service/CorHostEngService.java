package com.bet.cn.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

	private Jedis jedis = RedisConfig.jedis;



	public List<Map<String, Object>> service() {
		List<Map<String, Object>> resultList = new ArrayList<>();

		Set<String> keys = jedis.keys("bet_football_corner_cust_england_*_2018");
		
		for(String key : keys) {
			int startIndex = key.indexOf("bet_football_corner_cust_england_") + "bet_football_corner_cust_england_".length();
			int endIndex = key.indexOf("_2018");

			String team = key.substring(startIndex, endIndex);
			
			Map<String, Object> result = new HashMap<>();
			result.put("team", team);

			int custSelf = Integer.parseInt(jedis.hget(key, "cust_self"));
			int custOpposite = Integer.parseInt(jedis.hget(key, "cust_opposite"));
			int round = Integer.parseInt(jedis.hget(key, "round"));

			result.put("avgSelf", custSelf / round);
			result.put("avgOpposite", custOpposite / round);
			
			resultList.add(result);
		}

		return resultList;
	}
	
	
	
	public static void main(String[] args) {
		new CorHostEngService().service();
	}

}
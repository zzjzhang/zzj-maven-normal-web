package com.bet.cn.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;
import com.bet.cn.bean.CornerObj;
import com.bet.cn.config.RedisConfig;


public class CorCustEngService {

	private Jedis jedis = null;
	


	public List<Map<String, Object>> service() {
		jedis = new Jedis(RedisConfig.ip, RedisConfig.port);

		List<Map<String, Object>> resultList = new ArrayList<>();
		List<CornerObj> cornerObjList = new ArrayList<>();
		Set<String> keys = jedis.keys("bet_football_corner_cust_england_*");

		for(String key : keys) {
			int startIndex = key.indexOf("bet_football_corner_cust_england_") + "bet_football_corner_cust_england_".length();
			int endIndex = key.indexOf("_2018");

			String team = key.substring(startIndex, endIndex);
			int custSelf = Integer.parseInt(jedis.hget(key, "cust_self"));
			int custOpposite = Integer.parseInt(jedis.hget(key, "cust_opposite"));
			int round = Integer.parseInt(jedis.hget(key, "round"));

			CornerObj cornerObj = new CornerObj();
			cornerObj.setTeam(team);
			cornerObj.setAvgSelf(custSelf / round);
			cornerObj.setAvgOpposite(custOpposite / round);

			cornerObjList.add(cornerObj);
		}

		if(jedis != null) {
			jedis.close();
		}

		// 参考资料: https://www.cnblogs.com/xiaoxing/p/5977810.html
		Collections.sort(cornerObjList);

		for(CornerObj cornerObj : cornerObjList) {
			Map<String, Object> mapObj = new HashMap<>();
			mapObj.put("team", cornerObj.getTeam());
			mapObj.put("avgSelf", cornerObj.getAvgSelf());
			mapObj.put("avgOpposite", cornerObj.getAvgOpposite());

			resultList.add(mapObj);
		}

		return resultList;
	}


	
	
	
	

	public static void main(String[] args) {
		new CorHostEngService().service();
	}

}
package com.bet.cn.service;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import redis.clients.jedis.Jedis;
import com.bet.cn.bean.CornerObj;
import com.bet.cn.config.RedisConfig;



public class CorHostEngService {

	private Jedis jedis = null;



	public List<Map<String, Object>> service() {
		jedis = new Jedis(RedisConfig.ip, RedisConfig.port);

		List<Map<String, Object>> resultList = new ArrayList<>();
		List<CornerObj> cornerObjList = new ArrayList<>();
		Set<String> keys = jedis.keys("bet_football_corner_host_england_*");

		for(String key : keys) {
			int startIndex = key.indexOf("bet_football_corner_host_england_") + "bet_football_corner_host_england_".length();
			int endIndex = key.indexOf("_2018");

			String team = key.substring(startIndex, endIndex);
			int hostSelf = Integer.parseInt(jedis.hget(key, "host_self"));
			int hostOpposite = Integer.parseInt(jedis.hget(key, "host_opposite"));
			int round = Integer.parseInt(jedis.hget(key, "round"));

			CornerObj cornerObj = new CornerObj();
			cornerObj.setTeam(team);
			cornerObj.setAvgSelf(hostSelf / round);
			cornerObj.setAvgOpposite(hostOpposite / round);

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

}
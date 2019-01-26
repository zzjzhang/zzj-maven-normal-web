package com.bet.cn.service;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.bet.cn.bean.Game;
import java.util.Collections;
import java.util.HashMap;

import redis.clients.jedis.Jedis;


public class QueryService {

	private static Jedis jedis;



	public List<Map<String, Object>> serve() {
		jedis = new Jedis("192.168.168.105", 6379);
		Set<String> keys = jedis.keys("*");

		List<Game> gameList = new ArrayList<>();

		for(String key : keys) {
			String teams = key;
			Set<String> hfields = jedis.hkeys(teams);

			Game game = new Game();
			game.setTeams(teams);

			for(String hfield : hfields) {
				String value = "";

				if("scores".equals(hfield)) {
					value = jedis.hget(key, hfield);
					game.setScores(value);
				}

				if("time".equals(hfield)) {
					value = jedis.hget(key, hfield);
					game.setTime(value);
				}
			}

			gameList.add(game);
		}

		if(jedis != null) {
			jedis.close();
		}

		Collections.sort(gameList);

		List<Map<String, Object>> resultList = new ArrayList<>();

		for(Game game : gameList) {
			Map<String, Object> result = new HashMap<>();
			
			result.put("teams", game.getTeams());
			result.put("time", Integer.valueOf(game.getTime().split(":")[0]));
			result.put("scores", game.getScores());

			resultList.add(result);
		}
		
		return resultList;
	}



	public static void main(String[] args) {
		
		jedis = new Jedis("127.0.0.1", 6379);
		Set<String> keys = jedis.keys("*");

		List<Game> gameList = new ArrayList<>();

		for(String key : keys) {
			String teams = key;
			Set<String> hfields = jedis.hkeys(teams);

			Game game = new Game();
			game.setTeams(teams);

			for(String hfield : hfields) {
				String value = "";

				if("scores".equals(hfield)) {
					value = jedis.hget(key, hfield);
					game.setScores(value);
				}

				if("time".equals(hfield)) {
					value = jedis.hget(key, hfield);
					game.setTime(value);
				}

				gameList.add(game);
				
			}
		}

	}

}
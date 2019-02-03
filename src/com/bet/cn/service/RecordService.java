package com.bet.cn.service;

import java.util.List;
import com.bet.cn.bean.Game;
import redis.clients.jedis.Jedis;
import com.bet.cn.config.RedisConfig;


public class RecordService {

	//
	private Jedis jedis = null;

	//
	public RecordService() {
		
	}

	public void serve(List<Game> games) {
		checkRedis(games);
	}

	//
	private void checkRedis(List<Game> games) {
		jedis = new Jedis(RedisConfig.ip, RedisConfig.port);

		//////
		jedis.flushAll();
		//////

		for(Game game : games) {
			System.out.println(game.getTeams());

			// set redis
			jedis.hset(game.getTeams(), "scores", game.getScores());
			jedis.hset(game.getTeams(), "time", game.getTime());

			// 
			try {
				/*BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("D:\\ZZJ\\PROJECT\\COMPUTER\\JAVA\\WorkSpace\\zzj-normal-web\\WebContent\\RESOURCES\\music\\music.mp3"));
			    Player player = new Player(buffer);
			    player.play();

			    if(buffer != null) {
			    	buffer.close();
			    }*/
			} catch(Exception e) {
				
			}
		}

		jedis.close();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setTeams("team1");
		game.setTime("time");
		game.setScores("1-1");
		
		// new RecordService().checkRedis(game);
	}
}
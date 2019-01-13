package com.bet.cn.service;

import com.bet.cn.bean.Game;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import redis.clients.jedis.Jedis;
import java.io.BufferedInputStream;
import com.bet.cn.config.RedisConfig;


public class RecordService {

	//
	private Jedis jedis = null;

	//
	public RecordService() {
		
	}

	public void service(Game game) {
		checkRedis(game);
	}

	//
	private void checkRedis(Game game) {
		jedis = new Jedis(RedisConfig.ip, RedisConfig.port);
		Boolean exists = jedis.exists(game.getTeams());

		if(exists) {
			// do nothing...
		} else {
			// set redis
			jedis.hset(game.getTeams(), "scores", game.getScores());
			jedis.hset(game.getTeams(), "time", game.getTime());

			// 
			try {
				BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("D:\\ZZJ\\PROJECT\\COMPUTER\\JAVA\\WorkSpace\\zzj-normal-web\\WebContent\\RESOURCES\\music\\music.mp3"));
			    Player player = new Player(buffer);
			    player.play();

			    if(buffer != null) {
			    	buffer.close();
			    }
			} catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setTeams("team1");
		game.setTime("time");
		game.setScores("1-1");
		
		new RecordService().checkRedis(game);
	}
}
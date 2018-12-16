package com.bet.cn.service;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import redis.clients.jedis.Jedis;
import javax.servlet.ServletConfig;
import com.bet.cn.config.RedisConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.map.ObjectMapper;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ServletInit
 */
@WebServlet(description = "Initialization", urlPatterns = { "/bet/init" })
public class Init extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	private Jedis jedis = RedisConfig.jedis;
	
	
    public Init() {
        super();
        
        jedis = RedisConfig.jedis;
    }


	public void init(ServletConfig config) throws ServletException {
		String path = this.getClass().getResource("/").getPath();
		int index = path.indexOf("WEB-INF");
		
		path = path.substring(0, index);
		path = path + "RESOURCES" + File.separatorChar + "data" + File.separatorChar + "bet";
		
		File file1 = new File(path);
		File[] files = file1.listFiles();
		
		for(File file : files) {
			String fileName = file.getName();
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			FileReader fileReader;
			
			try {
				fileReader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(fileReader);
				String content = "";
				while((content = bReader.readLine()) != null) {
					ObjectMapper om = new ObjectMapper();
					Map<String, Object> mapJson = om.readValue(content, Map.class);
					
					Set<String> keySet = mapJson.keySet();

					String team = String.valueOf(mapJson.get("team"));

					String round = jedis.hget(team, "round");
					int roundCur = 0;
					
					if(round != null && !round.equals("")) {
						roundCur = Integer.parseInt(round);
					}

					roundCur = roundCur + 1;

					String hkey = "bet_" + fileName + "_" + team + "_2018";
					
					jedis.hset(hkey, "round", String.valueOf(roundCur));

					for(String key : keySet) {
						if(key.equals("cust_self") || key.equals("cust_opposite")) {
							int value = Integer.parseInt(String.valueOf(mapJson.get(key)));
							
							String valCur = jedis.hget(hkey, key);
							int intCur = 0;
							
							if(valCur != null && !valCur.equals("")) {
								intCur = Integer.parseInt(valCur);
							}

							int intNew = intCur + value;
							String valNew = String.valueOf(intNew);

							jedis.hset(hkey, key, valNew);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}


	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
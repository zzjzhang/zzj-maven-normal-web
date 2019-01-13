package com.bet.cn.service;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import redis.clients.jedis.Jedis;
import javax.servlet.ServletConfig;
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

	private Jedis jedis;



    public Init() {
        super();
        // jedis = RedisConfig.getJedis();
    }


	public void init(ServletConfig config) throws ServletException {
		String path = this.getClass().getResource("/").getPath();
		int index = path.indexOf("WEB-INF");

		path = path.substring(0, index);
		String dataFileDir = path + "RESOURCES" + File.separatorChar + "data" + File.separatorChar + "bet";

		File dataFile = new File(dataFileDir);
		File[] files = dataFile.listFiles();

		for(File file : files) {
			String fileName = file.getName();
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			FileReader fileReader;

			try {
				fileReader = new FileReader(file);
				BufferedReader bufReader = new BufferedReader(fileReader);
				String content = "";

				while((content = bufReader.readLine()) != null) {
					ObjectMapper objMapper = new ObjectMapper();
					Map<String, Object> dataMap = objMapper.readValue(content, Map.class);

					String team = String.valueOf(dataMap.get("team"));
					String hkey = "bet_" + fileName + "_" + team + "_2018";

					String roundStr = jedis.hget(hkey, "round");
					int roundInt = 0;

					if(roundStr != null && !roundStr.equals("")) {
						roundInt = Integer.parseInt(roundStr);
					}

					roundInt = roundInt + 1;

					jedis.hset(hkey, "round", String.valueOf(roundInt));

					Set<String> fieldSet = dataMap.keySet();

					for(String field : fieldSet) {
						if(field.equals("cust_self") || field.equals("cust_opposite") || field.equals("host_self") || field.equals("host_opposite")) {
							int value = Integer.parseInt(String.valueOf(dataMap.get(field)));

							String valCurStr = jedis.hget(hkey, field);
							int valCurInt = 0;

							if(valCurStr != null && !valCurStr.equals("")) {
								valCurInt = Integer.parseInt(valCurStr);
							}

							valCurInt = valCurInt + value;
							valCurStr = String.valueOf(valCurInt);

							jedis.hset(hkey, field, valCurStr);
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
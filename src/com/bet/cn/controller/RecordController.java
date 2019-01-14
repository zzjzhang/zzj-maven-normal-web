package com.bet.cn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bet.cn.bean.Game;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.bet.cn.service.RecordService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RecordController
 * 
 */
public class RecordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RecordService recordService;


    public RecordController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		recordService = new RecordService();
	}


	public ServletConfig getServletConfig() {
		return null;
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonStr = request.getParameter("data");

		JSONArray array = JSONArray.fromObject(jsonStr);
		int size = array.size();

		List<String> teamList = new ArrayList<>();

		for(int i = 0; i < size; i++) {
			Object object = array.get(i);
			JSONObject jObj = JSONObject.fromObject(object);
			Game game = (Game) JSONObject.toBean(jObj, Game.class);

			String[] scoreList = game.getScores().split("-");
			int score1 = Integer.parseInt(scoreList[0]);
			int score2 = Integer.parseInt(scoreList[1]);
			
			String[] timeList = game.getTime().split(":");
			int time1 = Integer.parseInt(timeList[0]);
			int time2 = Integer.parseInt(timeList[1]);

			if(time1 < 30) {
				if(score1 > 0 || score2 > 0) {
					teamList.add(game.getTeams());
				}
			}
		}

		for(String team : teamList) {
			System.out.println(team);
			recordService.service(team);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response : Access-Control-Allow-Origin
		response.setHeader("Access-Control-Allow-Origin", "*");

		// Set response : Character Encoding
		response.setCharacterEncoding("UTF-8");

		// Ö´ÐÐ Âß¼­
		service(request, response);
	}

}
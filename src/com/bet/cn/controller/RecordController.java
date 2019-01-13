package com.bet.cn.controller;

import java.io.IOException;
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

		for(int i = 0; i < size; i++) {
			Object object = array.get(i);
			JSONObject jObj = JSONObject.fromObject(object);
			Game game = (Game) JSONObject.toBean(jObj, Game.class);
			System.out.println(game.getTeams());
		}

		Game game = new Game();

		// recordService.service(game);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);

		// Set response : Access-Control-Allow-Origin
		response.setHeader("Access-Control-Allow-Origin", "*");

		// Set response : Character Encoding
		response.setCharacterEncoding("UTF-8");
	}

}
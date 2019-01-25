package com.bet.cn.controller;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import net.sf.json.JSONArray;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.bet.cn.service.QueryService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class QueryController
 */
public class QueryController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private QueryService queryService;



    public QueryController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		queryService = new QueryService();
	}

	public void destroy() {

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		List<Map<String, Object>> gameList = queryService.serve();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");

		//Set return value
		JSONArray jsonArray = JSONArray.fromObject(gameList);
		response.getWriter().write(jsonArray.toString());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		// service(request, response);

		// 
		List<Map<String, Object>> gameList = queryService.serve();

		//
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");

		//Set return value
		JSONArray jsonArray = JSONArray.fromObject(gameList);
		response.getWriter().write(jsonArray.toString());
		
	}

}
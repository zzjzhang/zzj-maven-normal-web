package com.bet.cn.controller;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.bet.cn.service.CorCustEngService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class QueryCornerCustEngland extends HttpServlet {
	//Fields
	private static final long serialVersionUID = 1L;

	private CorCustEngService corCustEngService;
	
	
    public QueryCornerCustEngland() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		corCustEngService = new CorCustEngService();
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> resultList = new ArrayList<>();

		resultList = corCustEngService.service();

		// Set response : Access-Control-Allow-Origin
		response.setHeader("Access-Control-Allow-Origin", "*");

		// Set response : Character Encoding
		response.setCharacterEncoding("UTF-8");

		//5. JSON Array is array, so get field value should define index[0, 1, 2...]
		
		//Set return value
		JSONArray jsonArray = JSONArray.fromObject(resultList);
		response.getWriter().write(jsonArray.toString());
	}

}
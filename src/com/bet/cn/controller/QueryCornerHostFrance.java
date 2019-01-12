package com.bet.cn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.beans.PropertyVetoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class QueryCornerHostFrance extends HttpServlet {
	//Fields
	private static final long serialVersionUID = 1L;

    public QueryCornerHostFrance() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> resultList = new ArrayList<>();
		
		/*try {
			resultList = DBOperator.selectCornerHostFrance();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

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
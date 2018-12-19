package com.ecommerce.cn.business;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.json.JSONArray;

import com.config.RedisConfig;
import com.ecommerce.cn.bean.User;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.ecommerce.cn.dao.DBOperator;
import java.beans.PropertyVetoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletLogin extends HttpServlet {
	//Fields
	private static final long serialVersionUID = 1L;

    public ServletLogin() {
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
		//1. Initialize a user
		User user = new User();

		//2. Set fields value
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));

		//3. Judge existence
		boolean result = Boolean.TRUE;
		try {
			// result = DBOperator.selectUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//4. Set session
		HttpSession httpSession = request.getSession();

		// Set response : Access-Control-Allow-Origin
		response.setHeader("Access-Control-Allow-Origin", "*");

		//5. JSON Array is array, so get field value should define index[0, 1, 2...]
		if(result) {
			//Set session value
			httpSession.setAttribute("name", user.getName());
			httpSession.setAttribute("password", user.getPassword());
			//Set return value
			JSONArray jsonArray = JSONArray.fromObject(user);
			response.getWriter().write(jsonArray.toString());
		} else {
			user.setName("none");
			user.setPassword("none");
			JSONArray jsonArray = JSONArray.fromObject(user);
			response.getWriter().write(jsonArray.toString());
		};

		//RedisConfig.init();
	}

}
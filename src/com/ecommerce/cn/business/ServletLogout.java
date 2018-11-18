package com.ecommerce.cn.business;

import java.io.IOException;
import net.sf.json.JSONArray;
import com.ecommerce.cn.bean.User;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletLogout extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public ServletLogout() {
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
		String nameParameter = request.getParameter("name");
		String nameSession = (String) request.getSession().getAttribute("name");
		User user = new User();

		if(nameParameter.equals(nameSession)) {
			user.setName(nameParameter);
			request.getSession().invalidate();

		} else {
			user.setName("none");

		}

		JSONArray jsonArray = JSONArray.fromObject(user);
		response.getWriter().write(jsonArray.toString());

	}

}
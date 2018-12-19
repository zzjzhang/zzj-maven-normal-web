package com.ecommerce.cn.business;

import java.io.IOException;
import net.sf.json.JSONArray;
import javax.servlet.ServletConfig;
import com.ecommerce.cn.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.ecommerce.cn.dao.DBOperator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet for display product details
 */
public class ServletDisplayProductDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public ServletDisplayProductDetail() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Initialize a product
		Product product = new Product();

		//2. Set fields value
		product.setName(request.getParameter("name"));

		//3. Set return product
		try {
			//product.setDescription(RedisConfig.hget(null, null));;
		} catch (Exception e) {
			e.printStackTrace();
		}

		//4. Set response header
		response.setContentType("text/html;charset=UTF-8");

		//5. Return product detail to client
		JSONArray jsonArray = JSONArray.fromObject(product);

		// Testing
		/*try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		// Testing

		response.getWriter().write(jsonArray.toString());

	}

}
package com.bet.cn.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ServletInit
 */
@WebServlet(description = "Initialization", urlPatterns = { "/bet/init" })
public class Init extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public Init() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		String path = this.getClass().getResource("/").getPath();
		int index = path.indexOf("WEB-INF");
		
		path = path.substring(0, index);
		path = path + "RESOURCES" + File.separatorChar + "data" + File.separatorChar + "bet";
		
		File file1 = new File(path);
		File[] files = file1.listFiles();
		
		for(File file : files) {
			FileReader fileReader;
			try {
				fileReader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(fileReader);
				String content = "";
				while((content = bReader.readLine()) != null) {
					ObjectMapper om = new ObjectMapper();
					Map<String, Object> mapJson = om.readValue(content, Map.class);
					
					Set<String> keySet = mapJson.keySet();
					
					for(String key:keySet) {
						System.out.println(key);
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

	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
}
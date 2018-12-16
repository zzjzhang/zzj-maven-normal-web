package com.ecommerce.cn.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="/business")
public class Main {
	//Methods
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("password"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MAINCATEGORY");
		return mv;
	}

	@RequestMapping(value="/ffa")
	public String test(HttpServletRequest request) {
		System.out.println(request.getQueryString());
		return "{'name':'Jack'}";
	}
}
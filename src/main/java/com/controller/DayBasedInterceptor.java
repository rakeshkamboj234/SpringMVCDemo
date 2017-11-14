package com.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayBasedInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		Calendar cal = Calendar.getInstance();
		int dayCheck = cal.get(cal.DAY_OF_WEEK);
		
		if(dayCheck == 4) {
			response.getWriter().write("Error occured." + dayCheck);
			return false;
		 }
		 response.getWriter().write("No Error occured : " + dayCheck);
		return true;
	}
}


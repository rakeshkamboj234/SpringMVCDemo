package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.controller.Student;

import java.util.*;
@Controller 
@RequestMapping("/path")
public class HelloController { 
	
	@InitBinder
	public void setInitBinder(WebDataBinder result){
		result.setDisallowedFields(new String[]{"city"});
	}
	
	@RequestMapping(value="/welcome.html", method = RequestMethod.GET)
	public ModelAndView check(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView modelandview = new ModelAndView("ErrorPage");
			return modelandview;
		}
		ModelAndView modelandview = new ModelAndView("HelloPage");
		return modelandview;
	}
	
	@ModelAttribute
	public void addCommonObject(Model model) {
		model.addAttribute("header","Welcome");
	}
}
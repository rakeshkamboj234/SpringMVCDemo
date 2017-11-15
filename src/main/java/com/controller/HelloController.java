package com.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.controller.Student;

@Controller 
@RequestMapping("/path")
public class HelloController { 
	
	@InitBinder
	public void setInitBinder(WebDataBinder result){
		result.setDisallowedFields(new String[]{"city"});
	}
	
	@RequestMapping(value={"/welcome.html","/hello.html"}, method = RequestMethod.GET)
	public ModelAndView check(@Valid @ModelAttribute Student student, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView modelandview = new ModelAndView("ErrorPage");
			return modelandview;
		}
		ModelAndView modelandview = new ModelAndView("HelloPage");
		return modelandview;
	}
	
	@RequestMapping(value={"/NullPointerException.html"}, method = RequestMethod.GET)
	public ModelAndView nullCheck(@Valid @ModelAttribute Student student, BindingResult result) throws Exception {
		
		String exceptionCheck = "nullPointer";
		if(exceptionCheck.equals("nullPointer")){
			throw new NullPointerException("NullPointerException");
		}
		
		ModelAndView modelandview = new ModelAndView("ExceptionPage");
		return modelandview;
	}
	
	@RequestMapping(value={"/IOException.html"}, method = RequestMethod.GET)
	public ModelAndView ioCheck(@Valid @ModelAttribute Student student, BindingResult result) throws Exception {
		
		String exceptionCheck = "IOException";
		if(exceptionCheck.equals("IOException")){
			throw new IOException("IOException");
		}
		
		ModelAndView modelandview = new ModelAndView("ExceptionPage");
		return modelandview;
	}
	
	@ModelAttribute
	public void addCommonObject(Model model) {
		model.addAttribute("header","Welcome");
	}
}
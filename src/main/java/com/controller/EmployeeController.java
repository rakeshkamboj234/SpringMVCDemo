package com.controller;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.Employee;

@RestController
public class EmployeeController { 
	
	@RequestMapping(value = "/employee" , produces = MediaType.APPLICATION_XML_VALUE)
	public Employee checkEmp() {		
		Employee employee2 = new Employee();
		employee2.setCity("FB");
		employee2.setName("Rakesh");		
		return employee2;		
	}
	
	@RequestMapping(value = "/employee/{name}/city/{city}",  headers="Accept=*/*", method = RequestMethod.GET , produces = MediaType.APPLICATION_XML_VALUE)
	public Employee check(@PathVariable("name") String name,@PathVariable("city") String city) {
		
		Employee employee2 = new Employee();
		employee2.setCity(city);
		employee2.setName(name);
		
		return employee2;
		
	}
	
}
package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.controller.Student;

@RestController
@EnableWebMvc
public class StudentController { 
	
	@InitBinder
	public void setInitBinder(WebDataBinder result){
		result.setDisallowedFields(new String[]{"city"});
	}

	@RequestMapping(value = "/student/{name}/city/{city}")//, method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json")
	//@ResponseBody
	public ArrayList<Student> check(@PathVariable("name") String name,@PathVariable("city") String city) {
		
		Student student = new Student();
		student.setCity("fb");
		student.setName("rakesh");
		
		Student student2 = new Student();
		student2.setCity(city);
		student2.setName(name);
		
		Student student1 = new Student();
		student1.setCity("tronto");
		student1.setName("vikram");
		
		ArrayList<Student> arrayList = new ArrayList<Student>();
		arrayList.add(student2);
		arrayList.add(student1);
		arrayList.add(student);
		
		return arrayList;
		
	}
	
}
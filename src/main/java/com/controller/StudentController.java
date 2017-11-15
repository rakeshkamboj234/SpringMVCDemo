package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.controller.Student;

@Controller 
@EnableWebMvc
public class StudentController { 
	
	@InitBinder
	public void setInitBinder(WebDataBinder result){
		result.setDisallowedFields(new String[]{"city"});
	}

	@RequestMapping(value = "/admission")//, method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json")
	@ResponseBody
	public ArrayList<Student> check() {
		
		Student student = new Student();
		student.setCity("fb");
		student.setName("rakesh");
		
		Student student2 = new Student();
		student2.setCity("tronto");
		student2.setName("vikram");
		
		Student student1 = new Student();
		student1.setCity("tronto");
		student1.setName("vikram");
		
		ArrayList<Student> arrayList = new ArrayList<Student>();
		arrayList.add(student);
		arrayList.add(student1);
		arrayList.add(student2);
		
		return arrayList;
		
	}
	
}
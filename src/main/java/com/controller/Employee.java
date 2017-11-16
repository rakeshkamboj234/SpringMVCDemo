package com.controller;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement (name = "employee")
//@XmlAccessorType(XmlAccessType.NONE)
public class Employee { 
	
	@XmlElement
	String name;
	@XmlElement
	String city;
	public Employee(){}
	public Employee(String city, String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString(){
		return "Name : " + name + "City : "+city;
		
	}
}
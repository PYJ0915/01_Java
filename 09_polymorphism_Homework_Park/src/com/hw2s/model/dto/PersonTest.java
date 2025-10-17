package com.hw2s.model.dto;

public class PersonTest {
	
	private String name;
	private int age;
	public static final String NATION = "Korea";
	
	public PersonTest() {
		// TODO Auto-generated constructor stub
	}

	public PersonTest(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String explain(String address) {
		
		return "사는 곳: " + NATION + ", " + address;
		
	}
	
}

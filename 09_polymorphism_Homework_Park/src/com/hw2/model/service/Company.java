package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{

	private Employee[] employees;

	private int employeeCount;

	public Company(int size) {
		employees = new Employee[size];
	}

	@Override
	public void addPerson(Person person) {
		Person p1 = new Employee("1205","정준하","밥도둑");
		Person p2 = new Employee("0705","박명수","웃음연쇄살인");
	}


	@Override
	public void removePerson(String id) {
		
	}


	@Override
	public void displayAllPerson() {
		
	}
	
	
}

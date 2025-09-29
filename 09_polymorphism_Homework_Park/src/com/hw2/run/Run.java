package com.hw2.run;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.Prison;

public class Run {

	public static void main(String[] args) {

		Company c = new Company(10);
		
		Prison p = new Prison(10);
		
		Person emp1 = new Employee("EMP001","유재석","기획팀");
		Person emp2 = new Employee("EMP002","정형돈","개발팀");
		
		Person p1 = new Prisoner("1205","정준하","밥도둑");
		Person p2 = new Prisoner("0705","박명수","웃음연쇄살인");
		
		
	}

}

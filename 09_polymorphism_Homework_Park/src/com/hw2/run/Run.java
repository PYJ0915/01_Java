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
		
		Person emp1 = new Employee("EMP001", "유재석", "기획팀"); 
		Person emp2 = new Employee("EMP002", "정형돈", "개발팀"); 
		
		Person prisoner1 = new Prisoner("1205", "정준하", "밥도둑");
		Person prisoner2 = new Prisoner("0705", "박명수", "웃음연쇄살인");
		
		c.addPerson(emp1);
		c.addPerson(emp2);
		System.out.println("전체 직원 명단: ");
		c.displayAllPerson();
		System.out.println("======================================================================");
		p.addPerson(prisoner1);
		p.addPerson(prisoner2);
		System.out.println("전체 수감자 명단: ");
		p.displayAllPerson();
		System.out.println("======================================================================");
		c.removePerson("EMP001");
		p.removePerson("1205");
		System.out.println("======================================================================");
		System.out.println("전체 직원 명단: ");
		c.displayAllPerson();
		System.out.println("전체 수감자 명단: ");
		p.displayAllPerson();
		
	}

}

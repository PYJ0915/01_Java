package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{

	private Employee[] employees;

	private int employeeCount;

	public Company(int size) {
		employees = new Employee[size];
		employeeCount = 0;
	}

	@Override
	public void addPerson(Person person) {
		
		for(int i = 0; i < employees.length; i++) {
			
			if(employees[i] == null) {
				
				employees[i] = (Employee)person; // 다운캐스팅 -> 자식 필드에 접근하기 위해
				System.out.print("직원이 추가되었습니다 - ");
				System.out.println(employees[i].getInfo());
				employeeCount++;
				return;
			
			} 
			
		}
		
		System.out.println("인원이 모두 충원되었습니다.");
		
	}


	@Override
	public void removePerson(String id) {
		
		for(int i = 0; i < employees.length; i++) {
			
			if(id.equals(employees[i].getId())) {
				
				System.out.print("직원이 삭제되었습니다 - ");
				System.out.println(employees[i].getInfo());
				employees[i] = null;
				employeeCount--;
				return;
				
			} 
		}
		
		System.out.println("해당하는 직원을 찾을 수 없습니다.");
		
	}


	@Override
	public void displayAllPersons() {
		
		for(int i = 0; i < employees.length; i++) {
			
			if(employees[i] != null) {
				
				System.out.println(employees[i].getInfo());
				
			}
		}
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	
}

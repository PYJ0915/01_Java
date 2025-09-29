package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {
	
	Prisoner[] prisoners;
	
	private int prisonerCount;
	
	public Prison(int size) {
		prisoners = new Prisoner[size];
	}

	@Override
	public void addPerson(Person person) {
		
		for(int i = 0; i < prisoners.length; i++) {
			
			if(prisoners[i] == null) {
				
				
				
			}
			
			
		}
	}

	@Override
	public void removePerson(String id) {
		
	}

	@Override
	public void displayAllPerson() {
		
	}
	
}

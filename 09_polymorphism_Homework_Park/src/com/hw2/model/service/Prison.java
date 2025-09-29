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

		for (int i = 0; i < prisoners.length; i++) {
			
			if(prisoners[i] == null) {
				prisoners[i] = (Prisoner)person;
				System.out.print("수감자가 추가되었습니다 - ");
				System.out.println(prisoners[i].getInfo());
				return;
			}
		}

		System.out.println("인원이 모두 충원되었습니다.");

	}

	@Override
	public void removePerson(String id) {

		for (int i = 0; i < prisoners.length; i++) {

			if (id.equals(prisoners[i].getId())) {

				System.out.print("수감자가 삭제되었습니다 - ");
				System.out.println(prisoners[i].getInfo());
				prisoners[i] = null;
				break;

			} else {
				System.out.println("해당하는 수감자를 찾을 수 없습니다.");
			}

		}
	}

	@Override
	public void displayAllPerson() {

		for (int i = 0; i < prisoners.length; i++) {

			if (prisoners[i] != null) {

				System.out.println(prisoners[i].getInfo());
				
				prisonerCount++;
				
			}
		}
	}

}

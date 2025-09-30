package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {

	Prisoner[] prisoners;

	private int prisonerCount;

	public Prison(int size) {
		prisoners = new Prisoner[size];
		prisonerCount = 0;
	}

	@Override
	public void addPerson(Person person) {

		for (int i = 0; i < prisoners.length; i++) {
			
			if(prisoners[i] == null) {
				prisoners[i] = (Prisoner)person; // 다운캐스팅 -> 자식 필드에 접근하기 위해
				System.out.print("수감자가 추가되었습니다 - ");
				System.out.println(prisoners[i].getInfo());
				prisonerCount++;
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
				prisonerCount--;
				return;

			}  

		}
		System.out.println("해당하는 수감자를 찾을 수 없습니다.");
	}

	@Override
	public void displayAllPersons() {

		for (int i = 0; i < prisoners.length; i++) {

			if (prisoners[i] != null) {

				System.out.println(prisoners[i].getInfo());
				
			}
		}
	}

	public int getPrisonerCount() {
		return prisonerCount;
	}

	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}

}

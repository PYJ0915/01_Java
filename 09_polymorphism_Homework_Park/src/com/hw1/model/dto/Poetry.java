package com.hw1.model.dto;

public class Poetry extends Book{

	private int numberOfPoems;
	
	public Poetry() {
		// TODO Auto-generated constructor stub
	}

	public Poetry(String title, String author, int numberOfPoems) {
		super(title, author);
		this.numberOfPoems = numberOfPoems;
	}
	
	@Override
	public void displayInfo() {
		System.out.printf("[시집] 제목: %s / 저자: %s / 시 수: %d", super.getTitle(), super.getAuthor(), numberOfPoems);
	}
	
}

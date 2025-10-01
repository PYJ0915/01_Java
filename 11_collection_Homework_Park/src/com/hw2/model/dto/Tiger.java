package com.hw2.model.dto;

public class Tiger extends Animal {

	public Tiger() {
		
	}

	
	public Tiger(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println( super.name + "가 어흥하며 표효합니다");
	}
	
	
	
	
}

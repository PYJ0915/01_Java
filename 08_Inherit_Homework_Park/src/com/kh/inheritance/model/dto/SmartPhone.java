package com.kh.inheritance.model.dto;

public class SmartPhone extends Phone{

	private String operatingSystem; // OS
	
	private int storageCapacity; // 저장 공간 크기
	
	public SmartPhone() {
		
	}

	public SmartPhone(String brand, String model, int year, int price, String operatingSystem, int storageCapacity) {
		super(brand, model, year, price);
		this.operatingSystem = operatingSystem;
		this.storageCapacity = storageCapacity;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Operating System: " + operatingSystem);
		System.out.println("Storage Capacity: " + storageCapacity);
	}

	
	
	
	
}

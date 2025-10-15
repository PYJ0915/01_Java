package edu.kh.imsolo.model.dto;

import java.util.List;

public class Member {
	
	private String name;
	private int age;
	private String job;
	private String region;
	private char gender;
	private List<String> hobby;
	
	public Member() {
		
	}

	public Member(String name, int age, String job, String region, char gender, List<String> hobby) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.region = region;
		this.gender = gender;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s(%d, %s, %s) ", name, age, job, region) + "| 취미: " + hobby;
	}

}

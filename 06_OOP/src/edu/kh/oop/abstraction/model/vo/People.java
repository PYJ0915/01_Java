package edu.kh.oop.abstraction.model.vo;

// model : 프로그램 로직과 관련되어있는 데이터를 저장하는 용도
//       + 비즈니스 로직
// vo(value object): 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지


public class People { // 국민(사람) 클래스
	
	// 클래스란? 객체의 특성(속성 + 기능)을 정의한 것
	// == 객체를 만들기 위한 설계도
	
	// 속성 == 값 == data
	// 값을 저장하기 위한 변수를 선언하는 구간
	// -> 국민이라면 공통적으로 가지고 있는 속성만 작성 (추상화)
	// 이름, 성별, 주민번호, 주소, 전화번호, 나이 ...
	// 필드 == 필드변수 == 멤버변수
	
	// 캡슐화
		// - 데이터(속성)와 (기능)을 하나로 묶어서 관리하는 기법
		// - 데이터의 직접적인 접근을 제한하는 것이 원칙이다
		// -> 직접 접근을 하지 못하기 때문에 클래스 내부에 간접 접근 방법을 제공하는 기능(메서드)를 작성하여 사용
		// -> getter/setter 
	
	// 데이터 직접 접근 제한 
	// public -> private 변경
	
	
	// [접근제한자] 자료형 변수명;
	 
	private String name; // 이름
	private char gender; // 성별
	private String pNo; // 주민번호 "123456 - 1234567"
	private String phone; // 전화번호 "010-1234-1234"
	private String address; // 주소
	private int age; // 나이 
	
	// double bitCoin; // 모든 국민이 가진 공통점이 아니므로 속성에 들어갈 수 X 
	
	
	
	
	
	// 기능 == 행동(동작) == method(메서드)
	public void tax() {
		
		System.out.println("세금을 낸다...");
		return; // 메서드 종료하는 코드 (미작성시 JVM이 자동 작성)
	}
	public void vote() {
		
		System.out.println("투표를 한다...");
		return; 
	}
	
	// 캡슐화에서 사용할 간접 접근 기능(getter/setter)
	// [접근제한자] 반환형 메서드명(매개변수) {}
	
	// name 변수의 값을 호출한 쪽으로 돌려보내주는 간접 기능 중 getter
	
	// void: 반환할 값이 없다 (반환형이 없다)
	// return : 반환, 되돌려주다
	// return; : 현재 메서드를 종료하고 호출한 쪽으로 되돌아감
	// return 값/변수 : 현재 메서드를 종료하고 값/변수 가지고 호출한 쪽으로 되돌아감
	
	/*	
	public String getName() {
		
		return name; 	// name 이라는 반환값 있음! 
					 // 반환형: 반환되는 값의 자료형
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	*/
	// this: 현재 객체의 필드 ex. this.name == 현재 객체의 필드에 있는 name 에 접근
	
	// getter(): getter는 필드에 작성된 변수 값을 호출한 쪽으로 되돌려주는 역할
	// -> 반환형이 무조건 있음 -> 변수값은 자료형이 있음
	// -> 그 변수를 되돌려준다면 당연히 반환형도 존재!
	
	// setter(): setter는 전달인자에 작성된 값을 동해 매개변수로 들어온 값을 객체의 필드에 세팅하는 역할
	// -> 반환형은 없지만 매개변수가 항상 있음(== 전달인자값)
	// -> 전달인자에는 자료형이 있음 -> 매개변수 자료형 있음 -> 매개변수 작성법: (자료형 매개변수명)
	// -> 단순히 전달값으로 필드에 값을 세팅하는 역할이기 때문에 호출한 쪽을 되돌려줄 값은 없음.
	// -> 반환형도 없음(void)
	
	/*
	public char getGender() {
		
		return gender;
		
	}
	
	public void setGender(char gender) {
		
		this.gender = gender;
		
	}
	public String getAddress() {
		
		return address;
		
	}
	
	public void setAddress(String address) {
		
		this.address = address;
		
	}
	public String getPNo() {
		
		return pNo;
		
	}
	
	public void setPNo(String pNo) {
		
		this.pNo = pNo;
		
	}
	public String getPhone() {
		
		return phone;
		
	}
	
	public void setPhone(String phone) {
		
		this.phone = phone;
		
	}
	public int getAge() {
		
		return age;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	*/
	
	// 상단메뉴의 Source 누르고 Generate getters and setters 누르면 getter, setter 를 만들어줌
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getpNo() {
		return pNo;
	}
	
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
}
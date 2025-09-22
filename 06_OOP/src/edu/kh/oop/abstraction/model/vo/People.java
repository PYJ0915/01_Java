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
	
	
	// [접근제어자] 자료형 변수명;
	/* 
	private String name; // 이름
	private char gender; // 성별
	private String pNo; // 주민번호 "123456 - 1234567"
	private String phone; // 전화번호 "010-1234-1234"
	private String address; // 주소
	private int age; // 나이 
	*/
	// double bitCoin; // 모든 국민이 가진 공통점이 아니므로 속성에 들어갈 수 X 
	
	
	
	
	
	// 기능 == 행동(동작) == method(메서드)
	public void tax() {
		
		System.out.println("세금을 낸다...");
		
	}
	public void vote() {
		
		System.out.println("투표를 한다...");
		
	}
	
	// 캡슐화에서 사용할 간접 접근 기능(getter/setter)
	// [접근제어자] 반환형 메서드명() {}
	
}
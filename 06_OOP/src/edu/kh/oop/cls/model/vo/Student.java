package edu.kh.oop.cls.model.vo;

public class Student { // 클래스 선언부
// [접근 제한자] [예약어] class 클래스명 {}
	
	
	// 접근제한자 public: 같은 프로젝트 내에서 어떤 클래스에서든 import 하여 사용할 수 있음을 나타냄.
	
	//TestVO test = new TestVO();
	// (default) 클래스는 같은 패키지 내에서만 사용 가능
	
	// 1. 필드(field)
	
	// 필드의 접근제한자 예제
	// 필드 접근제한자 뜻 : 직접 접근이 가능한 범위를 나타냄
	
	public int v1 = 10; // 전체에서 접근 가능
	
	protected int v2 = 20; // 후손클래스까지 접근 가능
	
	int v3 = 30; // (default) 같은 패키지내까지 가능
	
	private int v4 = 40; // 해당클래스 내부에서만 가능
	
	// static 예약어
	public static String schoolName = "KH고등학교";
	
	// final 예약어
	private final int TEMP1 = 100;
	
	// getter 만 만들어진 이유
	// final 예약어가 붙은 상수 TEMP1은 재대입이 불가하여 setter 를 굳이 만들어주지 않음
	public int getTEMP1() {
		return TEMP1;
	}

	
	// 2. 생성자(Constructor) -> 다른 클래스에서
	
	
	// 오버로딩: 한 클래스 내에 동일한 이름의 메서드를 여러 개 작성하는 기법
	
	// 오버로딩 작성 규칙
	// 1) 메서드명 동일
	// 2) 매개변수의 자료형, 개수, 순서가 달라야함
	// 3) 반환형은 같아도 되고 달라도 된다
	// 4) 변수명은 신경쓰지 않는다 -> 변수명이 달라도 매개변수의 자료형, 개수, 순서가 같다면 오버로딩 성립 불가
	
	
	
	
	// 3. 메서드
	
	public void ex() {
		
		// 필드 접근제한자 확인하기
		// v1 ~ v4까지 전부 Student 클래스 내부에서 생성된 변수이기 때문에
		// v1 ~ v4까지 전부 직접 접근 가능
		
		System.out.println( v1 );
		System.out.println( v2 );
		System.out.println( v3 );
		System.out.println( v4 );
		
	}


	
	
}

package edu.kh.basic;

// 주석 : 컴파일러가 해석하지 않는 구문 (메모용)
// 한 줄 주석
/* 범위 주석 */ 
public class JavaTest {
	// main 메서드 : 자바 프로그램(애플리케이션)을 
	//				 실행하기 위해서 반드시 필요한 필수 기능들을 모아놓은 구문
	// main 메서드 쉽게 만들기 : main 작성 후 Ctrl + space -> Enter 자동완성
	public static void main(String[] args) {
		// main 메서드 안에 작성한 코드를 실행시키는 방법 
		// 단축키 : ctrl + f11
		// 상단에 초록색 재생 버튼
		System.out.println("Hello World!!");
		// 프린트 구문 쉽게 만들기 : syso 작성 후 ctrl + space -> Enter 자동완성
		// 저장 단축키 : ctrl + s (저장 여부 확인은 탭에 * 로 확인 가능)
		System.out.println("Hi");
		System.out.println(1234); 
		System.out.println("1234"); 
		System.out.println(); // 개행만
		System.out.println("집 가고 싶다");
		System.out.println("2025-09-10");
		// 쉽게 복사하는 단축키 : ctrl + alt + 방향키 : 방향키 방향으로 해당 줄 복사
		System.out.println();
		System.out.println();
		System.out.println("1 + 2"); // 1 + 2
		System.out.println(1 + 2); // 3
		// "" 안에 작성된 코드는 단순 문자열로 인식
		// "" 안에 작성되지 않은 코드는 숫자, 변수로 인식
		System.out.println(304 - 94);
		System.out.println(23 * 83);
		System.out.println(235 / 5);
		System.out.println(36 % 7); // %(모듈러) : 나머지 구하는 연산자
		System.out.println("14 * 19 = " + 14 * 19 );
		// 자바는 사칙연산의 우선순위를 그대로 따름
		// 우선 계산을 원하면 괄호 사용
		System.out.println("90 + 70 + 65 = " + (90 + 70 + 65));
				
	}
}

package edu.kh.control.condition;

import java.util.Scanner;


public class ConditionExample { // 기능 제공용 클래스
	
	Scanner sc = new Scanner(System.in); // 필드
	
	// 메서드 (+ 생성자)
	
	public void ex1() {
		
		// if 문: 조건식이 true 일 때만 내부 코드 수행 
		
		// 입력 받은 정수가 양수인지 구분하라. 양수라면 "양수입니다" 출력.
		
		System.out.print("정수 입력: ");
		int input1 = sc.nextInt();
		
		if (input1 > 0) { 
			System.out.println("양수입니다.");
		} 
		
		if (input1 <= 0) {
			System.out.println("양수가 아닙니다.");
		}
		
		
	}
	public void ex2() {
		// if - else 문 : 조건식 결과가 true 면 if 구문, false 면 else 구문 수행됨
		
		//홀짝 검사
		// 입력 받은 정수 값이 홀수이면 "홀수입니다",
		// 짝수이면 "짝수입니다", 0이면 "0입니다" 를 출력하시오.
		
		// 중첩 if 문 사용
			System.out.print("정수 입력: ");
			int input = sc.nextInt();
			
			if( input % 2 != 0 ) { 
				
				System.out.println("홀수입니다.");
				
			} else { // 짝수거나 0인 경우
				
				if(input == 0) { 
					System.out.println("0입니다.");
			} else {
					System.out.println("짝수입니다.");
			}
		}
	}
	public void ex3() {
		//if(조건식) - else if(조건식) - else
		
		// 양수,음수,0 판별
			System.out.print("정수 입력: ");
			int input = sc.nextInt();
			
			if(input > 0) { 
				System.out.println("양수입니다.");
				
			} else if (input < 0) {
				System.out.println("음수입니다.");
				
			} else { 
				System.out.println("0입니다.");
			}
	}
	public void ex4() {
		// 달(month)을 입력받아 해당 달에 맞는 계절을 출력하라.
		// 단, 여름과 겨울에는 온도(temperature) 입력 받기
		// 1,2,12 겨울 , 3 ~ 5 봄, 6 ~ 8 여름 9 ~ 11 가을, 1 ~ 12 바깥 해당하는 계절이 없습니다.
		// 겨울일 때 (-15도 이하: "겨울 한파 경보" / -12도 이하: "겨울 한파 주의보" )
		// 여름일 때 (35도 이상: "여름 폭염 경보" / 33도 이상: " 여름 폭염 주의보" )
		
		System.out.print("달을 입력하세요: ");
		int month = sc.nextInt();
		
		String season; // 계절명을 저장할 변수
		
		if( month == 1 || month == 2 || month == 12 ) { 
			season = "겨울"; 
			
			System.out.print("온도를 입력하세요: ");
			int temp = sc.nextInt();
			
			if (temp <= -15 ) {	
				season += " 한파 경보";
				} else if (temp > -15 && temp <= -12) {
				season += " 한파 주의보";
				}
			
			} else if(month >= 3 && month <= 5) { 
			season = "봄";
			
			} else if(month >= 6 && month <= 8) {
				season = "여름";
				
				System.out.print("온도를 입력하세요: ");
				int temp = sc.nextInt();
				
				if (temp >= 35) {	
					season += " 폭염 경보";
					} else if (temp < 35 && temp >= 33) {
					season += " 폭염 주의보";
					}
				
			} else if(month >= 9 && month <= 11) {
				season = "가을";
				
			} else { 
				season = "해당하는 계절이 없습니다"; 
				}
			System.out.println(season);
	}
	public void ex5() {
		// 나이를 입력 받아
		// 13세 이하면 "어린이입니다."
		// 13세 초과 19세 이하면 "청소년입니다."
		// 19세 초과 시 "성인입니다. 출력
		
		System.out.print("나이를 입력하시오: ");
			int age = sc.nextInt();
			String result; // 결과값을 받을 변수 선언
			
		if (age <= 13) {
			result = "어린이입니다.";
			
		} else if (age > 13 && age <= 19) {
			result = "청소년입니다.";
			
		} else  {
			result = "성인입니다.";
		}
		
		System.out.println(result);
		
	}
	public void ex6() {
		// 점수 (100점 만점)을 입력받아
		// 90점 이상 A
		// 80점 이상 90점 미만 B
		// 70점 이상 80점 미만 C
		// 60점 이상 70점 미만 D
		// 60점 미만 F
		// 0점 미만 100점 초과: "잘못 입력하셨습니다" 출력
		
		// [실행화면]
		// 점수 입력: 60
		// D
		
		System.out.print("점수 입력: ");
			int score = sc.nextInt();
			String result;
			
			/* if(score >= 90 && score <= 100) {
				result = "A";
			} else if(score >= 80 && score < 90 ) {
				result = "B";
			} else if(score >= 70 && score < 80 ) {
				result = "C";
			}	else if(score >= 60 && score < 70 ) {
				result = "D";
			}	else if(score < 60 && score >= 0 ) {
				result = "F";
			}	else  {
				result = "잘못 입력하셨습니다.";
			} */
				
			 // 범위를 먼저 정해주면 훨씬 편함!
				if (score  < 0 || score > 100 ) { // 범위에서 벗어난 경우
					result = "잘못 입력하셨습니다.";
				} else if(score >= 90 ) {
					result = "A";
				} else if(score >= 80 ) {
					result = "B";
				} else if(score >= 70 ) {
					result = "C";
				} else if(score >= 60 ) {
					result = "D";
				} else  {
					result = "F";
				}
					System.out.println(result);
	}
	public void ex7() {
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		String result;
		
		if(age < 0 || age > 100) {
			result = "잘못 입력하셨습니다.";
		} else if (age >= 12) { 
			System.out.print("키 입력: ");
			double height = sc.nextDouble();
			if (height < 140.0) {
				result = "적정 키가 아닙니다.";
			} else {
				result = "탑승 가능";
			}
			} else {
			System.out.print("키 입력: ");
			sc.nextDouble();
			result = "적정 연령이 아닙니다.";
		}
			System.out.println(result);
	}
	public void ex8() {
		
		// 쌤 풀이
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result; // 결과 저장용 변수 선언
		
		if(age < 0 || age > 100) {
			result = "나이를 잘못 입력하셨습니다";
		} else { // 나이를 0~100 범위로 잘 입력한 경우
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			if( height < 0 || height > 250 ) {
				result = "키를 잘못 입력하셨습니다";
			} else { // 키를 0 ~ 250 사이 정상범주로 입력한 경우
				if( age < 12 && height >= 140.0 ) {// 나이 X, 키 O
					result = "키는 적절하나, 나이가 적절치 않음";
				} else if( age >= 12 && height < 140.0 ) { // 나이 O, 키 X
					result = "나이는 적절하나, 키가 적절치 않음";
				} else if( age < 12 && height < 140.0 ) { // 둘다 X
					result = "나이와 키 모두 적절치 않음";
				} else { // 둘다 OK
					result = "탑승 가능!!!";
					}
				}	
			}
				System.out.println(result);
	
		/* 내 풀이
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		String result;
		
		if(age < 0 || age > 100) {
			result = "나이를 잘못 입력하셨습니다.";
		
		} else if (age >= 12) { 
			System.out.print("키 입력: ");
			double height = sc.nextDouble();
			if (height > 250.0 || height < 0) {
				result = "키를 잘못 입력하셨습니다.";
			} else if (height >= 140.0) {
				result = "탑승 가능!!!";
			} else {
				result = "나이는 적절하나, 키는 적절치 않음";
				} 
		
		} else { 
			System.out.print("키 입력: ");
			double height = sc.nextDouble();
			if (height > 250 || height < 0) {
			result = "키를 잘못 입력하셨습니다.";
			} else if(height >= 140.0) { 
				result = "키는 적절하나, 나이가 적절치 않음";
			} else {
				result = "나이와 키 모두 적절치 않음";
			}
	}
			System.out.println(result); 
			*/
	}	
	
	public void ex9() {
		// switch 문: 여러 case 중 하나를 선택하여 수행하는 조건문

		
		// 요일 번호 입력 (1 ~ 7) : 3
		// 수요일
		
		System.out.print("요일 번호 입력(1 ~ 7): ");
		int day = sc.nextInt();
		String result;
		
		switch (day) {
		case 1 :
			result = "월요일"; break;
		case 2 :
			result = "화요일"; break;
		case 3 :
			result = "수요일"; break;
		case 4 :
			result = "목요일"; break;
		case 5 :
			result = "금요일"; break;
		case 6 :
			result = "토요일"; break;
		case 7 :
			result = "일요일"; break;
		default :
			result = "1 ~ 7 사이의 숫자로 다시 입력해주세요."; 
		}
			System.out.println(result);
	}
	public void ex10() {
		// 0 ~ 100 사이의 점수를 입력 받아 
		// 10으로 나눈 몫이 10,9라면 A
		// 8이면 B, 7이면 C, 6이면, D, 그 외(5~0) F 출력
		
		System.out.print("점수 입력(0 ~ 100): ");
		int score = sc.nextInt();
		String result;
		
		switch (score / 10) {
		case 10, 9 : 
			result = "학점 A"; break; // == case 10 : case 9 : result = "학점 A"; break;
		case 8 : 
			result = "학점 B"; break;
		case 7 : 
			result = "학점 C"; break;
		case 6 : 
			result = "학점 D"; break;
		case 5,4,3,2,1,0 : 
			result = "학점 F"; break;
		default : 
			result = "잘못된 점수";
		}
		System.out.println(result);
		
	}
}

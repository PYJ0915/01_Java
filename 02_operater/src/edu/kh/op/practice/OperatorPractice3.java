package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice3 {

	Scanner sc = new Scanner(System.in);
	
	public void practice5 () {
		
		System.out.print("가격을 입력하세요: ");
		int price = sc.nextInt();
		
		System.out.print("멤버쉽 있으세요? (있으면 true / 없으면 false) ");
		boolean member = sc.nextBoolean();
		
		double discount = member ? price*0.10 : price*0.05; 
		String discountPercent = member ? "10%" : "5%"; 
		double total = price - discount;
		
		
		System.out.println("할인율: " + discountPercent);
		System.out.println("할인 가격: " + discount + "원");
		System.out.printf("할인을 포함한 최종 금액: %.1f원", total);
		
		
		
	}
	
	public void practice6 () {
		
		/* 다른 풀이
		
		System.out.print("출금할 금액 입력: ");
		int money = sc.nextInt();
		
		System.out.printf("50000원: %d\n10000원: %d\n5000원: %d\n1000원: %d\n500원: %d\n100원: %d",
							money / 50000, money % 50000 / 10000, money % 50000 % 10000 / 5000, money % 50000 % 10000 % 5000 / 1000, 
							money % 50000 % 10000 % 5000 % 1000 / 500, money % 50000 % 10000 % 5000 % 1000 % 500 / 100); 
		*/
		
			System.out.print("출금할 금액 입력: ");
			int money = sc.nextInt();
			
			int fifty = money / 50000; // 5만원 지폐 개수
			money %= 50000; // == money = money % 50000 (복합 대입 연산자) 
			int tenth = money / 10000; // 만원 지폐 개수
			money %= 10000;
			int fifth = money / 5000; // 5천원 지폐 개수
			money %= 5000;
			int first = money / 1000; // 천원 지폐 개수
		 	System.out.printf("50000원: %d\n10000원: %d\n5000원: %d\n1000원: %d\n",
		 								fifty, 		tenth,		fifth,		first);
		  
		  
		 
		
	}
	
	public void practice7() {
		
		System.out.print("첫 번째 수: ");
		int intNumber1 = sc.nextInt();
		
		System.out.print("두 번째 수: ");
		int intNumber2 = sc.nextInt();
		
		// 첫 번째 수가 두 번 째 수의 배수인지
		// == 첫 번째 수가 두 번째 수로 나누어 떨어진다.
		// == 첫 번째 수를 두 번째 수로 나누었을 때 나머지가 0이다
		
		String result = (intNumber1 % intNumber2 == 0) ? "배수입니다" : "배수가 아닙니다";
		
		System.out.println(result);
		
	}

}

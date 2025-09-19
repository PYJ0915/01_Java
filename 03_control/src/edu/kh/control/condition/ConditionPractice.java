package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionPractice {

	Scanner sc = new Scanner(System.in);
	
	public void ex() {
		
		System.out.print("달을 입력하세요: ");
		int month = sc.nextInt();
		String season;
		
			if(month == 1 || month == 2 || month ==12) {
				season = "겨울";
			
			System.out.print("온도를 입력하세요: ");
			int temp = sc.nextInt();
			
			if(temp < 0 && temp >= -5) {
				season += " 추위 주의";
				}
			} else if(month >= 3 && month <= 5) {
				season = "봄";
			} else if (month >= 6 && month <= 8) {
				season = "여름";
				
			System.out.print("온도를 입력하세요: ");
			int temp = sc.nextInt();
				
			if(temp >= 30 && temp < 33) {
				season += " 더위 주의";
				}
			} else if(month >= 9 && month <= 11) {
				season = "가을";
			} else {
				season = "해당하는 계절이 없습니다.";
			}
			System.out.println(season);
	}

}

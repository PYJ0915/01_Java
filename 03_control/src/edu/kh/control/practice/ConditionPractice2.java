package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	Scanner sc = new Scanner(System.in); // 필드

	// 코드 자동 정렬 = ctrl + shift + f
	public void practice1() {

		System.out.print("숫자 한 개를 입력하세요: ");
		int num = sc.nextInt();

		String result; // 결과값(문자열)을 저장할 수 있는 변수 선언

		if (num <= 0) {
			result = "양수만 입력해주세요.";
		} else if (num % 2 == 0) {
			result = "짝수입니다.";
		} else {
			result = "홀수 입니다.";
		}

		System.out.println(result);
	}

	public void practice2() {

		System.out.print("국어 점수: ");
		int korScore = sc.nextInt();
		System.out.print("영어 점수: ");
		int engScore = sc.nextInt();
		System.out.print("수학 점수: ");
		int mathScore = sc.nextInt();
		int sum = (korScore + engScore + mathScore);
		double avg = sum / 3.0;

		String result;

		if (korScore >= 40 && engScore >= 40 && mathScore >= 40 && avg >= 60) {
			System.out.println("국어: " + korScore);
			System.out.println("영어: " + engScore);
			System.out.println("수학: " + mathScore);
			System.out.println("합계: " + sum);
			System.out.printf("평균: %.1f\n ", avg);
			result = "축하합니다, 합격입니다!!";
		} else {
			System.out.println("국어: " + korScore);
			System.out.println("영어: " + engScore);
			System.out.println("수학: " + mathScore);
			result = "불합격입니다.";
		}
		System.out.println(result);

	}

	public void practice3() {

		System.out.print("1 ~ 12 사이의 정수 입력: ");
		int month = sc.nextInt();

		String result;

		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			result = month + "월은 31일까지 있습니다.";
			break;
		case 2:
			result = month + "월은 28일까지 있습니다.";
			break;
		case 4, 6, 9, 11:
			result = month + "월은 30일까지 있습니다.";
			break;
		default:
			result = month + "월은 잘못 입력된 달입니다.";
		}
		System.out.println(result);
	}

	public void practice4() {

		System.out.print("키(m)를 입력해 주세요: ");
		double height = sc.nextDouble();

		System.out.print("몸무게(kg)을 입력해 주세요: ");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);
		System.out.println("BMI 지수: " + bmi);

		String result;

		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 23) {
			result = "정상체중";
		} else if (bmi < 30) {
			result = "비만";
		} else {
			result = "고도 비만";
		}
		System.out.println(result);
	}

	public void practice5() {

		System.out.print("중간 고사 점수: ");
		double score1 = sc.nextDouble();
		double mid = (score1 * 0.2);
		
		System.out.print("기말 고사 점수: ");
		double score2 = sc.nextDouble();
		double fin = (score2 * 0.3);
		
		System.out.print("과제 점수: ");
		double score3 = sc.nextDouble();
		double hw = (score3 * 0.3);
		
		System.out.print("출석 횟수: ");
		double times = sc.nextDouble();

		double total = mid + fin + hw + times;

		System.out.println("================= 결과=================");

		if (times > 14) {
			System.out.printf("중간 고사 점수 (20) : %.1f\n기말 고사 점수 (30) : %.1f\n과제 점수 (30) : %.1f\n출석 점수 (20) : %.1f\n총점: %.1f\n", 
								mid, fin, hw, times, total);
			if (total >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [점수 미달]");
			}
		} else {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", (int)times);
		}
	}
}

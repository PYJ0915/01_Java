package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
	
	 public void practice1 ( ) {
		
		
		
		System.out.print("인원 수: ");
		int pNum = sc.nextInt();
		
		System.out.print("사탕 개수: ");
		int cNum = sc.nextInt();
		
		System.out.printf("\n1인당 사탕 개수: %d\n남는 사탕 개수: %d", cNum/pNum, cNum%pNum);
		
	} 
	
	 
	 
	 
	 
	  public void practice2( ) {
		
		
		
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		System.out.print("학년: ");
		int grade = sc.nextInt();
		
		System.out.print("반: ");
		int studentClass = sc.nextInt();
		
		System.out.print("번호: ");
		int studentID = sc.nextInt();
		
		sc.nextLine(); // 개행문자 제거용(입력 버퍼에 남은 개행문자 비우기)
		
		System.out.print("성별(남학생/여학생): ");
		String gender = sc.nextLine();
		
		System.out.print("성적: ");
		double score = sc.nextDouble();
		
		System.out.printf( "\n%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", 
				           grade, studentClass, studentID, name, gender, score);
		
	} 
	
	  public void practice3() {
		
		
		
		System.out.print("국어: ");
		int kor = sc.nextInt();
		
		System.out.print("영어: ");
		int eng = sc.nextInt();
		
		System.out.print("수학: ");
		int math = sc.nextInt();
		
		 double avg = (kor + eng + math)/3.0;
		
		System.out.printf("\n합계: %d\n", kor + eng + math);
		System.out.printf("평균: %.1f\n", avg);
		
		// 각 과목이 40점 이상이고, 평균 60점 이상이어야 합격, 그 외 불합격
		
		boolean result = (kor >=  40) && (eng >= 40) && (math >= 40) && (avg >= 60);
		
		System.out.println(result ? "합격" : "불합격");
		
		
		
	}

}

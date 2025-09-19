package edu.kh.control.practice;

import java.util.Scanner;

public class ControlPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1 ( ) {
		
		System.out.print("중간 고사 점수 : ");
		int midScore = sc.nextInt();
		double midScoreP = midScore * 0.2;
		
		System.out.print("기말 고사 점수 : ");
		int finScore = sc.nextInt();
		double finScoreP = finScore * 0.3;
		
		System.out.print("과제 점수 : ");
		int hwScore = sc.nextInt();
		double hwScoreP = hwScore * 0.3;
		
		System.out.print("출석 횟수 : ");
		int att = sc.nextInt();
		double attP = att * 1.0;
		
		double total = (midScoreP + finScoreP + hwScoreP + attP);
		
		if (att < 15) { // 결석 탈락
			System.out.printf("Fail [출석횟수부족(%d/20)]", att);
		} else { // 출석횟수 O
			System.out.printf("중간고사점수(20) : %.1f\r\n기말고사점수(30) : %.1f\r\n과제점수(30) : %.1f\r\n출석점수(20) : %.1f\r\n총점: %.1f\n", 
												midScoreP, finScoreP, hwScoreP, attP, total);
			if(total >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [점수 미달]");
			}
		}
		
	}
	
	public void RSPGame2() {
		// 가위바위보 게임
		// 몇 판할지 입력 받고 입력받은 판 수만큼 반복
		
		/* 컴퓨터: Math.random() : 0.0 ~ 1.0 사이 난수 생성
		   1 ~ 3 사이의 난수 생성
		   1이면 가위, 2이면 바위, 3이면 보 지정
		   컴퓨터와 플레이어 가위바위보 판별
		   플레이어 승! / 졌습니다 ㅠㅠ / 비겼습니다
		   매 판마다 - 현재기록 : 2승 1무 0패 출력 */
		
		System.out.println("[가위바위보 게임~!]");
		System.out.print("몇 판? ");
		int input = sc.nextInt();
		
		int win = 0;
		int draw = 0;
		int lose = 0;
		
		
		for(int i = 1; i <= input; i++) {
			
			System.out.println("\n" + i + "번째 게임");
			System.out.print("가위/바위/보 중 하나 입력: ");
			String player = sc.next();
			
			int random = (int)(Math.random() * 3 + 1);
			
			String com = null;
			
			switch(random) {
			case 1: 
				com = "가위";
				break;
			case 2: 
				com = "바위";
				break;
			case 3: 
				com = "보";
				break;
			}
			
				if(player.equals(com)) {
					System.out.println("비겼습니다");
					draw++;
				}else {
					boolean win1 = player.equals("가위") && com.equals("보");
					boolean win2 = player.equals("바위") && com.equals("가위");
					boolean win3 = player.equals("보") && com.equals("바위");
					
					if(win1 || win2 || win3) {
						System.out.println("플레이어 승!!");
						win++;
					} else {
						System.out.println("졌습니다 ㅜㅜ");
						lose++;
					}
					
			}
				System.out.printf("현재 기록: %d승 %d무 %d패\n", win, draw, lose);
				
		}
		
		
	}
}

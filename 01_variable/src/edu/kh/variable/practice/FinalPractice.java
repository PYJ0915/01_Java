package edu.kh.variable.practice;

public class FinalPractice {

	public static void main(String[] args) {
		
		int age = 24;
			System.out.println("나는 " + age + "살입니다.");
		
		int score = 90;
			System.out.println("최종점수:"+ (score+=10));
			
		/* 먼저 10을 더해주는 방식
		 * score = score +10;
			score += 10
			*/
		
		int a = 10;
		double b = a;
			System.out.println(a);
			System.out.println(b);
			
		double pi = 3.14159;
			System.out.printf("%d , %.2f\n" , (int)pi, pi ); 
			
		char ch = 'A';
			System.out.println("문자: " + ch + " 코드 값: " + (int)ch );
			
		// int code = ch; 를 통해 A의 코드값을 따로 변수 설정 해도 O (자동 형변환)
			
	final int PRICE = 5000;
	      int count = 3;
	   // int total = PRICE * count
	      	System.out.printf("물건가격 : %d원, 개수 %d개, 총액 %d원\n", PRICE, count, PRICE*count );
	      																				//total
	     int koreanScore = 95;
	     int engScore = 87;
	     int mathScore = 90;
	     int sum = koreanScore + engScore + mathScore;
	     double average = ((double)sum)/3; // == sum/3.0 (자동 형변환)
	     	System.out.println(koreanScore);
	     	System.out.println(engScore);
	     	System.out.println(mathScore);
	     	System.out.println(sum);
	     	System.out.println(average);
	     	System.out.printf("국어: %d, 영어: %d, 수학: %d\n총점: %d, 평균: %.2f\n", koreanScore, engScore,
	     			mathScore, sum, average);
	     
	    String name = "영숙";
	    int age2 = 28;
	    double height = 165.7;
	    	System.out.printf("출연자 이름: %s\n나이: %d세\n키: %.1fcm\n", name, age2, height );
	    	
	    double age3 = age2;
	    	System.out.println("자동 형변환된 나이: " + age3);
	    	System.out.println("강제 형변환된 키: " + (int)height );
	    	
	    int score1 = 87;
	    int score2 = 92;
	    double avgScore = ((double)score1 + score2)/2;  // == (score + score2)/2.0 (자동 형변환)
	    	System.out.println("영숙님의 매칭 점수 평균은 " + avgScore + "점입니다!");
	 
		int age4 = 24;
		int score3 = 80;
			System.out.println("나는 " + (age4+=1) +"살입니다." + " 최종 점수: " + (score3+=15) );
			
			double pi2 = 3.14159265359;
			int pi3 = (int)pi2;
			char ch2 = 'B';
				System.out.printf("문자: %c, 코드값: %d, 원주율: %.2f, 변환된 원주율: %d\n", ch2, (int)ch2, pi2, pi3 );
			
		}
	}


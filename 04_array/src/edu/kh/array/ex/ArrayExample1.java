package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

	/* 배열(Array): 같은 자료형의 변수를 하나의 묶음으로 다루는 것 
 		- 묶여진 변수들은 하나의 배열명으로 불려지고 구분은 index 를 이용함(index 는 0부터 시작하는 정수)
 	
	 * 배열의 선언: 메모리(stack)에 배열을 참조할 수 있는 변수 공간을 만드는 것
	 * 배열의 할당: 실제값을 저장할 수 있는 배열을 메모리(heap)에 생성
    	ex. int[] arr = new int[5]; // int arr [] = new int[5];
      	 // 배열 선언   배열 할당      배열 선언    배열 할당
    		-> 배열(arr) 저장 공간을 5칸 만들었다.
 		
 			arr[0] = 1; arr [3] = 4; 
 			-> 1호실(인덱스 번호는 0부터 시작)과 4호실에 정수 1과 4를 담았다.
 		
 	 * 배열의 특징
       - 한 가지 자료형만 저장 가능하다
       - 여러 값을 저장할 수 있다
       - 한 번 크기를 지정하면 변경 불가능하다 
*/

public class ArrayExample1 { 
	
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		// 변수 vs 배열
		
		/* 
		 
		 - 변수 선언
		    int num; // stack 영역에 int 자료형을 저장할 수 있는 공간 4byte를 할당하고 그 공간에 num 이라는 이름을 부여
	  
		 - 변수 대입
			num = 10; // 생성된 num 이라는 변수 공간에 10이라는 정수값 대입 
		
		 - 변수 사용
		   System.out.println("num에 저장된 값 : " + num);
		   
		 */
		
		// ----------------------------------------------------------------------------
		
		/* 
		 
		 - 배열 선언
		   int arr[]; == int[] arr; // stack 영역에 int[] 자료형 공간을 4byte 할당하고 그 공간에 arr 이라는 이름 부여 
		  -> 해당 변수는 참조형으로 주소값만을 저장할 수 있다.
		 
		 - 배열 할당
		   arr = new int[3]; 
		 
		 - new : "new 연산자" 라고하며 Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당
		 - int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		 - new int[3] : Heap 영역에 int형 변수 3칸짜리 int[]를 생성(할당)
		 
		 * Heap 영역에 할당된 공간은 !절대! 비어있을 수 없다 -> 최초 할당 시 JVM 기본값이 자동 저장됨
		 * JVM 기본값: boolean 은 false 참조형은 null 나머지는 다 0이라고 생각 
		 
		 - 배열 요소 값 대입
		   arr[0] = 10;
		   arr[1] = 50;
		   arr[2] = 100;
		 
		 */
		
		
		int arr [];
		arr = new int[3];
		System.out.println("arr : " + arr); // 주소값 출력
		
		System.out.println( arr[0] );
		System.out.println( arr[1] );
		System.out.println( arr[2] );
		/* Heap 영역에 생성된 공간은 절대 비어있을 수 없기 때문에 JVM 기본 값이 들어가져 있음
		   boolean : false
		   참조형 : null   
		   나머지 : 0   */
		
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 100;
	 // arr[3] = 500; // 런타임 에러 발생! 
	 // java.lang.ArrayIndexOutOfBoundsException: -> 배열의 인덱스 범위를 벗어남
	 // Index 3 out of bounds for length 3 -> 길이를 3칸 짜리로 만든 배열인데, 없는 인덱스 번호인 3에 접근했다
		
		// 이클립스에서 빨간 줄로 나오는 에러 : 컴파일 에러
		// 실행화면에서 나오는 에러 : 런타임 에러
		
		System.out.println( arr[0] );
		System.out.println( arr[1] );
		System.out.println( arr[2] );
		
		// [10, 50, 100] 출력하고 싶을 때 (배열이 가진 모든 요소의 값을 알고 싶을 때)
		// System.out.println( Arrays.toString(배열명) ); -> String 형
		
		Arrays.toString(arr); // "[10, 50, 100]"이 둥둥 떠다님
		System.out.println( Arrays.toString(arr) );
		
		
	}
	
	public void ex2() {
		
		// 배열의 선언 및 할당
		 int arr[] = new int[4];
		
		// arr[0~3] 전부 JVM에 의해 0으로 초기화 되어있는 상태
		 
		 arr[0] = 100;
		 arr[1] = 200;
		 arr[2] = 300;
		 arr[3] = 400;
		 
		 // 배열의 길이 (몇 칸 인가): 배열명.length
		 System.out.println( "배열의 길이: " + arr.length ); 
		 
		 // 배열과 for 문
		 for( int i = 0; i < arr.length; i++ ) {
			 
			 arr[i] = i * 100; // for 문을 이용한 초기화 방법
			 System.out.printf("arr[%d]에 저장된 값: %d\n", i, arr[i]); // for 문을 이용한 배열의 요소 출력 방법
			 
		 }
		 
		 // 선언과 동시에 초기화
		 int[] arr2 = {1, 2, 3, 4, 5};
		 // stack 영역에 int[] 자료형 공간을 4byte 할당하고 그 공간에 arr2라는 이름 부여
		 // Heap 영역에 int 5칸짜리 배열을 생성하고 0번 인덱스부터 1 ~ 5까지 정수값을 대입
		 // int[] 주소값을 arr2 참조 변수가 참조함.
		 System.out.println( Arrays.toString(arr2) );
		 
		 
	}
	
	public void ex3() {
		// 5명의 키(cm)를 입력받고 평균 구하기
		
		// 1번 키 입력 : 170.5
		// 2번 키 입력 : 163.7
		// ..
		// 5번 키 입력 : 167.2
		// 평균 : 177.02cm
		
		double[] height = new double[5];
		double sum = 0; // 합계 누적할 변수
		
		/* 
		System.out.print("1번 키 입력 : ");
		height[0] = sc.nextDouble();
		System.out.print("2번 키 입력 : ");
		height[1] = sc.nextDouble();
		System.out.print("3번 키 입력 : ");
		height[2] = sc.nextDouble();
		System.out.print("4번 키 입력 : ");
		height[3] = sc.nextDouble();
		System.out.print("5번 키 입력 : ");
		height[4] = sc.nextDouble();
		*/
		
		// 위의 식을 for 문으로 표현
		for(int i = 0; i < height.length; i++) {
			
			System.out.print( (i + 1) + "번 키 입력 : ");
			height[i] = sc.nextDouble();
			sum += height[i]; // sum = sum + height[0];
		}
		
		double avg = sum / height.length;
		System.out.printf("\n평균: %.2fcm", avg);
		
	}
	
	public void ex4() {
		// 입력 받은 인원 수 만큼의 점수를 입력 받아 배열에 저장
		// 입력이 완료되면 점수 합계, 평균 출력
		
		// ex) 입력 받을 인원 수 : 4
		// 1번 점수 입력 : 100
		// 2번 점수 입력 : 80
		// ... 
		// 4번 점수 입력 : 90
		
		// 합계 : 290
		// 평균 : 72.5
		
		System.out.print("입력 받을 인원수 : ");
		int input = sc.nextInt();
		int score[] = new int[input];
		
		int sum = 0;
		
		for (int i = 0; i < score.length; i++) {
			
			System.out.print( (i + 1) + "번 점수 입력 : ");
			score[i] = sc.nextInt();
			sum += score[i];
			
		}
		
		double avg = sum / (double) score.length;
		System.out.printf("\n합계: %d점\n평균: %.2f점\n", sum, avg);
	}
	
	public void ex5() {
		// 점심 메뉴 뽑기 프로그램
		
		String[] arr = {"김밥", "서브웨이", "햄버거", "짜장면", "백반", "국밥"};
		
		System.out.println("오늘 점심 메뉴 : " + arr[(int)(Math.random() * 6)]);
		// Math.random() : 0.0 ~ 1.0
		// 0.0 <= X < 1.0
		// 0.0 <= 6X < 6.0
		// 0 <= (int)6X < 6 
		// 0, 1, 2, 3, 4, 5
		
	}
	
	public void ex6() {
		// 배열을 이용한 검색
		
		// 입력 받은 정수가 배열에 있는지 없는지 확인
		// 만약 있다면 몇 번 인덱스에 존재하는지 출력
		
		// ex) 정수 입력 : 200
		// 1번 인덱스에 존재합니다.
		
		// 정수 입력 : 5
		// 존재 하지 않습니다.
		
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
		// 찾음 여부를 표시하기 위한 (신호를 나타내기 위한) 변수
		boolean flag = false; // 검사 전에는 찾지 못했다고 가정
		
		
		for(int i = 0; i < arr.length; i++) {
			
			if(input == arr[i]) {
				System.out.println(i + "번 째 인덱스에 존재합니다.");
				flag = true; // 일치하는 값을 찾았으므로 true 로 변경
				
			} 
		}
		
		if( !flag ) {
			System.out.println("존재하지 않습니다.");
		}
		
	}
	
	public void ex7() {
		// 입력 받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		// 없으면 존재하지 않음 출력
		
		String[] arr = {"사과", "딸기", "바나나", "아보카도", "키위" , "멜론"};
		
		System.out.print("과일 입력: ");
		String input = sc.next();
		
		boolean flag = true;
		
		for(int i = 0; i < arr.length; i++) {
			
			if( input.equals(arr[i]) ) {
				System.out.println(i + "번 째 인덱스에 존재합니다.");
				flag = false;
				
			}
		}
		if( flag ) {
			System.out.println("존재하지 않습니다.");
		}
	}
	
	public void ex8() {
		//ex.
		// 문자열 입력 : hello
		// [h, e, l, l, o]
		// 검색할 문자 입력 : l
		// 2개 있음
		// 검색할 문자 입력 : u
		// 존재하지 않습니다.
		
		// 1. 문자열을 입력받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		// 2. 문자 하나를 입력 받아 일치하는 문자가 char 배열에 몇 개 존재하는지 확인
		// 3. 단, 일치하는 문자가 없을 경우에는 존재하지 않습니다 출력.
		
		// 사용해야하는 기능
		// 1) 배열 검색
		// 2) 문자열의 길이 구하기 : String.length() ex) "hello".length() -> 5 반환
		// 3) String.charAt(index) : 문자열에서 특정 index 에 위치한 문자 하나를 얻어옴.
		//   ex) "hello".charAt(1) -> 'e' 반환
		//        01234
		// 4) count (숫자세기)
		
		System.out.print("문자열 입력: ");
		String input = sc.nextLine();
		
		// 1. 문자열을 입력받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		// 1-1) 입력받은 문자열 길이만큼의 char 배열 선언 및 할당하기
		char arr [] = new char[input.length()];
		
		// 1-2) 입력한 문자열을 한 글자씩 잘라내어 char 배열의 모든 요소에 값 대입
		for(int i=0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		//  arr[0] = 'h'
		//  arr[1] = 'e'
		//  arr[2] = 'l'
		//  arr[3] = 'l'
		//  arr[4] = 'o'
		}
		
		System.out.println( Arrays.toString(arr) );		
		
		// 2. 문자 하나 입력 받아 일치하는 문자가 몇개 존재하는지 확인
		
		// 2-1) 문자를 하나 입력 받는다
		System.out.print("검색할 문자 입력: ");
		char ch = sc.next().charAt(0);
		// String.charAt(index) -> 문자형 ' '
		// "e".charAt(0); -> 'e'
		// -> 스캐너에는 char 형태를 입력받을 수 있는 메서드가 없다.
		// -> String 으로 우선 입력 받고 입력 받은 String 에서 charAt(index) 메서드를 이용하여
		// 	  해당 index 번째 존재하는 문자 하나를 떼어 char 자료형 형태로 반환함.
		
		int count = 0; // 내가 찾는 글자 개수를 세기 위한 변수
		
		// 2-2) 일치하는 문자가 몇개 존재하는지 확인
		// arr이라는 배열에 입력한 문자가 몇 개 존재하는지 0번 index 부터 마지막 index 까지 순회하며 검색하기 위함
		for(int i = 0; i < arr.length; i++) {
			if(ch == arr[i]) {
				count++; // arr[i] 값과 ch 값이 같은 경우 카운트를 늘려라
			}
		} 
		if (count != 0) {// 일치하는 값 있을 때
			System.out.printf("%d개 있습니다.", count);
		} else { // 일치하는 문자가 없는 경우
			// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다."을 출력하라.
			System.out.println("존재하지 않습니다.");
		}
	}
	
}

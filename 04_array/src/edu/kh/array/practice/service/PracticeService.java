package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

	/*
	길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후 
	짝수번째 인덱스 값의 합을 출력하세요.(0 번째 인덱스는 짝수로 취급)
	*/
		
		int arr[] = new int[9];

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1);
			if (i % 2 == 0) {
				sum += i + 1;
			}
		}

		System.out.println(Arrays.toString(arr));
		System.out.println("짝수 번째 인덱스 합: " + sum);
	}

	public void practice2() {

	/*
	 길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
	 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
	 홀수 번째 인덱스값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
    */
		
		int arr[] = new int[9];

		int sum = 0;

		for (int i = arr.length; i > 0; i--) {
			arr[arr.length - i] = i;
			if ((arr.length - i) % 2 != 0) {
				sum += i;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("홀수 번째 인덱스 합: " + sum);
	}

	public void practice3() {
		
	/*
	 사용자에게 입력받은 양의정수만큼 배열크기를 할당하고
	 1부터 입력받은 값까지 배열에 초기화한 후 출력하세요
	 */
		
		int input = sc.nextInt();
		int arr[] = new int[input];

		for (int i = 0; i < input; i++) {
			arr[i] = (i + 1);
		}
		System.out.println(Arrays.toString(arr));
	}

	public void practice4() { 
		
		/*
		 정수 5개를 입력받아 배열을 초기화하고
		 검색할 정수를 하나 입력받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
		 배열에 같은 수가 없을경우 "일치하는 값이 존재하지않습니다" 출력
		 */
		

		int arr[] = new int[5];
		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {

			System.out.print("입력 " + i + ": ");
			arr[i] = sc.nextInt();
		}

		System.out.print("검색할 값: ");
		int input = sc.nextInt();

		for (int x = 0; x < arr.length; x++) {
			if (input == arr[x]) {
				System.out.println("인덱스: " + x);
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}

	}

	public void practice5() {
		
	/*
	 문자열을 입력 받아 문자 하나 하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가있는지
	 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요
	 */
		
		// 1. 문자열을 입력 받아 문자 하나 하나를 배열에 넣어라
		// 2. 검색할 문자가 문자열에 몇개 들어가있는지 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하라
		
		int count = 0; // 일치하는 문자 셀 개수
		
		
		// 문자열 입력 받음
		System.out.print("문자열: ");
		String input = sc.next(); 
		
		char arr[] = new char[input.length()]; // 입력 받은 문자열을 넣을 배열
		
		System.out.print("문자: ");
		char ch = sc.next().charAt(0); // 검색할 문자 입력받음
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = input.charAt(i); // 문자열을 문자로 잘라서 배열에 넣기
			
			if(arr[i] == ch) { // 개수 세기
				count++;
				
			} 
		}
		
		int result [] = new int [count];
		int num = 0;
		
		for(int x = 0; x < arr.length; x++) {
			if(arr[x] == ch) {	
			 result[num] = x;
			 num++;
			}
		}
		
		System.out.println(input + "에 " + ch + "가 존재하는 위치(인덱스): " + Arrays.toString(result));
		
	
	}

	public void practice6() {

	}

	public void practice7() {

	}

	public void practice8() {

	}

	public void practice9() {

	}

	public void practice10() {

	}

	public void practice11() {

	}

	public void practice12() {

	}

	public void practice13() {

	}

	public void practice14() {

	}

}

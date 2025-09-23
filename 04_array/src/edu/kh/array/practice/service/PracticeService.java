package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		/*
		 * 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		 * 짝수번째 인덱스 값의 합을 출력하세요.(0 번째 인덱스는 짝수로 취급)
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
		 * 길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후 홀수
		 * 번째 인덱스값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
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
		 * 사용자에게 입력받은 양의정수만큼 배열크기를 할당하고 1부터 입력받은 값까지 배열에 초기화한 후 출력하세요
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
		 * 정수 5개를 입력받아 배열을 초기화하고 검색할 정수를 하나 입력받아 배열에서 같은 수가 있는 인덱스를 찾아 출력. 배열에 같은 수가
		 * 없을경우 "일치하는 값이 존재하지않습니다" 출력
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
		 * 문자열을 입력 받아 문자 하나 하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가있는지 개수와 몇 번째 인덱스에 위치하는지 인덱스를
		 * 출력하세요
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

		for (int i = 0; i < arr.length; i++) {

			arr[i] = input.charAt(i); // 문자열을 문자로 잘라서 배열에 넣기

			if (arr[i] == ch) { // 개수 세기
				count++;

			}
		}

		int result[] = new int[count];
		int num = 0;

		for (int x = 0; x < arr.length; x++) {
			if (arr[x] == ch) {
				result[num] = x;
				num++;
			}
		}

		System.out.print(input + "에 " + ch + "가 존재하는 위치(인덱스): ");

		for (int x = 0; x < count; x++) {

			System.out.print(result[x] + " ");

		}

		System.out.println("\n" + ch + " 개수: " + count);

	}

	public void practice6() {

		/*
		 * 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고 / 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의
		 * 인덱스에 값을 초기화하세요. 그리고 배열 전체값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요
		 */

		int sum = 0; // 합계 저장할 변수

		// 1) 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int arr[] = new int[input];

		// 2) 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화하세요.
		for (int i = 0; i < input; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값: ");
			int num = sc.nextInt();
			arr[i] = num;
			sum += num;
		}

		// 3) 그리고 배열 전체값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.println("\n총합: " + sum);

	}

	public void practice7() {

		// 주민등록번호 번호를 입력받아 성별을 나타내는 숫자 이후부터 *로 가리고 출력하세요
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		
		char arr[] = new char[input.length()];
		
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = input.charAt(i);
			
			if (i > 7) {
				
				arr[i] = '*';
				
			}
			
		}
		for (int x = 0; x < arr.length; x++) {
			
			System.out.print(arr[x]);
			
		}
	}

	public void practice8() {
		/*
		 * 3 이상인 홀수를 입력받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고, 중간 이후부터 끝까지는 1씩 감소하여
		 * 내림차순으로 값을넣어 출력하세요. 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고 다시 정수를 받도록
		 * 하세요
		 */

		// 1) 3 이상인 홀수를 입력받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,

		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();

			if (input % 2 == 1 && input >= 3) {

				int arr[] = new int[input];

				for (int i = 0; i < arr.length; i++) {
					if ((input / 2) + 1 > (i + 1)) {
						arr[i] = i + 1;
					} else {
						arr[i] = arr.length - (i);
					}
				}
				for (int x = 0; x < arr.length; x++) {
					if (x == arr.length - 1) {
						System.out.print(arr[x]);
					} else {
						System.out.print(arr[x] + ", ");
					}
				}

				break;

			} else { // 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고 다시 정수를 받도록 하세요.
				System.out.println("다시 입력하세요.");
			}
		}
	}

	public void practice9() {
		/*
		 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고, 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		 */

		// 1) 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,

		int arr[] = new int[10];

		// 2) 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.

		for (int i = 0; i < arr.length; i++) {
			int random = (int) (Math.random() * 10 + 1); // 1~10 사이의 난수를 발생시켜
			arr[i] = random; // 배열에 초기화

		}

		System.out.print("발생한 난수: ");

		for (int i = 0; i < arr.length; i++) { // 출력하세요.

			System.out.print(arr[i] + " ");

		}

	}

	public void practice10() {

		int arr[] = new int[10]; // 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고

		for (int i = 0; i < arr.length; i++) { // 1~10 사이의 난수를 발생시켜 배열에 초기화 후

			int random = (int) (Math.random() * 10 + 1);

			arr[i] = random;

		}

		System.out.print("발생한 난수: ");

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}
		// 3) 배열 전체값과 그 값 중에서 최대값과 최소값을 출력하세요
		// 오름차순 정리 후 첫 배열과 마지막 배열 출력 

		Arrays.sort(arr); // 오름차순 정리

		System.out.println("\n최댓값: " + arr[arr.length - 1]);
		System.out.println("최솟값: " + arr[0]); 

	}

	public void practice11() {

		/*
		 * 10개의 값을 저장할 수 있는 정수형배열을 선언 및 할당하고 1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후
		 * 출력하세요
		 */
		int arr[] = new int[10]; // 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고

		for (int i = 0; i < arr.length; i++) {

			int random = (int) (Math.random() * 10 + 1);

			arr[i] = random;

			for (int x = 0; x < i; x++) {

				if (random == arr[x]) {
					i--;
					break;
				}

			}

		}
		for (int y = 0; y < arr.length; y++) {
			System.out.print(arr[y] + " ");
		}
	}

	public void practice12() {  // 3 16 25 35 40 41 
	
		/*
		 * 로또 번호 생성기 배열을 이용한 중복 데이터 제거 + 정렬  
		 * 1 ~ 45 사이 중복되지 않은 난수 6개 생성 
		 * 2. 생성된 난수를 오름차순으로 정렬
		 */

		int arr[] = new int[6];

		for (int i = 0; i < arr.length; i++) {

			int random = (int) (Math.random() * 45 + 1);

			arr[i] = random;

			for (int x = 0; x < i; x++) {

				if (arr[x] == random) {
					i--; // 다시 난수를 발생시켜 배열에 담기 위해서
					break;
				}
			}
		}

		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void practice13() {

		// 문자열을 입력받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고 문자의 개수와 함께 출력하세요.

		System.out.print("문자열: ");
		String input = sc.nextLine();

		int count = 0;

		char arr[] = new char[input.length()]; // 문자열 전체를 잘라서 담을 배열

		for (int i = 0; i < arr.length; i++) {

			arr[i] = input.charAt(i);

			for (int x = 0; x < i; x++) {

				if (arr[i] == arr[x]) {
					count++;
					break;
				}

			}

		}
		char arr2[] = new char[arr.length - count]; // 중복되는 문자를 뺀 문자열을 담을 배열

		int count2 = 0; // 배열 인덱스를 건너뛰는 것을 방지하는 변수

		for (int i = 0; i < arr.length; i++) { // 원래 문자열 길이 만큼 반복 why? 그래야 문자열 전체를 검색하며 중복될 때는 담지 않고 중복되지 않을 때만 담을 수 있다.

			boolean flag = true; // 중복이 발견 됐을 때 배열에 문자를 담지 않기 위한 표시

			for (int x = 0; x < i; x++) {

				if (arr[x] == arr[i]) {

					flag = false;
					count2++;
					break;
					
				}
			}

			if (flag) {
				arr2[i - count2] = input.charAt(i);
			}

		}

		System.out.print("문자열에 있는 문자: ");
		for (int i = 0; i < arr2.length; i++) {
			if (i == arr2.length - 1) {

				System.out.print(arr2[i]);

			} else {

				System.out.print(arr2[i] + ", ");

			}
		}
		System.out.println("\n문자 개수: " + arr2.length);
	}

	public void practice14() {

		/*
		 * 사용자가 입력한 배열의 길이 만큼의 문자열 배열을 선언 및 할당하고 배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화하세요. 단,
		 * 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할건지, 늘린 곳에 어떤 데이터를 넣을 것인지 받으세요. 사용자가 더 이상
		 * 입력하지 않겠다고 하면 배열 전체 값을 출력하세요
		 */
		
		// 1. 첫 배열의 크기 지정
		System.out.print("배열의 크기를 입력하세요: ");
		int size = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거
		
		String arr[] = new String[size];
		
		// 2. 첫 배열에 저장할 문자열 입력받기
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print( (i + 1) + "번째 문자열: ");
			arr[i] = sc.nextLine();
			
		}
		
		// 3. 반복이 시작되는 구간부터 while 작성하여 내부에 종료조건 만들어 break 이용하여 멈춤
		
		while (true) {
			
			System.out.print("더 값을 입력하시겠습니까(Y/N) : ");
			char ch = sc.next().charAt(0);
			
			// 4. 값을 더 입력할 경우
			if (ch == 'y' || ch == 'Y') {
				
				// 5. 더 입력받을 개수 입력받기
				 System.out.print("더 입력하고 싶은 개수: ");
				 int addSize = sc.nextInt();
				 
				 sc.nextLine();
				 
				 // 6. 새로 값을 입력받을 배열 생성
				 // --> 기존 배열 크기 + 추가 입력 개수
				 
				 String newArr[] = new String[arr.length + addSize];
				 
				 // 7. 배열 복사 + 새로운 문자열 입력받기
				 for(int i = 0; i < newArr.length; i++) {
					 
					 if(i < arr.length) { // 인덱스의 값이 기존 배열보다 작을 경우 (깊복)
						 
						 newArr[i] = arr[i];
						 
					 } else { // 인덱스의 값이 기존 배열보다 작을 경우 (새로운 값 입력받기)
						 
						 System.out.print((i+1) + "번째 문자열: ");
						 newArr[i] = sc.nextLine();
						 
					 }
					 
				 }
					 
				 //8. 기존 배열공간을 참조하던 변수 arr에 새로운 배열공간의 주소를 가진 newArr 대입 (얕복)
				 arr = newArr;
				
			} else if( ch == 'n' || ch =='N' ) {
				
				break;
				
			} else {
				
				System.out.println( "Y/N 으로 다시 입력하세요.");
				
			}
			
			
			
		}
		
		System.out.println(Arrays.toString(arr));
		
		
	}

}

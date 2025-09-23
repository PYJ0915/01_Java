package edu.kh.oop.method.model.service;

public class MethodExample {
	
	// 메서드가 호출될 때마다 Stack이라는 자료구조에 메서드를 실행한 이력이 쌓인다
     
	// main -> method1 -> method2
	// 그리고 제일 마지막에 쌓인 순서대로 Stack에서 나감
	// -> Last - Input - First - Out (LIFO) == 후입선출
	// method2 -> method1 -> main
	public void method1() {
		
		int result = method2(3,5);
		System.out.println(result);
		// return; 생략된 상태 (없으면 컴파일러가 자동으로 생성해 줌)
		// 해당 메서드를 종료하고 호출한 곳으로 되돌아 감
		
	}
	
	public int method2(int a, int b) {
		
		int sum = a+b;
		return sum;
		// return 값; (반환값이 있는 상태)
		// 해당 메서드를 종료하고 호출한 곳으로 sum 값을 가지고 되돌아감
		
	}
	

	
	
	
}

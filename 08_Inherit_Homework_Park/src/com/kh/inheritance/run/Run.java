package com.kh.inheritance.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
		
	/*	SmartPhone sp = new SmartPhone("Samsung", "Galaxy S20", 2020, 1200000, "Android", 128);
			sp.printInfo();
		
			System.out.println("=================================================");
			
		BasicPhone bp = new BasicPhone("Nokia", "3310", 2000, 100000, true);
			bp.printInfo();
			bp.checkKeyboard();
	 */
	
		Student stdArr[] = new Student[3];
		
		stdArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stdArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stdArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신학과");
		
		/* 향상된 for 문
		
		- 자바에서 배열, 컬렉션과 같은 데이터를 순차적으로 간단하게 반복할 수 있는 구조 제공
		- 일반적으로 for 문보다 코드가 더 간결하고 가독성이 좋아 반복 작업을 더 쉽게 작성할 수 있다.
		
		for(자료형 변수명 : 배열 OR 컬렉션) {
			반복해서 실행할 코드
		}
		 
		*/
		
		for(Student std : stdArr) {
			
			System.out.println(std.information());
			
		}
		
		System.out.println("=======================================================================================================");
		
		Employee[] empArr = new Employee[10];
		int index = 0;
		
		while(true) {
			
			System.out.print("\n이름을 입력하세요: ");
			String name = sc.next();
			
			System.out.print("나이를 입력하세요: ");
			int age = sc.nextInt();
			
			System.out.print("신장을 입력하세요: ");
			double height = sc.nextDouble();
			
			System.out.print("몸무게를 입력하세요: ");
			double weight = sc.nextDouble();
			
			System.out.print("급여를 입력하세요: ");
			int salary = sc.nextInt();
			
			System.out.print("부서를 입력하세요: ");
			String dept = sc.next();
			
			empArr[index] = new Employee(name, age, height, weight, salary, dept);
			
			index++;
			
			if(index == empArr.length) { // 배열이 꽉 찼을 경우 반복 종료
				break;
				
			}

			System.out.print("\n더 입력하고 하고 싶으신가요? (Y/N): ");
			String input = sc.next().toUpperCase();
			
			//toUpperCase() : 소문자 -> 대문자
			//toLowerCase() : 대문자 -> 소문자
			
			// equalsIgnoreCase() : 대소문자 구분하지 않고 두 문자열이 같은지만 체크!
			
			if(input.equals("N")) {
				
				break;
				
			}
		
		}
		
		//  현재까지 기록된 사원들의 정보 출력
		for(Employee emp : empArr) {
			
			if(emp == null) { // NullpointerException 방지
				break;
			}
		
			System.out.println("\n" + emp.information());
		
		}
	} 
}

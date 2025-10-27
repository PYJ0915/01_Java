package practice1.model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import practice1.model.dto.Student;

public class StudentManager {

	private List<Student> studentList;
	private Scanner sc = new Scanner(System.in);

	public StudentManager() {

		studentList = new ArrayList<Student>();

		studentList.add(new Student(2023001, "김민준", "컴퓨터공학과", 3.87));
		studentList.add(new Student(2023002, "이서연", "경영학과", 3.56));
		studentList.add(new Student(2023003, "박지후", "심리학과", 3.98));
		studentList.add(new Student(2023004, "최유진", "전기공학과", 2.91));
		studentList.add(new Student(2023005, "정하은", "디자인학과", 3.42));
		studentList.add(new Student(2023006, "한도윤", "기계공학과", 3.76));
		studentList.add(new Student(2023007, "오지민", "국어국문학과", 3.20));
		studentList.add(new Student(2023008, "윤서진", "의학과", 4.00));
		studentList.add(new Student(2023009, "신재현", "수학과", 3.68));
		studentList.add(new Student(2023010, "장현우", "화학공학과", 2.95));

	}

	public void displayMenu() {

		int menuNum = 17;

		while (menuNum != 0) {

			try {

				System.out.println("\n==== 학생관리 프로그램 ====");
				System.out.println("1. 학생 추가");
				System.out.println("2. 전체 조회");
				System.out.println("3. 학번으로 검색");
				System.out.println("4. 평균 점수 출력");
				System.out.println("0. 종료");

				System.out.print("번호 입력 : ");
				menuNum = sc.nextInt();

				switch (menuNum) {
				case 1:
					addStudent();
					break;
				case 2:
					showStudent();
					break;
				case 3:
					searchBystudentNo(); 
					break;
				case 4:
				    showAvgScore(); 
					break;
				case 0:
					System.out.println("프로그램을 종료합니다...");
					break;
				default:
					System.out.println("메뉴에 있는 번호로만 입력해주세요");
					break;
				}

			} catch (Exception e) {

				System.out.println("입력 형식에 맞게 입력해주세요");
				sc.nextLine();
				menuNum = -1;

			}
		}

	}

	public void addStudent() {

		System.out.println("==== 학생 추가 ====");

		System.out.print("학번 입력 : ");
		int studentNo = sc.nextInt();

		System.out.print("이름 입력 : ");
		String name = sc.next();
		sc.nextLine();

		System.out.print("전공 입력 : ");
		String major = sc.nextLine();

		System.out.print("학점 입력 : ");
		double score = sc.nextDouble();

		if (studentList.add(new Student(studentNo, name, major, score))) {

			System.out.println("학생 정보가 추가되었습니다");

		} else {

			System.out.println("학생 정보 추가 실패!");

		}

	}

	public void showStudent() {

		if (studentList.isEmpty()) {

			System.out.println("학생 목록이 비어있습니다.");
			return;

		}

		System.out.println("==== 학생 전체 조회 ====");
		
		// for-each 방식

		/*
		 * for(Student s : studentList) {
		 * 
		 * System.out.println(s);
		 * 
		 * }
		 */

		// Iterator 방식 => Iterator(반복자) : 컬렉션 객체에 저장된 요소를 하나씩 순차 접근하는 객체

		Iterator<Student> it = studentList.iterator(); // Student 객체를 담을 Iterator 객체 생성
		int index = 0;

		while (it.hasNext()) { // Iterator에 남은 Student 객체가 있다면 true

			Student s = it.next(); // 다음 Student 객체에 접근해서 s에 담기
			System.out.print(++index + ".");
			System.out.println(s);

		}

	}

	public void searchBystudentNo() {

		if (studentList.isEmpty()) {

			System.out.println("학생 목록이 비어있습니다.");
			return;

		}
		
		System.out.println("==== 학번으로 학생 검색 ====");
		
		System.out.print("검색할 학번을 입력하세요 : ");
		int studentNo = sc.nextInt();
		
		for(Student s : studentList) {
			
			if(s.getStudentNo() == studentNo) {
				
				System.out.println(s);
				return;
				
			}
			
		}
		
		System.out.println("해당하는 학번이 존재하지 않습니다.");

	}
	
	public void showAvgScore() {
		
		System.out.println("==== 평균 점수 출력 =====");
		
		double sum = 0; // 학점을 누적해줄 변수
		
		for(Student s : studentList) {
			
			sum += s.getScore();
			
		}
		
		double avg = sum / studentList.size();
		
		System.out.printf("학생들의 평균 점수는 %.2f점입니다!!", avg);
		
		
	}

}

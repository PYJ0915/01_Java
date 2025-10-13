package edu.kh.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory {

	private Scanner sc = new Scanner(System.in);

	private Set<Toy> toySet; // 장난감 객체를 담을 Set 선언

	private Map<Integer, String> subMap; // 재료들을 추가, 삭제할 Map 선언 

	public ToyFactory() {

		subMap = new HashMap<>(); // 재료들을 추가, 삭제할 Map 객체 생성

		subMap.put(1, "면직물");
		subMap.put(2, "플라스틱");
		subMap.put(3, "유리");
		subMap.put(4, "고무");

		toySet = new HashSet<>(); // 장난감 객체를 담을 Set 객체 생성

		toySet.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, toySubs(1, 4)));
		toySet.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, toySubs(1, 2)));
		toySet.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, toySubs(1, 2)));
		toySet.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, toySubs(1, 2)));
		toySet.add(new Toy("파피", 12, 57000, "빨간색", 19931225, toySubs(1, 2, 4)));

	}
	
	/*
	 - 가변인자 : 매개변수의 수가 특정되지 않을 때 사용 => 자료형 ... 변수명
	 - 가변인자를 통해 들어온 매개변수의 데이터 타입은 배열이다 
	 */
	
	/**
	 * 사이드 메서드 
	 * - Toy 객체 안의 subs 객체 초기화용 메서드
	 */
	public Set<String> toySubs(int... keys) { // 장난감마다 들어가는 재료의 개수가 다르기에 가변인자 사용

		Set<String> subSet = new HashSet<>(); // toySet 안에 들어갈 재료들을 담은 객체 생성

		for (int key : keys) { // 가변인자는 배열형태이기 때문에 향상된 for문을 통해 가변인자 배열 요소에 하나씩 접근

			String subValue = subMap.get(key);
			
			if(subValue != null) {
				
				subSet.add(subValue);
				
			}
			
		}

		return subSet;

	}


	/**
	 * 메뉴 출력용 메서드
	 */
	public void displayMenu() {

		int menuNum = 0;

		do {

			try {

				System.out.println("\n<< 플레이타임 공장 >>");
				System.out.println("1. 전체 장난감 조회하기");
				System.out.println("2. 새로운 장난감 만들기");
				System.out.println("3. 장난감 삭제하기");
				System.out.println("4. 장난감 제조일 순으로 조회하기");
				System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
				System.out.println("6. 재료 추가");
				System.out.println("7. 재료 제거");
				System.out.println("0. 프로그램 종료");
				System.out.print("선택 : ");
				menuNum = sc.nextInt();

				switch (menuNum) {
				case 1:
					showToy();
					break;
				case 2:
					addToy();
					break;
				case 3:
					System.out.println(removeToy());
					break;
				case 4:
					sortByDate();
					break;
				case 5:
					sortByAge();
					break;
				case 6:
					System.out.println(addSubs());
					break;
				case 7:
					System.out.println(removeSubs());
					break;
				case 0:
					System.out.println("\n프로그램을 종료합니다...");
					sc.close(); // 메모리 누수 방지용
					break;
				default:
					System.out.println("\n메뉴에 있는 번호로만 입력해주세요!");
					break;
				}

			} catch (InputMismatchException e) {

				System.out.println("\n메뉴에 있는 번호로만 입력해주세요!");
				sc.nextLine();
				menuNum = -1;

			} 

		} while (menuNum != 0);

	}
	
	
	
	/**
	 * 1. 전체 장난감 조회 메서드
	 * - 장난감 목록 비어있는지 체크 후 비어있지 않다면 장난감 목록 출력
	 */
	public void showToy() {

		if (toySet.isEmpty()) { // 조회하기 전에 목록이 비었는지 체크

			System.out.println("장난감 목록이 비어있습니다");
			return;

		}
		
		// 장난감 목록이 비어있지 않을 때 -> 목록 보여주기

		System.out.println("\n<전체 장난감 목록>");

		int index = 0; // 장난감 번호용 변수

		for (Toy t : toySet) {

			System.out.println(++index + "." + t);

		}

	}

	/**
	 * 2. 새로운 장난감 추가하는 메서드
	 * - 새로운 장난감 객체의 정보를 입력받고 그 정보를 토대로 장난감 객체를 만들어 toySet에 저장
	 */
	public void addToy() {

		System.out.println("\n<새로운 장난감 추가>");

		// 새로운 장난감 정보 입력받기
		
		System.out.print("장난감 이름 : ");
		String name = sc.next();

		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();

		System.out.print("가격 : ");
		int price = sc.nextInt();

		System.out.print("색상 : ");
		String color = sc.next();

		System.out.print("제조일 (YYYYMMDD 형식으로 입력) : ");
		int date = sc.nextInt();

		Set<String> subs = new HashSet<>(); // 새로운 장난감의 재료를 담을 객체 생성
		String sub; // 재료를 담을 객체에 새롭게 입력받은 재료들을 초기화하기 위한 변수 선언

		while (true) {

			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			sub = sc.next();

			if (sub.toUpperCase().charAt(0) == 'Q') { // q가 입력됐을 때 반복 종료
				
				break;
				
			} else if(subMap.containsValue(sub)) { // 재료 목록에 있는 재료인지 확인
				
				subs.add(sub);
				
			} else { // 재료 없을 시 추가 여부 확인
				
				System.out.println("해당하는 재료가 없습니다.");
				System.out.print("해당 재료를 추가하시겠습니까? (Y/N) : ");
				char answer = sc.next().toUpperCase().charAt(0);
				
				if (answer == 'Y') { // Y 입력 시 재료 추가 메서드 연결
					
					addSubs();
					
				}
				
			}
			
		} 

		toySet.add(new Toy(name, age, price, color, date, subs)); // 새로운 장난감 객체 추가

		System.out.println("새로운 장난감이 추가되었습니다.");
	}

	/**
	 * 3. 장난감 삭제하는 메서드
	 * - 삭제할 장난감 이름을 입력받고, 입력한 이름이 있는지 체크 후에 있다면 해당 객체 삭제
	 */
	public String removeToy() {

		System.out.println("\n<장난감 삭제>");

		// 삭제할 장난감 이름 입력
		
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String toyName = sc.next();

		for (Toy t : toySet) { // toySet을 순회하며 입력한 이름이 있는지 체크

			if (t.getName().equals(toyName)) { // 입력한 이름이 존재한다면 해당 객체 삭제 후 메세지 출력

				toySet.remove(t); 

				return toyName + " 장난감이 삭제되었습니다";

			}

		}
		
		// 입력한 이름이 없는 경우 
		
		return "해당하는 장난감이 존재하지 않습니다.";

	}

	/**
	 * 4. 제조일 순으로 정렬하는 메서드
	 */
	public void sortByDate() {

		List<Toy> toyList = new ArrayList<Toy>(toySet); // Set -> List 변환 => 정렬하기 위해

		Collections.sort(toyList); // 정렬 -> Toy 클래스에서 Comparable 인터페이스 상속 후 compareTo 오버라이딩

		System.out.println("\n<제조일 순으로 장난감을 정렬>");

		int index = 0; // 장난감 번호용 변수

		for (Toy t : toyList) {

			System.out.println(++index + "." + t);

		}

	}

	/**
	 * 5. 연령별 정렬 메서드
	 */
	public void sortByAge() {

		List<Toy> toyList = new ArrayList<Toy>(toySet); // Set -> List 변환 => 정렬하기 위해

		Collections.sort(toyList, new Comparator<Toy>() { // 익명클래스에서 compare 오버라이딩하여 오름차순 정렬

			@Override
			public int compare(Toy o1, Toy o2) {

				return o1.getAge() - o2.getAge();

			}

		});

		System.out.println("\n<연령별로 사용가능한 장난감>");
		
		int index = 0; // 장난감 번호용 변수
		int lastAge = -1; // 이전 연령 담을 변수, 처음에도 연령을 띄우기 위해 -1 대입

		for (Toy t : toyList) { // 정렬한 ToyList 순회
			
			if (t.getAge() != lastAge) { // 현재 연령과 이전 연령이 다른 경우 
				
				System.out.println("[연령 : " + t.getAge() + "세]"); // 현재 연령 출력
				lastAge = t.getAge(); // 현재 연령과 이전 연령이 달랐을 경우 다시 현재 연령으로 재대입
				index = 0; // 장난감 번호를 0으로 재대입
				
			}
			
			System.out.println(++index + "." + t); // 연령별로 정렬된 장난감 출력

		}

	}

	/**
	 * 6. 재료 추가 메서드
	 * - 현재 등록된 재료들을 출력 후, 새로 등록할 재료의 고유번호와 재료명을 입력받고 고유번호가 중복되는지 체크,
	 * - 중복된다면 덮어쓸 것인지 물어보고 Y입력시 입력한 고유번호와 재료 추가, 중복되지 않는다면 그대로 추가
	 */
	public String addSubs() {

		System.out.println("\n<재료 추가>");
		
		System.out.println("---현재 등록된 재료---");
		
		for(int key : subMap.keySet()) { // keySet 메서드를 통해 subMap의 key 값을 변수에 저장 후에 key에 대응하는 Value값 출력
			
			System.out.println(key + " : " + subMap.get(key));
			
		}
		
		System.out.println("----------------------");
		
		// 새로 등록할 재료의 고유번호와 재료명을 입력
		
		System.out.print("재료 고유번호(Key) 입력 : ");
		int key = sc.nextInt();

		System.out.print("재료명 입력 : ");
		String value = sc.next();

		if (subMap.containsKey(key)) { // 고유번호가 중복되는지 체크

			System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N) : "); // 중복된다면 덮어쓸 것인지 물어보기
			char answer = sc.next().toUpperCase().charAt(0);

			if (answer == 'Y') { //  Y입력시 입력한 고유번호와 재료 추가

				subMap.put(key, value);
				return "재료가 성공적으로 덮어쓰기 되었습니다.";

			}
			// Y를 입력하지 않은 경우
			
			return "취소";

		}

		// 중복되는 key가 없는 경우 새로운 key에 재료 넣기

		subMap.put(key, value);

		return "새로운 재료가 성공적으로 등록되었습니다.";

	}

	/**
	 * 7. 재료 삭제 메서드
	 * - 현재 등록된 재료들을 출력 후, 삭제할 재료명을 입력 받아 현재 subMap의 Value 값에 해당하는 재료명이 존재하는지 체크
	 * - 존재한다면 해당 재료 삭제 후 삭제 메세지 출력
	 */
	public String removeSubs() {

		System.out.println("\n<재료 삭제>");
		
		// 현재 등록된 재료들을 출력
		
		System.out.println("---현재 등록된 재료---");
		
		for(int key : subMap.keySet()) {
			
			System.out.println(key + " : " + subMap.get(key));
			
		}
		
		System.out.println("----------------------");
		
		// 삭제할 재료명 입력
		System.out.print("삭제할 재료명 입력 : ");
		String removeSub = sc.next();

		for (int key : subMap.keySet()) { // keySet 메서드를 통해 subMap의 key 값을 변수에 저장하여 subMap 순회

			if (subMap.get(key).equals(removeSub)) { // 현재 subMap의 Value 값에 입력받은 재료명이 존재하는지 체크
				
				// 존재하는 경우 해당 재료 삭제 후 삭제 메세지 출력
				
				subMap.remove(key);
				return "재료" + "\'" + removeSub + "\'이/가 성공적으로 제거되었습니다.";

			}

		}
		
		// 존재하지 않는 경우
		
		return "해당하는 재료가 존재하지 않습니다."; 

	}

}

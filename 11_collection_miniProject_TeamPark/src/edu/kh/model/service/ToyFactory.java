package edu.kh.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory {

	private Scanner sc = new Scanner(System.in);

	private Set<Toy> toySet;

	private Map<Integer, String> subMap;

	public ToyFactory() {

		toySet = new LinkedHashSet<>();

		toySet.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, toySubs("면직물", "고무")));
		toySet.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, toySubs("면직물", "플라스틱")));
		toySet.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, toySubs("면직물", "플라스틱")));
		toySet.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, toySubs("면직물", "플라스틱")));
		toySet.add(new Toy("파피", 12, 57000, "빨간색", 19931225, toySubs("면직물", "고무", "플라스틱")));

		subMap = new HashMap<>();

		subMap.put(1, "면직물");
		subMap.put(2, "플라스틱");
		subMap.put(3, "유리");
		subMap.put(4, "고무");

	}


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
	
	public Set<String> toySubs(String... subs) {

		Set<String> subSet = new HashSet<>();

		for (String s : subs) {

			subSet.add(s);
		}

		return subSet;

	}
	
	public void showToy() {

		if (toySet.isEmpty()) {

			System.out.println("장난감 목록이 비어있습니다");
			return;

		}
		// 장난감 목록이 비어있지 않을 때 -> 목록 보여주기

		System.out.println("\n<전체 장난감 목록>");

		int index = 0;

		for (Toy t : toySet) {

			System.out.println(++index + "." + t);

		}

	}

	public void addToy() {

		System.out.println("\n<새로운 장난감 추가>");

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

		Set<String> subs;
		String sub = null;
		subs = new HashSet<>();

		do {

			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			sub = sc.next();

			if (sub.toLowerCase().charAt(0) != 'q') {
				
				subs.add(sub);
				
			}
			
		} while (sub.toUpperCase().charAt(0) != 'Q');

		toySet.add(new Toy(name, age, price, color, date, subs));

		System.out.println("새로운 장난감이 추가되었습니다.");
	}

	public String removeToy() {

		System.out.println("\n<장난감 삭제>");

		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String toyName = sc.next();

		for (Toy t : toySet) {

			if (t.getName().equals(toyName)) {

				toySet.remove(t);

				return toyName + " 장난감이 삭제되었습니다";

			}

		}

		return "해당하는 장난감이 존재하지 않습니다.";

	}

	public void sortByDate() {

		List<Toy> toyList = new ArrayList<Toy>(toySet); // Set -> List 변환

		Collections.sort(toyList);

		System.out.println("\n<제조일 순으로 장난감을 정렬>");

		int index = 0;

		for (Toy t : toyList) {

			System.out.println(++index + "." + t);

		}

	}

	public void sortByAge() {

		List<Toy> toyList = new ArrayList<Toy>(toySet);

		Collections.sort(toyList, new Comparator<Toy>() {

			@Override
			public int compare(Toy o1, Toy o2) {

				return o1.getAge() - o2.getAge();

			}

		});

		System.out.println("\n<연령별로 사용가능한 장난감>");
		
		int index = 0;
		int lastAge = 0;

		for (Toy t : toyList) {
			
			if (t.getAge() != lastAge) {
				
				System.out.println("[연령 : " + t.getAge() + "세]");
				lastAge = t.getAge();
				index = 0;
			}
			
			System.out.println(++index + "." + t);

		}

	}

	public String addSubs() {

		System.out.println("\n<재료 추가>");
		
		System.out.println("---현재 등록된 재료---");
		
		for(int key : subMap.keySet()) {
			
			System.out.println(key + " : " + subMap.get(key));
			
		}
		
		System.out.println("----------------------");

		System.out.print("재료 고유번호(Key) 입력 : ");
		int key = sc.nextInt();

		System.out.print("재료명 입력 : ");
		String value = sc.next();

		if (subMap.containsKey(key)) {

			System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N) : ");
			char answer = sc.next().toUpperCase().charAt(0);

			if (answer == 'Y') {

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

	public String removeSubs() {

		System.out.println("\n<재료 삭제>");
		
		System.out.println("---현재 등록된 재료---");
		
		for(int key : subMap.keySet()) {
			
			System.out.println(key + " : " + subMap.get(key));
			
		}
		
		System.out.println("----------------------");

		System.out.print("삭제할 재료명 입력 : ");
		String removeSub = sc.next();

		for (int key : subMap.keySet()) {

			if (subMap.get(key).equals(removeSub)) {

				subMap.remove(key);
				return "재료" + "\'" + removeSub + "\'이/가 성공적으로 제거되었습니다.";

			}

		}

		return "해당 이름의 재료가 존재하지 않습니다.";

	}

}

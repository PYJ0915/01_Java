package edu.kh.model.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory {

	private Scanner sc = new Scanner(System.in);
	private Set<Toy> toySet = new HashSet<>();
	private Map<Integer, String> subMap = new HashMap<>();
	
	
	public ToyFactory() {
		toySet.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, new HashSet<String>()));
		toySet.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, new HashSet<String>() ));
		toySet.add(new Toy("파피", 12, 57000, "빨간색", 19931225, new HashSet<String>()));
		toySet.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, new HashSet<String>()));
		toySet.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, new HashSet<String>()));
		subMap.put(1, "면직물");
		subMap.put(2, "플라스틱");
		subMap.put(3, "유리");
		subMap.put(4, "고무");
	}
	
	public void addSubSet() {
		
	}

	/**
	 * 네비게이타 : 박유진, 도라이바 : 박상민
	 * 
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
				sc.nextLine();

				switch (menuNum) {
				case 1:
					showToy(); 
					break;
				case 2:
					addToy(); 
					break;
				case 3:
					/* removeToy(); */
					break;
				case 4:
					/* showToyByDate(); */
					break;
				case 5:
					/* showToyByAge(); */
					break;
				case 6:
					/* addSubs(); */
					break;
				case 7:
					/* removeSubs(); */
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					break;

				default:
					System.out.println("메뉴에 있는 번호를 입력해주세요.");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("메뉴에 있는 번호를 입력해주세요.");
				sc.nextLine();
				menuNum = -1;
			}

		} while (menuNum != 0);
	}
	

	/**
	 * 
	 * 네비게이타 : 박상민, 도라이바 : 박유진
	 * 
	 * 전체 장난감 조회용 메서드
	 */
	public void showToy() {
		
		if(toySet.isEmpty()) {
			
			System.out.println("장난감 목록이 비었습니다");
			return;
			
		}
		
		System.out.println("\n<전체 장난감 목록>");
		
		int num = 0;
		
		for(Toy toy : toySet) {
			
			++num;
			System.out.println( num + ". " + toy );
			
		}
		
		
	}

	private void addToy() {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

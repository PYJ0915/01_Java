package edu.kh.imsolo.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.imsolo.model.dto.Member;

public class SoloApp {

	private List<Member> memberList;
	private Scanner sc = new Scanner(System.in);

	public SoloApp() {

		memberList = new ArrayList<Member>();

		memberList.add(new Member("광수", 30, "마케터", "인천", 'M', addHobby("농구")));
		memberList.add(new Member("상철", 33, "디자이너", "서울", 'M', addHobby("사진", "전시회")));
		memberList.add(new Member("순자", 28, "바이올리니스트", "대전", 'F', addHobby("클래식", "산책")));
		memberList.add(new Member("영수", 31, "회계사", "부산", 'M', addHobby("러닝", "보드게임")));
		memberList.add(new Member("영숙", 33, "연구원", "수원", 'F', addHobby("요가", "카페투어")));
		memberList.add(new Member("영철", 34, "개발자", "서울", 'M', addHobby("등산", "볼링")));
		memberList.add(new Member("정숙", 30, "교사", "부산", 'F', addHobby("독서", "요리")));
		memberList.add(new Member("현숙", 34, "개발자", "서울", 'F', addHobby("코딩", "러닝")));

	}

	/**
	 * 멤버 취미 추가용 사이드 메서드 - 가변인자로 각 취미들을 전달 받아 새롭게 생성한 List 객체에 추가 후 반환
	 */
	public List<String> addHobby(String... hobby) {

		List<String> hobbies = new ArrayList<String>();

		for (String s : hobby) {

			hobbies.add(s);

		}

		return hobbies;

	}

	public void displayMenu() {

		int menuNum = 9;

		while (menuNum != 0) {

			try {
				
				System.out.println("\n==== 나는 SOLO 미니 ====");
				
				System.out.println("1. 전체 참가자 조회");
				System.out.println("2. 첫인상 투표");
				System.out.println("3. 데이트 신청");
				System.out.println("4. 모든 참가자별 호감도 조회");
				System.out.println("5. 마지막 선택");
				System.out.println("0. 종료");

				System.out.print(">> ");
				menuNum = sc.nextInt();

				switch (menuNum) {
				case 1:
					showMember(); 
					break;
				case 2:
					 firstChoice();
					break;
				case 3:
					/* choiceDate */
					break;
				case 4:
					/* showLove */
					break;
				case 5:
					/* lastChoice */
					break;
				case 0:
					System.out.println("프로그램을 종료합니다...");
					break;
				default:
					System.out.println("메뉴에 있는 번호만 입력해 주세요!");
				}

			} catch (InputMismatchException e) {

				System.out.println("메뉴에 있는 번호만 입력해주세요!");
				sc.nextLine();
				menuNum = -1;

			}

		}

	}

	
	private void showMember() {
		
		System.out.println("==== 전체 참가자 조회 ====");
		
		if(memberList.isEmpty()) {
			
			System.out.println("참가자 목록이 비어있습니다");
			return;
			
		}
		
		// 참가자 목록 O => 조회
		
		for(Member member : memberList) {
			
			System.out.println(member);
			
		}
		
	}
	
	private void firstChoice() {
		
		System.out.println("==== 첫인상 투표 ====");
		
		
		
	}
}

package com.hw1.model.service;

import java.util.Scanner;

import com.hw1.model.vo.Member;

public class MemberService {

	// 구현 기능 - 메뉴화면, 빈 배열 찾기, 회원가입, 로그인, 회원 정보 찾기, 회원 정보 수정, 회원 검색(지역)
	
	private Scanner sc = new Scanner(System.in);
	
	private Member [] memberInfo = new Member[5];
	
	private Member loginInfo = null;
	
	Member member = new Member();

	public MemberService() {
		
		memberInfo[0] = new Member("user01", "pass01", "홍길동", 20, "서울");
		memberInfo[1] = new Member("user02", "pass02", "허균", 57, "경기");
		memberInfo[2] = new Member("user03", "pass03", "이순신", 43, "제주도");
		
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
		
		System.out.println("======= 회원 관리 프로그램 V2(hw) ========");
		
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원 정보 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 검색(지역)");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 입력: ");
		menuNum = sc.nextInt();
		
		switch(menuNum) {
			
		case 1: 
			System.out.println(signUp());
			break;
		case 2: 
			System.out.println(login());
			break;
		case 3: 
			System.out.println(selectMember());
			break;
		case 4: 
			System.out.println(updateMember());
			break;
		case 5:
			System.out.println(searchMember());
			break;
		case 0: 
			System.out.println("프로그램을 종료합니다...");
			break;
		default : 
			System.out.println("메뉴에 있는 숫자로 입력해주세요!");
			
		
		}
		
		
		} while(menuNum != 0);
		
	}
	
	
	
	public int emptyIndex() {
		
		for(int i = 0; i < memberInfo.length; i++) {
			
			if(memberInfo[i] == null) {
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	public String signUp() {
		
		int index = emptyIndex();
		
		if(index == -1) {
			return "회원가입 실패 (인원 수 초과)";
		}
		
		System.out.println("\n======= 회원가입 =======");
		
		System.out.print("아이디: ");
		String memberId = sc.next();
		
		System.out.print("비밀번호: ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인: ");
		String memberPwCheck = sc.next();
		
		System.out.print("이름: ");
		String memberName = sc.next();
		
		System.out.print("나이: ");
		int memberAge = sc.nextInt();
		
		System.out.print("지역: ");
		String memberRegion = sc.next();
		
		
		if(memberPw.equals(memberPwCheck)) {
			
			memberInfo[index] = new Member(memberId, memberPw, memberName, memberAge, memberRegion);
			
			return "회원가입 성공! 환영합니다 " + memberName + "님";
		}
		
		return "회원가입 실패 (비밀번호 불일치)";
		
	}
	
	public String login() {
		
		System.out.println("\n======= 로그인 =======");
		
		System.out.print("아이디: ");
		String memberId = sc.next();
		
		System.out.print("비밀번호: ");
		String memberPw = sc.next();
		
		for(int i = 0; i < memberInfo.length; i++) {
			
			if (memberInfo[i] == null) {
				break;
			}
			
			if(memberInfo[i].getMemberId().equals(memberId) && memberInfo[i].getMemberPw().equals(memberPw)) { // 로그인 성공
				
				loginInfo = memberInfo[i];
				
				return "로그인 성공! 환영합니다 " + loginInfo.getMemberName() +"님";
				
			}
			
		}
		
		return "로그인 실패! 아이디 혹은 비밀번호가 틀립니다.";
		
	}
	
	public String selectMember() {
		
		System.out.println("\n======= 회원 정보 조회 =======");
		
		if(loginInfo != null) { // 로그인한 경우
			
			return "이름 : " + loginInfo.getMemberName() + "\n아이디: " + loginInfo.getMemberId()
			+ "\n나이: " + loginInfo.getMemberAge() + "\n지역: " + loginInfo.getMemberRegion();
			
		}
		
		return "로그인부터 해주세요!";
		
	}
	
	public String updateMember() {
		
		System.out.println("\n======= 회원 정보 수정 =======");
		
		if(loginInfo != null) { // 로그인한 경우
			
			System.out.print("수정할 이름 입력: ");
			String updateName = sc.next();
			
			System.out.print("수정할 나이 입력: ");
			int updateAge = sc.nextInt();
			
			System.out.print("수정할 지역 입력: ");
			String updateRegion = sc.next();
			
			System.out.print("비밀번호 입력: ");
			String Pwc = sc.next();
			
		if(Pwc.equals(loginInfo.getMemberPw()))	{ // 비밀번호 일치 -> 수정
			
			loginInfo.setMemberName(updateName);
			loginInfo.setMemberAge(updateAge);
			loginInfo.setMemberRegion(updateRegion);
			
			return "회원 정보가 수정되었습니다! :)";
			
		} else {
			
			return "회원 정보 수정 실패! (비밀번호 불일치)";
			
			}
		}
		
		return "로그인부터 해주세요!";
		
	}
	
	public String searchMember() {
		System.out.println("\n======= 회원 검색(지역) =======");
		
		System.out.print("검색할 지역 입력: ");
		String searchRegion = sc.next();
		
		
		for(int i = 0; i < memberInfo.length; i++) {
			
			if(memberInfo[i] == null) {
				
				break;
				
			}
			
			if(searchRegion.equals(memberInfo[i].getMemberRegion())) {
				
				return "아이디: " + memberInfo[i].getMemberId() + "\n이름: " + memberInfo[i].getMemberName();
				
			}
			
		}
				return "일치하는 검색 결과가 없습니다";
	}
}

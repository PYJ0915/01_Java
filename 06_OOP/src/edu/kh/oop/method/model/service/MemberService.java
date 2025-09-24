package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService {

	// 속성
	private Scanner sc = new Scanner(System.in);
	
	// 가입한 회원의 정보를 저장할 변수
	private Member memberInfo = null;
	
	// 로그인한 회원의 정보를 저장할 변수
	private Member loginMember = null;
	
	// 기능(생성자 / 메서드)
	
	// 메뉴화면 출력 기능
	public void displayMenu() {
		
		int menuNum = 0; // 메뉴 선택용 변수
		
		// 무조건 한 번은 실행하는 do-while문 활용
		do {
			System.out.println("====== 회원 정보 관리 프로그램 ======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			System.out.print("\n메뉴 입력: ");
			menuNum = sc.nextInt();
			sc.nextLine(); 
			
			switch(menuNum) {
			// 내가 호출한 메서드가 return 하는 값을 잘 생각하기!
			case 1: System.out.println( signUp() ); // return 값을 출력하기 위해 print 구문 내부에 호출
				break;
			case 2:	System.out.println( login() ); 
				break;
			case 3: System.out.println( selectMember() );
				break;
			case 4: int result = updateMember();
					
					if(result == -1) {
						
						System.out.println("\n로그인 후 이용해주세요\n");
						
					} else if(result == 0) {
						
						System.out.println("\n회원 정보 수정 실패(비밀번호 불일치)\n");
						
					} else
						// result == 1
						System.out.println("\n회원 정보가 수정되었습니다!\n");
						
					break;
			case 0: 
				System.out.println("프로그램 종료...");
				break;
			default :
				System.out.println("메뉴에 있는 번호를 입력해주세요!");
			}
			
		} while(menuNum != 0); // menuNum이 0이 될 때 반복 봉료
		
	}
	
	// 회원 가입 기능
	public String signUp() {
	// 반환형이 존재한다면 모든 경우에 반환값 있어야함!
		
		System.out.println("\n************* 회원가입 *************");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPwCheck = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		// 비밀번호와 비밀번호 확인이 일치할 시 회원가입 진행, 불일치 시 회원가입 실패
		
		if( memberPw.equals(memberPwCheck) ) { // 일치
			
			// 회원가입 : 새로운 회원 객체 생성
			// -> Member 클래스를 이용해서 새로운 객체를 생성 (매개변수 생성자 이용)
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			// 회원가입한 정보를 가진 객체의 주소 값을 memberInfo라는 필드변수에 참조시킴
			// -> 회원가입이 진행된 후엔 memberInfo는 더 이상 null 이 아님
			
			return "\n회원가입 성공!!\n";
			
		} else { // 불일치
			
			return "\n회원가입 실패! (비밀번호 불일치)\n";
			
		}
		
		
		
		
	}
	
	// 로그인 기능
	public String login() {
		// 회원가입 되어있는 사람이 있는지 없는지 검사
		// 내가 입력한 아이디와 비밀번호로 가입한 사람의 정보가 있는지 확인.
		
		System.out.println("\n********** 로그인 *************");
		// 회원 가입을 했는지부터 확인
		// -> memberInfo가 null인지 확인
		
		if(memberInfo == null) { // 회원가입을 하지 않은 경우
			// null: 아무것도 참조하고 있지 않음
			
			return "회원가입부터 진행해주세요!\n"; // 얼리리턴 기능
			// return 값;
			// -> ** 현재 메서드를 종료하고 값을 가지고 해당 메서드를 호출한 쪽으로 되돌아감
			
		} 
		// 회원가입을 했다면 해당 라인으로 도달!
		// 로그인 기능 수행
		
		System.out.print("아이디: ");
		String memberId = sc.next();
		
		System.out.print("비밀번호: ");
		String memberPw = sc.next();
		
		 /* 회원가입 정보 (memberInfo가 참조하는 Member 객체)에 저장된 아이디, 비밀번호가 
		 	입력한 아이디, 비밀번호와 같으면 "로그인 성공", 같지 않으면 "아이디 또는 비밀번호 불일치" 리턴 */
		 
		if(memberId.equals(memberInfo.getMemberId()) && memberPw.equals(memberInfo.getMemberPw())) {
			
			// 로그인한 사람의 정보 기억 시키기
			// == loginMember에 memberInfo가 참조하고 있는 객체의 주소대입
			loginMember = memberInfo; // 얕은 복사 
			
			return "\n로그인 성공! " + loginMember.getMemberName() + "님 환영합니다\n";
			
		} else {
			
			return "\n아이디 또는 비밀번호가 일치하지 않습니다\n";
			
		}
		
	}
	
	// 회원 정보 조회 기능
	public String selectMember() {
		// 조회하려면? 로그인 여부 확인 먼저
		// 로그인 했다면? 현재 로그인한 사람의 정보를 저장한 객체에서 정보 얻어오기 (이름, 아이디, 나이)
		// 로그인 하지 않았다면? 로그인 후 이용해주세요
		
		System.out.println("\n********** 회원 정보 조회 ************");
		
		// 1) 로그인 여부 확인
		
		if(loginMember == null) {
			
			return "\n로그인 후 이용해주세요\n";
			
		}
		
		// 2) 로그인이 되어있는 경우
		// 이름 : 홍길동
		// 아이디 : user01
		// 나이 : 20세
		
		String str = "이름 : " + loginMember.getMemberName();
		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " + loginMember.getMemberAge() + "세\n";
		
		return str;
		
	}
	
	// 회원 정보 수정 기능
	public int updateMember() {
		
		System.out.println("\n*********** 회원 정보 수정 ***********");
		
		// 1) 로그인 여부 판별
		// 로그인이 되어있지 않으면 -1 반환
		
		if(loginMember == null) {
			
			return -1;
			
		}
		
	    // 2) 로그인이 되어있을 때
		// 2-1) 수정할 회원 정보 입력 받기 (이름, 나이)
		
		System.out.print("수정할 이름: ");
		String inputName = sc.next();
		
		System.out.print("수정할 나이: ");
		int inputAge = sc.nextInt();
		
		// 2-2) 비밀번호를 입력 받아 현재 로그인한 회원의 비밀번호와 일치하는지 확인
		
		System.out.print("비밀번호 입력: ");
		String inputPW = sc.next();
		
		if(inputPW.equals( loginMember.getMemberPw() ) ) {
			// 비밀번호가 일치하는 경우 
			// 로그인한 회원의 이름과 나이 정보를 수정하기 위해 입력받은 값으로 변경 후 1 반환
			
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			
			return 1;
			
		} else {
			// 비밀번호가 일치하지 않는 경우 0 반환
			
			return 0;
			
		}
		
	}
	
	
	// 클린코드 규칙
	// 메서드는 하나의 일만 하도록 작성
	
}

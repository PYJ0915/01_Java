package com.hw3.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {

	private Scanner sc = new Scanner(System.in);

	private List<Book> bookList = new ArrayList<>();

	public BookService() {

		bookList.add(new Book("세이노의 가르침", 1111, "세이노", 6480, "데이원"));
		bookList.add(new Book("문과남자의 과학공부", 2222, "유시민", 15750, "돌베게"));
		bookList.add(new Book("역행자", 3333, "자청", 17550, "웅진지식하우스"));
		bookList.add(new Book("꿀벌의 예언", 4444, "베르나르 베르베르", 15120, "열린책들"));
		bookList.add(new Book("도둑맞은 집중력", 5555, "요한 하리", 16920, "어크로스"));

	}

	public void displayMenu() {

		int menuNum = 0;

		try {

			do {

				System.out.println("\n=== 도서 목록 프로그램 ===");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 수정");
				System.out.println("4. 도서 삭제");
				System.out.println("5. 즐겨찾기 추가");
				System.out.println("6. 즐겨찾기 삭제");
				System.out.println("7. 즐겨찾기 조회");
				System.out.println("8. 추천도서 뽑기");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴를 입력하세요 : ");
				menuNum = sc.nextInt();

				switch (menuNum) {

				case 1:
					System.out.println(addBook());
					break;
				case 2:
					selectBook();
					break;
				case 3:
					updateBook();
					break;
				case 4:
					removeBook();
					break;
				case 5:
					/* addBookMark(); */
					break;
				case 6:
					/* selectBookMark(); */
					break;
				case 7:
					/* removeBookMark(); */
					break;
				case 8:
					/* pickBook(); */
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("메뉴에 있는 숫자를 입력해주세요.");

				}

			} while (menuNum != 0);

		} catch (InputMismatchException e) {

			System.out.println("\nerror: 메뉴에 있는 숫자만 입력해주세요!");
			sc.nextLine();
			menuNum = -1;

		}

	}

	public String addBook() {

		System.out.println("\n======== 도서 등록 ========");

		System.out.print("도서 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();

		System.out.print("도서 제목 : ");
		String name = sc.nextLine();

		System.out.print("도서 저자 : ");
		String author = sc.nextLine();

		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("도서 출판사 : ");
		String publisher = sc.nextLine();

		if (bookList.add(new Book(name, num, author, price, publisher))) {

			return "\n등록완료";

		} else {

			return "등록 실패";

		}

	}

	public void selectBook() {

		if (bookList.isEmpty()) {

			System.out.println("도서 목록이 비어있습니다");
			return;

		}

		for (Book b : bookList) {

			System.out.println(b);
			System.out.println();

		}

	}

	public void updateBook() {

		for (Book b : bookList) {

			System.out.println(b);
		}

		System.out.println("\n======== 도서 수정 ========");

		if (bookList.isEmpty()) {

			System.out.println("도서 목록이 비어있습니다");
			return;

		}

		System.out.print("수정할 도서 번호를 입력하세요 ");
		int num = sc.nextInt();

		// 일치하는 도서 번호가 있는지 검색
		for (int i = 0; i < bookList.size(); i++) {

			// 일치하는 도서 번호가 있을 때
			if (num == bookList.get(i).getBookNum()) {

				System.out.println("1. 도서명");
				System.out.println();

				System.out.println("2. 도서 저자");
				System.out.println();

				System.out.println("3. 도서 가격");
				System.out.println();

				System.out.println("4. 도서 출판사");
				System.out.println();

				System.out.println("0. 수정종료");
				System.out.println();

				System.out.print("어떤 정보를 수정하시겠습니까? ");
				int input = sc.nextInt();
				sc.nextLine();

				switch (input) {
				case 1: // 도서명 수정

					System.out.print("수정할 도서명을 입력하세요: ");
					String updateName = sc.nextLine();
					bookList.get(i).setName(updateName);
					System.out.println("수정 완료");
					break;

				case 2: // 도서 저자 수정

					System.out.print("수정할 도서명을 입력하세요: ");
					String updateAuthor = sc.nextLine();
					bookList.get(i).setAuthor(updateAuthor);
					System.out.println("수정 완료");
					break;

				case 3: // 도서 가격 수정

					System.out.print("수정할 도서명을 입력하세요: ");
					int updatePrice = sc.nextInt();
					bookList.get(i).setPrice(updatePrice);
					System.out.println("수정 완료");
					break;

				case 4: // 도서 출판사 수정

					System.out.print("수정할 도서명을 입력하세요: ");
					String updatePublisher = sc.nextLine();
					bookList.get(i).setName(updatePublisher);
					System.out.println("수정 완료");
					break;

				case 0: // 프로그램 종료

					System.out.println("수정이 종료되었습니다.");
					break;

				}

				return;

			}

		}

		// 일치하는 도서 번호가 없을 때

		System.out.println("검색하신 책이 존재하지 않습니다.");
		return;

	}

	public void removeBook() {

		
		System.out.println("\n======== 도서 삭제 ========");

		if (bookList.isEmpty()) {

			System.out.println("도서 목록이 비어있습니다");
			return;

		}

		for (Book b : bookList) {

			System.out.println(b);

		}

		System.out.print("삭제할 도서의 번호를 입력하세요: ");
		int bookNo = sc.nextInt();

		for (int i = 0; i < bookList.size(); i++) {

			if (bookNo == bookList.get(i).getBookNum()) {

				System.out.print("정말 삭제하시겠습니까? (Y/N) ");
				char answer = sc.next().toLowerCase().charAt(0);

				if (answer == 'y') {
					
					bookList.remove(i);
					System.out.println("삭제 완료되었습니다.");
					return;

				} 
				
				System.out.println("취소");
				return;

			}

		}

	}
}

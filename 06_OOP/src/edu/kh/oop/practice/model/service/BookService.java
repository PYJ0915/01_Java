package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {

	
	public void practice() {
		
		Book b1 = new Book();
		
		Book b2 = new Book("자바의 정석", 30000, 0.2, "남궁성");
				
		System.out.println(b1.toString());
		
		System.out.println(b2.toString());
		
		System.out.println("=============================");
		System.out.println("수정된 결과 확인");
		
		b1.setTitle("c언어");
		b1.setPrice(30000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("홍길동");
		
		System.out.println(b1.toString());
		
		System.out.println("=============================");
		
		System.out.printf("도서명 = %s\n할인된 가격 = %d원\n", b1.getTitle(), b2.getPrice() - (int)(b1.getPrice() * b1.getDiscountRate()));
		
		System.out.printf("도서명 = %s\n할인된 가격 = %d원\n", b2.getTitle(), b2.getPrice() - (int)(b2.getPrice() * b2.getDiscountRate()));
		
	}
	
	
}

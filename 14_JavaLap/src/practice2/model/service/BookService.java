package practice2.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import practice2.model.dto.Book;
import practice2.model.dto.EBook;

public class BookService {
	
	private FileWriter fw = null;
	private FileReader fr = null;
	
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	
	private List<Book> bookList = null;
	private Scanner sc = null;
	
	public BookService() {
		
		bookList = new ArrayList<Book>();
		
		bookList.add(new Book("자바의 정석", "남궁성", 32000));
		bookList.add(new Book("혼자 공부하는 SQL", "신용권", 28000));
		bookList.add(new Book("토비의 스프링", "이일민", 45000));
		bookList.add(new Book("데이터베이스 첫걸음", "미야자키 쇼이치", 22000));
		bookList.add(new Book("모던 자바 인 액션", "라울 게이브리얼 우르마", 35000));
		
		bookList.add(new EBook("Effective Java", "조슈야 블로크", 27000, 5.2));
		bookList.add(new EBook("Clean Code", "로버트 C. 마틴", 26000, 4.8));
		bookList.add(new EBook("이펙티브 타입스크립트", "댄 밴더캄", 25000, 6.3));
		bookList.add(new EBook("Real MySQL", "이성욱", 33000, 7.1));
		bookList.add(new EBook("Do it! 자바 프로그래밍 입문", "박은종", 19000, 3.6));
		
	}
	
}

package practice2.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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

		try {

			File file = new File("books.txt");

			if (file.exists()) {
				fr = new FileReader("books.txt");
				br = new BufferedReader(fr);

				System.out.println(br.readLine());

			}

		} catch (Exception e) {

			e.printStackTrace();

			try {

				if (br != null)
					br.close();

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public void bookService() {
		
		try {
			
			fw = new FileWriter("books.txt");
			bw = new BufferedWriter(fw);
			
			sc = new Scanner(System.in);
			StringBuilder sb = null;
			
			while(true) {
				
				System.out.print("도서명을 입력하세요 : ");
				String name = sc.nextLine();
				
				System.out.print("저자를 입력하세요 : ");
				String author = sc.nextLine();
				
				System.out.print("가격을 입력하세요 : ");
				int price = sc.nextInt();
				
				System.out.print("EBook 여부 (Y/N) : ");
				char answer = sc.next().toLowerCase().charAt(0);
				
				if(answer == 'y') {
					
					System.out.print("용량(MB)을 입력하세요 : ");
					double fileSize = sc.nextDouble();
					
					bookList.add(new EBook(name, author, price, fileSize));
					sb = new StringBuilder();
					sb.append(new EBook().getInfo());

					System.out.print("프로그램을 종료하시겠습니까? (Y/N) : ");
					if(sc.next().toLowerCase().charAt(0) == 'y') {
						
						bw.write(sb.toString());
						break;
						
					}
					
				
					} else {
						
						bookList.add(new Book(name, author, price));
						sb = new StringBuilder();
						sb.append(new Book().getInfo());
						
						System.out.print("프로그램을 종료하시겠습니까? (Y/N) : ");
						if(sc.next().toLowerCase().charAt(0) == 'y') {
							
							bw.write(sb.toString());
							break;
							
						}
					
				}
				
				sc.nextLine();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(bw != null) bw.close();
				if(br != null) br.close();
				if(sc != null) sc.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
		}
		
		
	}

}

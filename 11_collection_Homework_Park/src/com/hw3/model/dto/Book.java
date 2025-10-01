package com.hw3.model.dto;

public class Book {
	
	private String name;
	private int bookNum;
	private String author;
	private int price;
	private String publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	
	public Book(String name, int bookNum, String author, int price, String publisher) {
		super();
		this.name = name;
		this.bookNum = bookNum;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public String toString() {
		return bookNum + "번 도서 [도서제목: " + name + " / 도서 저자: " + author + "/ 도서 가격: " + price + "/ 출판사: " + publisher
				+ "]";
	}
	
	
	

}

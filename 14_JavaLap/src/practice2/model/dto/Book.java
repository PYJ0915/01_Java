package practice2.model.dto;

public class Book {
	
	private String title;
	private String author;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String getInfo() {
		
		return String.format("제목: %s / 저자: %s / 가격: %d원", title, author, price);
		
	}

}

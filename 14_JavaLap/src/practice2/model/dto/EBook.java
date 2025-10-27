package practice2.model.dto;

public class EBook extends Book{

	private double fileSize;
	
	public EBook() {
		
	}

	 public EBook(String title, String author, int price, double fileSize) {
		super(title, author, price);
		this.fileSize = fileSize;
	}

	 @Override
	public String getInfo() {
		 
		return super.getInfo() + "용량: " + fileSize + "MB";
		
	}
	
}

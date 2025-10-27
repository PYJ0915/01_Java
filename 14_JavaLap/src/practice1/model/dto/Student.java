package practice1.model.dto;

public class Student {

	private int studentNO;
	private String name;
	private String major;
	private double score;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int studentNO, String name, String major, double score) {
		super();
		this.studentNO = studentNO;
		this.name = name;
		this.major = major;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [studentNO=" + studentNO + ", name=" + name + ", major=" + major + ", score=" + score + "]";
	}
	
	

}

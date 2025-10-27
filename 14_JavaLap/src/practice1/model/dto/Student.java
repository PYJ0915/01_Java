package practice1.model.dto;

public class Student {

	private int studentNo;
	private String name;
	private String major;
	private double score;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int studentNO, String name, String major, double score) {
		super();
		this.studentNo = studentNO;
		this.name = name;
		this.major = major;
		this.score = score;
	}

	@Override
	public String toString() {
		return "학번: " + studentNo + " / " + "이름: " + name + " / " + "전공: " + major + " / " + "학점: " + score;
		
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNO(int studentNO) {
		this.studentNo = studentNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
	

}

package edu.kh.imsolo.model.dto;

public class DatePlan {

	private String applicant;
	private String respondent;
	private String date;
	private int love;
	
	public DatePlan() {
		// TODO Auto-generated constructor stub
	}

	public DatePlan(String applicant, String respondent, String date) {
		super();
		this.applicant = applicant;
		this.respondent = respondent;
		this.date = date;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getRespondent() {
		return respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

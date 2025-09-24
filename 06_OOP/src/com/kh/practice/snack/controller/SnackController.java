package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {

	private Snack snack = new Snack();
	
	public SnackController() {
		
	}
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		
		snack.setKind(kind);
		snack.setName(name);
		snack.setFlavor(flavor);
		snack.setNumOf(numOf);
		snack.setPrice(price);
		
		return "저장 완료 되었습니다.";
		
	}
	
	public String confirmData() {
		
		return snack.information();
	}
	
}

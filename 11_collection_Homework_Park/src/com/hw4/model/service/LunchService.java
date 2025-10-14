package com.hw4.model.service;

import java.util.ArrayList;
import java.util.List;

public class LunchService {

	
	public void lunch() {
		
		List<String> lunch = new ArrayList<String>();
		
		lunch.add("가쯔야(돈가스)"); 
		lunch.add("일일향(중국집)"); 
		lunch.add("다담(백반)"); 
		lunch.add("KFC, 롯데리아...");
		lunch.add("곰탕");
		lunch.add("김밥일번가");
		
		int random = (int)(Math.random() * 6);
		
		System.out.println(lunch.get(random));
		
	}
}

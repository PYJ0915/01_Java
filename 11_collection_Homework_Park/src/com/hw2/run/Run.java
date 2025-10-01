package com.hw2.run;

import com.hw2.model.dto.Animal;
import com.hw2.model.dto.Monkey;
import com.hw2.model.dto.Tiger;
import com.hw2.model.service.Zoo;

public class Run {
	
	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		
		Animal t = new Tiger("호랑이");
		Animal m = new Monkey("원숭이");
		
		zoo.addAnimal(t);
		
		zoo.addAnimal(m);
		
		zoo.displayMenu();
		
	
		
	}
}

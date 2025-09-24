package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class Heroservice {

	public void practice() {
		
		Hero h1 = new Hero("이구역짱", "전사", 200, 20, 1, 0);
		Hero h2 = new Hero("Zi존위자드", "마법사", 100, 100, 1, 0);
		
		System.out.println("============ 캐릭터 생성 ==============");
		System.out.println("전사 직업으로 '이구역짱'님이 생성되었습니다");
		System.out.println(h1.toString());
		System.out.println("============ 캐릭터 생성 ==============");
		System.out.println("마법사 직업으로 'Zi존위자드'님이 생성되었습니다");
		System.out.println(h2.toString());
		System.out.println("============ 이구역짱 시점 ============");
		h1.attack(100);
		h1.attack(50.5);
		h1.attack(49.5);
		h1.dash();
		h1.dash();
		h1.dash();
		System.out.println("============ 이구역짱 정보 ============");
		System.out.println(h1.toString());
		System.out.println("============ Zi존위자드 시점 ============");
		h2.attack(300);
		h2.dash();
		h2.attack(300);
		h2.attack(300);
		System.out.println("============ Zi존위자드 정보 ============");
		System.out.println(h2.toString());
	}
}

package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {

	private Scanner sc = new Scanner(System.in);
	
	private SnackController scr = new SnackController(); 
	
	public void menu() {
		System.out.println("스낵류을 입력하세요.");
		
		System.out.print("종류: ");
		String kind = sc.next();
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("맛: ");
		String flavor = sc.next();
		
		System.out.print("개수: ");
		int numOf = sc.nextInt();
		
		System.out.print("가격: ");
		int price = sc.nextInt();
		
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		
		
		System.out.print("저장한 정보를 확인하시겠습니까? (y/n): ");
		char answer = sc.next().charAt(0);
		
		
		
		if(answer == 'y' || answer == 'Y') {
			
			System.out.printf(scr.confirmData(), kind, name, flavor, numOf, price);
			
		} else if(answer == 'n' || answer == 'N') {
			
			
		} else {
			
			System.out.println("Y/N으로 다시 입력해주세요.");
			
		}
	}
	
}

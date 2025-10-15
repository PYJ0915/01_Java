package edu.kh.io.practice.model.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class PracticeService {

	public void ex1() {
		
		/* 사용자로부터 텍스트를 입력받아 "output.txt"라는 파일에 저장하는 프로그램을 작성하세요.
		  
		   요구 사항: 1. 텍스트 파일에 내용을 쓰는 데 FileWriter 클래스를 사용하세요.
					  2. "exit"을 입력하면 입력을 종료하고 파일을 닫도록 하세요.
		 */
		
		// 스트림 참조 변수 선언
		BufferedReader br = null;
		FileWriter fw = null;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			fw = new FileWriter("/io_practice/20251015/output.txt");
			
			while(true) {
			
				System.out.print("입력하고 싶은 내용을 입력하시오 (종료하고 싶으시다면 exit를 입력해주세요): ");
				String input = br.readLine();
				
				if(input.equals("exit")) {
					
					break;
					
				}
				
				fw.write(input + "\n");
				
			}
			
			fw.flush();
			
			System.out.println("출력 완료");
			
		} catch (Exception e) {
			
			e.printStackTrace();	
			
		} finally {
			
		try {
			
			if( br != null) br.close();
			if( fw != null) fw.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
			
		}
		
	}
	
	public void ex2() {
		
		File file = new File("C:/io_practice/20251015/input.txt");
		
		FileReader fr = null;
		int value = 0;
		StringBuilder sb  = new StringBuilder();
		
		try {
			
			if(!file.exists()) {
				
				file.createNewFile();
				
			}
			
			fr = new FileReader("C:/io_practice/20251015/input.txt");
			
			while(true) {
				
				value = fr.read();
				
				if(value == -1) {
					
					break;
					
				}
				
				sb.append((char)value);
				
			}
			
			if(sb.isEmpty()) {
				System.out.println("파일이 비어있습니다.");
				return;
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(fr != null) fr.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
		
	}
	
	public void ex3() {
		/*
		 * 문제 3: 파일 복사하기

			문제: "source.txt"라는 파일을 "destination.txt"라는 새로운 파일로 복사하는 프로그램을 작성하세요.

			요구 사항:

			FileInputStream과 FileOutputStream을 사용하여 파일을 복사하세요.

			복사 중 오류가 발생하면 예외를 처리하고, 복사 완료 후 "파일 복사가 완료되었습니다."라는 메시지를 출력하세요.*/
		
	}
	
}

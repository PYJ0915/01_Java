package edu.kh.io.pack2.run;

import edu.kh.io.pack2.model.service.ByteService;

public class ByteRun {

	public static void main(String[] args) {
		
		/*
		// 불변성(Immutable)의 String
		
		// 1. new 연산자
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(System.identityHashCode(str1)); // 681842940
		System.out.println(System.identityHashCode(str2)); // 1392838282
														   // -> 다른 객체!
		str1 += "world";
		System.out.println(System.identityHashCode(str1)); // 1706377736 <- 다른 객체 생성(불변성)
		
		// 2. 리터럴 표기법
		String str3 = "Hello";
		String str4 = "Hello";
		
		System.out.println(System.identityHashCode(str3)); // 523429237
		System.out.println(System.identityHashCode(str4)); // 523429237
														   // -> 같은 객체(String 상수 풀) 참조
		str3 += "world";
		System.out.println(System.identityHashCode(str3)); // 1804094807 <- 다른 객체 생성(불변성)
		
		// 가변성(Mutable)의 StringBuilder, StringBuffer
		StringBuilder sb = new StringBuilder();
		System.out.println(System.identityHashCode(sb)); // 951007336
		
		sb.append("너무 졸려");
		sb.append(" 집 가고 싶다");
		
		System.out.println(sb);
		
		System.out.println(System.identityHashCode(sb)); // 951007336 -> 원본과 주소가 같음(== 같은 객체) -> 가변성
		*/
		
		// new ByteService().fileByteOutput();
		new ByteService().bufferedFileByteOutput();
		
	}

}

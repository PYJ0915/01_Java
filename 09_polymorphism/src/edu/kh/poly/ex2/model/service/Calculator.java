package edu.kh.poly.ex2.model.service;

// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드와 기능명을 제공하는 접점(interface)의 용도
public interface Calculator {

	// 인터페이스 : 추상 클래스의 변형체(추상 클래스보다 추상도 높음)
	// - 추상 클래스 : 일부만 추상 메서드 (0개 이상)
	// - 인터페이스 : 모두 추상 메서드
	
	// 필드는 묵시적으로 public static final -> 상수
	// 속성(필드)
	public static final double PI = 3.14;
	static final int MAX_NUM = 100000;
	public int MIN_NUM = -100000;
	int ZERO = 0;
	// 4개 필드 모두 public static final
	
	
	// 기능
	// 메서드 묵시적으로 public abstract
	
	public abstract int plus(int num1, int num2);
	
	int minus(int num1, int num2);
	
	public int multiple(int num1, int num2);
	
	public abstract int divide(int num1, int num2);
}

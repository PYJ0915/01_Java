package edu.kh.exception.test;

public class ExcetionTest {

	public static void main(String[] args) {
		
		// 컴파일 에러 : 개발자가 코드 잘못 작성 시 발생
		// ex) int a = 99.9; <- Type mismatch: cannot convert from double to int
			   double a = 99.9; // 코드 수정으로 컴파일 에러 고칠 수 있음
		
			   
	    // 런타임 에러 : 프로그램 수행 중 발생하는 에러, 주로 if문으로 처리 가능
		int[] arr = new int[3]; // 길이 3 : 인덱스 0 ~ 2
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
	 //	arr[3] = 40;
		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3	
		// 배열 범위 초과 예외
		
		if( 3 >= arr.length ) { // 배열 범위를 초과한 값이 들어왔다면
			
			System.out.println("배열 범위를 초과했습니다.");
			
		} else { // 아니라면
			
			arr[3] = 40;
			System.out.println("배열 범위 굿");
			
		}
	}

}

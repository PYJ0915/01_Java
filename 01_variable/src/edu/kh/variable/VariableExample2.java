package edu.kh.variable;

public class VariableExample2 {
	
	public static void main(String[] args) {
		
		/* 자바의 기본 자료형 8가지
		 * 논리형 - boolean (1byte)
		 * 정수형 - byte (1byte) , short (2byte), int (4byte), long (8byte)
		 * 실수형 - float (4byte), double (8byte)
		 * 문자형 - char (2byte)
		 * 참조형 - 문자열 String
		 */
		
		// 변수의 선언 : 메모리(RAM)에 값을 저장할 공간을 할당하는 것
		// 변수 값 대입: 변수에 값을 집어 넣는 것 (== 초기화)
		
		boolean booleanData; // 변수의 선언 = 자료형 변수명;
		// 메모리에 논리값(T/F)을 저장할 공간을 1바이트 할당하고
		// 할당된 공간의 이름을 booleanData라고 정하겠다.
		
		booleanData = true; // booleanData 변수에 true 논리 값 대입
		// 값을 변수에 최초로 대입 == 초기화
		
		System.out.println("booleanData : "  + booleanData);
		
		byte byteData;
		// 메모리에 정수값을 저장할 공간을 1바이트 할당하고
		// 할당된 공간의 이름을 byteData라고 정하겠다.
		
		byte byteNumber = 127; // byte로 나타낼 수 있는 정수의 범위 (-128 ~ 127)
		// 변수의 선언과 동시에 대입(초기화)
		
		short shortNumber = 32767; // short로 나타낼 수 있는 정수의 범위 (-32768 ~ 32767)
		
		int intNumber = 2147483647; // int로 나타낼 수 있는 정수의 범위 (-2147483748 ~ 2147483647)
				
		// 리터럴 : 변수에 대입되거나 작성되어지는 값 자체
		// 자료형에 따라 리터럴 표기법이 다름
		long longNumber = 10000000000L;
		
		/* The literal 10000000000 of type int is out of range 
		 -> 100억이라는 값은 int의 범위를 벗어났다.
		 -> 리터럴 값 자체를 int로 인식하고 있다.
		 -> 왜? 우리가 int형 리터럴 표기법으로 100억을 나타냈기 때문이다.
		 -> 뒤에 L을 붙여줌으로써 long 자료형인 것을 나타내줌.
		*/
		
		float floatNumber = 1.2345F;
		/* 1.2345까지만 입력하면 double 자료형으로 인식하기 때문에
		   변수 타입인 float과 일치하지 않아 Type mismatch 에러 발생
		   -> float의 리터럴 표기법인 F를 붙여서 float 자료형임을 나타내줌.
		*/
		
		double doubleNumber = 3.141592;
		// double이 실수형 중에서 대표이기 때문에 리터럴 표기법이 없다면 double로 인식
		// D/d 를 사용할 수는 있음 Ex) double dounleNumber = 3.141592D;
		
		// 문자형(char) 리터럴 표기법 : '' (홑따옴표) 
		// -> 문자 하나
		char ch = 'A';
		char ch2 = 66;
		System.out.println("ch: " + ch);
		System.out.println("ch2: " + ch2);
		
		/* char 자료형에 숫자가 대입될 수 있는 이유!
		 * - 컴퓨터에는 문자표가 존재하고 있음
		 *   숫자에 따라 지정된 문자 모양이 각각 매핑되고
		 * 	 'B' 문자 그대로 대입되면 변수에 숫자 66으로 변환되어 저장
		 * 	 -> 반대로 생각하면 변수에 애초에 66이라는 숫자를 저장하는 것도 가능함	
		 */
		
		
		// 변수의 명명 규칙
		// 1. 대소문자 구분 O, 길이제한 X
		int abcdefg123456789;
		int abcdefG123456789; // g 와 G는 구분 되기 때문에 다른 저장공간으로 인식
		
		// 2. 예약어 사용 X
		// Ex) double final; <- 불가능
		
		// 3. 숫자로 시작 X (숫자 포함은 가능)
		// Ex) char 1abc; <- 불가능
		// 	   char abc1; <- 가능
		
		// 4. 특수문자는 $, _만 사용가능 (사용가능하지만 거의 사용 X)
		int $intNumber;
		int int_Number; // 자바에서는 카멜케이스를 사용하기 때문에 쓸 이유 X
		// _ 작성 표기법은 DB와 자바의 상수에서 주로 사용 
		
		// 5. 카멜 케이스 (맨 처음 소문자 시작, 후속 단어 첫 글자 대문자)
		char helloWorldAppleBananaTomato;
		
		// 6. 변수명은 언어를 가리지 않는다. (하지만 영어 외 문자는 거의 사용 X)
		int 정수1;
		double 실수2 = 3.141592653589793;
		System.out.println(실수2);
		
		int num = 10;
		System.out.println(num);
		
		num = 100;
		System.out.println(num);
		// 변수는 재대입 가능
		
		final double PI_VALUE = 3.141592653589793;
		
		// PI_VALUE = 2.23; // 에러 발생 -> 재대입 불가
		
		/* 상수 (항상 같은 수)
		 * - 변수의 한 종류
		 * - 한번 값이 대입되면 다른 값을 재대입 할 수 없음!
		 * - 자료형 앞에 final 키워드를 작성
		 * - 상수의 명명 규칙 : 모두 대문자, 단어 구분 시 _ 사용
		 * 
		 * - 상수를 사용하는 경우
		 * 1. 변하면 안되는 고정값을 저장할 때
		 * 2. 특정한 값에 의미를 부여할 때
		 */
		
		final int MIN_AGE = 1;
		final int MAX_AGE = 130;
		final int LEFT_MOVE = -1;
		final int RIGHT_MOVE = 1;
		
		
		
	}
}

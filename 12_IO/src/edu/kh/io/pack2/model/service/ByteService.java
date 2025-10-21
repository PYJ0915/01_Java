package edu.kh.io.pack2.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteService {

	/*
	 * 스트림(Stream): 데이터가 이동하는 통로, 기본적으로 한 방향으로 흐름
	 * 
	 * 바이트(Byte) 기반 스트림 - 1byte 단위로 데이터를 입/출력하는 스트림 - 최상위 클래스 : InputStream, OutputStream
	 * - 문자열, 이미지, 영상, 오디오, pdf 등 모든 것을 입/출력 할 수 있음 
	 * (단, 통로가 좁다보니 속도가 좀 느리며, 1byte 초과인 문자 같은 경우 깨질 우려 O)
	 */

	/**
	 * 바이트 기반 스트림을 이용한 파일 출력 + 데이터 출력
	 */
	public void fileByteOutput() {

		// FileOutputStream 참조변수 선언 (OutputStream을 상속받은 자식 클래스)
		FileOutputStream fos = null;

		try {
			// FileNotFoundException : 경로 상 파일을 찾을 수 없음

			// new FileOutputStream("경로") : 경로에 작성된 파일과 연결된 파일 출력 스트림 객체 생성
			// -> 출력스트림에 연결된 파일이 존재하지 않으면 자동 생성 단, 폴더는 자동생성 X (기존 파일 존재 시 내용 덮어쓰기)

			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트.txt"); // 해당 경로와 스트림을 연결

			// String의 불변성 문제를 해결한 객체 : StringBuilder(비동기), StringBuffer(동기)
			StringBuilder sb = new StringBuilder();
			sb.append("Hello World!!\n");
			sb.append("56165165\n");
			sb.append("!@#$%^&*()_+<>?\n");
			sb.append("가나다라바사");
			sb.append("와 자바 정말 재밌다\n");
			sb.append("선생님 저 공부 정말 열심히 할게요\n");
			sb.append("진짜로! 정말로! 화이팅!\n");

			// 출력 방법 1: 한 글자(2byte)씩 파일로 출력
			// StringBuilder -> String 변환 -> charAt() 메서드 이용 -> char 변환
			
			String content = sb.toString(); // String으로 변환
			
			/*
			  for(int i = 0; i < content.length(); i++) {
			 
			  char ch = content.charAt(i); 
			 
			  fos.write(ch);
			  
			  }
			 */

			// 출력 이전 수행시간 확인
			long startTime = System.nanoTime(); // 1970.01.01 오전 9:00부터 현재 시간까지의 차이를 ns(nano second)로 반환

			// 출력방법 2: String을 byte[] 배열로 변환 후 출력
			fos.write(content.getBytes()); // byte[]로 만들어 변환하고, 내부적으로 문자 인코딩을 적용하여 한글도 깨지지 않고 출력됨

			// 출력 이후 수행시간 확인
			long endTime = System.nanoTime();

			fos.flush(); // FileOutputStream에서는 권장사항
			// flush: 스트림 안에 남아있는 모든 데이터를 외부로 밀어냄

			System.out.println("[수행시간] : " + (endTime - startTime) + "ns"); // 66600ns

			System.out.println("출력 끝!");

		} catch (IOException e) {

			e.printStackTrace();

		} finally { // try 예외 발생 여부와 관계 없이 무조건 수행하는 구간
			// 사용 완료한 스트림을 제거(닫기, 메모리 반환)하는 코드 작성 -> 메모리 누수 방지

			try {
				// 스트림이 정상 생성된 경우 -> 스트림을 닫는다
				if (fos != null) {

					fos.close();
					// close() 메서드도 IOExceptoion을 발생 시키기 때문에 try-catch를 통한 예외 처리 필수
				}

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	/**
	 * 버퍼를 이용한 파일 출력 BufferedOutputStream 보조 스트림 이용
	 */
	public void bufferedFileByteOutput() {

		/*
		 * 버퍼(Buffer)란? - 데이터를 모아두는 공간, like 바구니같은 메모리 공간
		 * 
		 * BufferedOutputStream / BufferedinputStream 출력용 보조 스트림(바이트) / 입력용 보조 스트림(바이트)
		 * 
		 * - FileOutputStream은 1바이트씩 데이터를 입출력 -> 통로가 좁아 데이터 입출력 시 속도가 느림 -> 보조 스트림 이용 시
		 * 버퍼에 입출력할 내용을 모아서 한 번에 입출력 -> 기반 스트림(FileOutputStream)을 이용하는 횟수, 시간이 줄어듬 =>
		 * 성능, 시간 효율 향상
		 * 
		 */

		FileOutputStream fos = null; // 기반 스트림 참조변수 선언
		BufferedOutputStream bos = null; // 보조 스트림 참조변수 선언

		try {

			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트_buffered.txt");

			// 기반 스트림 fos를 이용해 보조스트림 bos 생성
			bos = new BufferedOutputStream(fos);

			StringBuilder sb = new StringBuilder();
			sb.append("Hello World!!\n");
			sb.append("56165165\n");
			sb.append("!@#$%^&*()_+<>?\n");
			sb.append("가나다라바사");
			sb.append("와 자바 정말 재밌다\n");
			sb.append("선생님 저 공부 정말 열심히 할게요\n");
			sb.append("진짜로! 정말로! 화이팅!\n");

			String content = sb.toString();

			long startTime = System.nanoTime();

			bos.write(content.getBytes());

			long endTime = System.nanoTime();

			bos.flush(); // 스트림 안에 남아있는 모든 데이터를 밀어냄
			// ** BufferedOutputStream 사용시 flush() 꼭 작성할 것!! **
			// 단, close() 시 버퍼에 있는 내용 모두 밀어내고 close 하기 때문에 close()가 있을 땐 권장사항

			System.out.println("[수행시간] : " + (endTime - startTime) + "ns"); // 35900ns

			System.out.println("출력 끝!");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				// if문 작성 시 null이 아닐 때를 때지는 이유
				// 스트림 객체 미생성 시 close() 구간에서 NullpointerException 발생 우려 있음! => 예외 처리
				if (bos != null) {
					bos.close(); // 보조스트림(bos) close() 시 보조스트림 생성에 사용된 기반스트림(fos)도 같이 close()됨
					// close() 시 버퍼에 남아있는 내용 모두 flush() 함
				}

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	/**
	 * 바이트 기반 파일 입력 - 외부 파일의 내용을 자바프로그램 내부로 읽어오기
	 */
	public void fileByteInput() {

		// 파일 입력용 바이트 기반 스트림 선언
		FileInputStream fis = null;

		try {
			
			fis = new FileInputStream("/io_test/20251014/노래가사.txt");
			// FileInputStream 이용 시 해당 경로에 반드시 실제 파일이 존재해야 함!
			// -> 존재하지 않는다면 FileNotFoundException 발생
			// -> :\io_test\20251014\노래가사.txt (지정된 파일을 찾을 수 없습니다.)
			
			
			
			// 방법 1. 파일 내부의 내용을 1byte씩 끊어서 가져오기
			// -> 2byte 이상 크기의 글자들은 깨지는 문제 발생!
			
			/*
			// byte -> 정수형이지만 다루기가 힘들어 대표 정수형인 int로 변환
			int value = 0; // 읽어온 바이트값을 저장할 변수
			
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				// 1byte씩 읽어오기
				value = fis.read();
				// 단, 더 이상 읽어올 값이 없다면 -1 반환
				
				if(value == -1) { // 다 읽어왔으면 반복 멈춤
					break;
				}
				
				sb.append( (char)value ); // char로 강제 형변환 후 문자 형태로 sb에 추가
				
			}
			
			System.out.println(sb.toString()); // 읽어온 내용을 콘솔에 출력
			*/
			
			// InputStream은 flush() 없음, 출력 스트림에만 관련된 동작!
			
			
			
			
			// 방법 2. 파일에 저장된 모든 byte값을 다 읽어와 byte[] 형태로 반환 받기
			// -> byte[] 배열 이용하여 String 객체 생성
			
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes);
			
			System.out.println(content);
			
			
			
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// 사용 완료된 Stream 메모리 반환
			if (fis != null) {

				try {
					
					fis.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}

			}
		}

	}
	
	/**
	 * BufferedInputStream 보조 스트림을 이용한 성능 향상
	 * 
	 * InputStream의 경우 외부 파일의 데이터를 읽어올 때 사용
	 * -> 읽어오는 파일 내부의 데이터가 크기가 작을 시 보조 스트림의 성능 이점이 크게 눈이 띄지 않음
	 */
	public void bufferedFileByteInput() {
		
		// 파일 입력용 바이트 기반 스트림 선언
		FileInputStream fis = null;
		
		// 파일 입력용 바이트 보조 스트림 선언
		BufferedInputStream bis = null;
		
		try {
			
			// 기반 스트림 생성
			fis = new FileInputStream("/io_test/20251014/노래가사_buffered.txt");
			
			// 보조 스트림 생성
			bis = new BufferedInputStream(fis);
			
			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes);
			
			System.out.println(content);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				// 보조 스트림만 close() 해도 기반 스트림도 같이 close() 됨
				if(bis != null) {
					
					bis.close();
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	/**
	 * 파일 복사
	 *
	 * 파일 경로를 입력받아
	 * 지정된 파일과 같은 경로에 복사된 파일 출력하기
	 *
	 * [실행화면]
	 * 파일 경로 입력 : /io_test/20251014/노래가사.txt
	 * 복사 완료 : /io_test/20251014/노래가사_copy.txt
	 *
	 * 1) 입력된 경로에 파일이 있는지 검사 
	 * 2) 있으면 파일 내용을 모두 읽어오기 : FileInputStream + BufferedInputStream
	 * 3) 읽어온 내용을 같은 경로 위치에 "파일명_copy.확장자" 이름으로 출력
	 *    : FileOutputStream + BufferedOutputStream
	 *   
	 * + Scanner 대신 BufferedReader(문자열 입력용 스트림) 이용
	 * -> BufferedReader는 보조스트림으로 단독사용 불가능!
	 * -> BufferedReader 생성 시 보조스트림인 InputStreamReader -> InputStream가 기반
	 */
	public void fileCopy() {
		
		// 스트림 참조변수들 선언
		
		BufferedReader br = null; // 문자열 입력용 스트림 (Scanner 대신)
		
		FileInputStream fis = null; // 파일 입력 기반 스트림
		BufferedInputStream bis = null; // 파일 입력 보조 스트림
		
		FileOutputStream fos = null; // 파일 출력 기반 스트림
		BufferedOutputStream bos = null; // 파일 출력 보조 스트림
		
		try {
			// 키보드 입력을 받기 위한 스트림 객체 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader도 보조스트림이기에 기반 역할 해줄 InputStreamReader 객체 생성!
			
			// 경로 입력 받기
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine(); // 입력된 한 줄 읽어오기
			// /io_test/20251014/노래가사.txt
			
			// 해당 경로에 파일이 존재하는지 확인
			File file = new File(target);
			
			if( !file.exists() ) { // 해당 경로에 파일이 존재하지 않는 경우
				
				// 프린트 구문 출력
				System.out.println("해당 경로에 파일이 존재하지 않습니다");
				return; // 파일이 존재하지 않을 시 해당 메서드 바로 종료
				
			}
			
			// 해당 경로에 파일이 존재하는 경우
			// target이 가리키는 파일을 입력 받을 수 있도록 입력용 스트림 생성
			
			fis = new FileInputStream(target);
			bis = new BufferedInputStream(fis);
			
			// 입력용 스트림을 이용하여 target 파일의 내용 입력받기
			byte[] bytes = bis.readAllBytes();
			
			// -------------------------------------------------------------
			
			// 출력할 파일의 경로 + _copy 가 붙은 파일 이름 
			// target : /io_test/20251014/노래가사.txt
			// copy : /io_test/20251014/노래가사_copy.txt
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(target);
			
			// int String lastIndexOf("문자열") 
			// -> 전달인자 문자열이 마지막으로 등장하는 인덱스를 값(int)을 반환 못찾으면 -1 반환
			
			int insertPoint = target.lastIndexOf(".");
			
			sb.insert(insertPoint, "_copy"); // "."의 인덱스 자리에 _copy 삽입
			// "/io_test/20251014/노래가사_copy.txt"
			
			// 출력용 스트림 생성
			fos = new FileOutputStream(sb.toString());
			bos = new BufferedOutputStream(fos);
			
			// 원본에서 읽어온 내용을 bos를 이용해서 출력(쓰기)
			
			bos.write(bytes);
			bos.flush(); // 스트림에 있는 데이터 모두 밀어내기
			
			System.out.println("복사 완료: " + sb.toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				if(br != null) br.close();
				
				if(bis != null) bis.close();
				
				if(bos != null) bos.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		
		
	}
	

}

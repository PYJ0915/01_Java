package edu.kh.io.pack2.model.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteService {

	/*
	 * 스트림(Stream): 데이터가 이동하는 통로, 기본적으로 한 방향으로 흐름
	 * 
	 * 바이트(Byte) 기반 스트림 - 1byte 단위로 데이터를 입/출력하는 스트림 - 최상위 클래스 : InpurStream,
	 * OutputStream - 문자열, 이미지, 영상, 오디오, pdf 등 모든 것을 입/출력 할 수 있음 (단, 통로가 좁다보니 속도가 좀
	 * 느리며, 1byte 초과인 문자 같은 경우 깨질 우려 O)
	 * 
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
			String content = sb.toString();
			/*
			 * for(int i = 0; i < content.length(); i++) {
			 * 
			 * char ch = content.charAt(i); 
			 * fos.write(ch);
			 * 
			 * }
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

}

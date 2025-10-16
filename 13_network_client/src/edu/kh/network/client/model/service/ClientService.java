package edu.kh.network.client.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientService {

	public void clientStart() {
		
		// 1) 현재 컴퓨터의 로컬 IP 주소를 얻어오는 방법
		// String serverIP = InetAddress.getLocalHost().getHostAddress();
		
		// 2) "127.0.0.1" => loop back IP (현재 컴퓨터의 IP를 나타냄)
		String serverIP = "127.0.0.1";
		
		// ex) 서버 컴퓨터의 IP 주소 : 198.50.212.22
		// String serverIP = "198.50.212.22"
		// 서버가 다른 컴퓨터일 때는 서버 컴퓨터의 IP 주소를 입력해야함
		// 지금은 한 대의 컴퓨터로 서버와 클라이언트를 모두 사용 중이기 때문에 IP 주소가 같음
		
		int port = 8500;
		
		// 소켓/스트림 참조변수 선언
		
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			System.out.println("[Client]");
			
			// 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			clientSocket = new Socket(serverIP, port);
			// 서버의 IP 주소와 포트를 통해 클라이언트 소켓 생성 시 해당 서버에 접속 요청함
			
			
			if(clientSocket != null) { // 서버와 연결에 성공한 경우
				
				// 2. 서버와의 입출력 스트림 오픈
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
						
				// 3. 보조 스트림을 통해 성능 개선
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				// 4. 스트림을 통해 읽고 쓰기
				// 서버에서 보낸 날짜메세지를 읽어와 콘솔 창에 출력 => 읽기(입력)
				
				String serverMessage = br.readLine();
				
				System.out.println(serverMessage);
				
				// ------------------------------------------------------------------------
				
				// 클라이언트 -> 서버로 메세지 전송(출력)
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메세지: ");
				String clientMessage = sc.nextLine();
				
				pw.println(clientMessage); // 메세지를 출력스트림 이용하여 클라이언트에서 서버쪽으로 출력
				pw.flush();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			// 5. 통신 종료
			
			try {
				
				if(br != null) br.close();
				if(pw != null) pw.close();
				
				if(clientSocket != null) clientSocket.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
		
		
		
		

		
		
	}
	
}

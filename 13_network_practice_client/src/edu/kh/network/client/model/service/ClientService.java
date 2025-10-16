package edu.kh.network.client.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientService {

	/*
	1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
	2. 서버와의 입출력 스트림 오픈
	3. 보조 스트림을 통해 성능 개선
	4. 스트림을 통해 읽고 쓰기
	5. 통신 종료
	*/
	
	public void clientStart() {
		
		String serverIP = "127.0.0.1";
		int port = 4290;
		
		Socket clientSocket = null;

		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			System.out.println("[Client]");
			
			clientSocket = new Socket(serverIP, port);
			
			if(clientSocket != null) {
				
				
				System.out.println("서버 접속 완료");
				
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				
			}
			
		} catch (Exception e) {
			
			 e.printStackTrace();
			 
		} finally {
			
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

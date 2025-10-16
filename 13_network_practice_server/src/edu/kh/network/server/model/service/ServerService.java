package edu.kh.network.server.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService {

	/*
	 
	실습 문제: 채팅 프로그램 만들기

	서버와 클라이언트가 서로 메시지를 주고받을 수 있는 간단한 채팅 프로그램을 작성해 보세요.

	요구사항:

	서버는 클라이언트의 연결을 기다리고, 연결이 이루어지면 클라이언트와 메시지를 주고받습니다.

	클라이언트는 서버에 연결한 후, 서버가 보낸 메시지를 출력하고, 클라이언트에서 서버로 메시지를 전송합니다.

	서버와 클라이언트는 메시지를 주고받을 때, 메시지에 타임스탬프를 추가합니다.

	클라이언트가 **"exit"**를 입력하면, 서버와의 연결을 종료하고 프로그램을 종료합니다.

	추가 설명 :
	
	타임스탬프: 서버나 클라이언트가 메시지를 보내면 그 메시지 앞에 현재 시간을 추가해야 합니다. 예를 들어, "2025년 10월 16일 10:39:55 [서버 메시지]".
	
	예시 동작:

	서버 실행:
	Server started. Waiting for clients...

	클라이언트 실행:
	Client connected to server.

	서버에서 메시지 전송:
	2025년 10월 16일 10:39:55 [서버 메시지: Hello from the server!]

	클라이언트에서 메시지 전송:
	2025년 10월 16일 10:40:05 [클라이언트 메시지: Hello from client!]

	클라이언트가 "exit" 입력:
	Client disconnected. Exiting...

	*/
	
	public void serverStart() {
		
		int port = 4290;
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			/*
			  1. 서버의 포트번호 정함
			  2. 서버용 소켓 객체 생성
			  3. 클라이언트 쪽에서 접속 요청이 오길 기다림
		      4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			  5. 연결된 클라이언트와 입출력 스트림 생성
			  6. 보조 스트림을 통해 성능 개선
			  7. 스트림을 통해 읽고 쓰기
			  8. 통신 종료
			 */
			
			serverSocket = new ServerSocket(port);
			
			System.out.println("[Server]");
			System.out.println("클라이언트 대기중...");
			
			clientSocket = serverSocket.accept();
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			System.out.println("클라이언트 접속 성공");
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(br != null) br.close();
				if(pw != null) pw.close();
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	
	
	
}

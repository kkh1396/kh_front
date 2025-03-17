package com.kh.thread.chat;

import java.io.IOException;
import java.net.Socket;

public class TCPClient  {

	public static void main(String[] args) {
		// 1) 서버의 IP주소, 포트번호 확인 => localhost, 7979
		// 2) Socket 객체 생성 (=> 서버 정보 전달)
		try {
			Socket socket = new Socket("192.168.10.9", 7979);
			
			if (socket != null) {
				// 3) 스트림 생성 후 데이터 통신 
				
				
				
				// Thread 클래스 상속받는 방법**
				// * 서버로부터 메시지를 받는 쓰레드
				
				ClientReciver cr = new ClientReciver(socket);
				cr.start();
				
				// * 서버로 메시지를 보내는 쓰레드 
				
				ClientSender cs = new ClientSender(socket);
				cs.start();
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}

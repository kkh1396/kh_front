package com.kh.network;

import com.kh.network.inet.InetTest;

public class Run {

	/*
	 *  * 네트워크 : 여러 대의 컴퓨터들이 연결되어 있는 통신망
	 *   		  = 네트워크를 통해서 서로 데이터를 주고받기 위해 사용
	 *   
	 *   - IP 주소 : 네트워크 상의 노드들을 식별해줄 번호
	 *   - 포트번호 : 한 컴퓨터 내에서 프로그램들을 식별해주는 번호
	 *   
	 *   서버와 클라이언트 : 역할을 구분한 것!
	 *    서버 : 클라이언트 요청을 받아 응답을 해주는 역할
	 *    클라이언트 : 서버에 요청을 하고 받는 역할
	 *    => 서버에 요청하기 위해서 서버의 IP주소(도메인), 포트번호를 알아야 함!!
	 *    웹에서의 통신방식은 HTTP 프로토콜 사용!
	 *    
	 *    - 소켓 프로그래밍 (TCP 방식/UDP 방식)
	 *    * TCP 방식 : 데이터를 정확하고 안정적으로 전달해야할 떄 사용
	 *    			  데이터 전송속도가 느림!
	 *    * UDP 방식: 신뢰성이 없는 데이터를 전달할 떄 사용
	 *    			 데이터 전송속도가 빠름!
	 */  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InetTest it = new InetTest();

		it.test();
	}

}

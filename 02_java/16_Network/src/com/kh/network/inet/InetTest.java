package com.kh.network.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
  
	 public void test() {
		 //InetAddress : Ip주소 관련 정보를 확인할수 있는 클래스
		 
		 // * 내 PC에 대한 정보 확인
		 
		 try {
		  InetAddress localhost = InetAddress.getLocalHost();
//		  System.out.println(localhost);
		  
		  System.out.println("내 PC정보 : " + localhost.getHostName());
		  System.out.println("내 IP정보 : " + localhost.getHostAddress());
		  
		  
		  System.out.println("==================================");
		  
		  // 도메인을 통해서 서버 정보를 확인
		  InetAddress google = InetAddress.getByName("www.google.com");
		  
		  System.out.println("구글 서버명 : " + google.getHostName());
		  System.out.println("구글 주소 : " + google.getHostAddress());
		  
		  
		  System.out.println("==================================");
		   InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
		   
		   System.out.println("네이버 호스트 개수 : " + naver.length);
		   
		   for (InetAddress s : naver) {
			   System.out.println("네이버 호스트명 : " + s.getHostName());
			   System.out.println("네이버 주소 : " + s.getHostAddress());
			   
		   }
		  
		 }catch(UnknownHostException e) {
			 e.printStackTrace();
		 }
	 }
}

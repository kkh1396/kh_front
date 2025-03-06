package com.kh.last.p7;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 try {
			 Scanner sc = new Scanner(System.in);
			 System.out.print("호스트명: ");
			 String dns = sc.nextLine();
			 
			 InetAddress[] localhost = InetAddress.getAllByName(dns);
			 
			 System.out.println(dns+"는"+localhost.length+"개의 IP주소를 가지고 있습니다.");
			 int i=1;
			 for (InetAddress s : localhost) {
			  System.out.println(i+"번 " + s.getHostAddress());
			  i++;
			 }
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

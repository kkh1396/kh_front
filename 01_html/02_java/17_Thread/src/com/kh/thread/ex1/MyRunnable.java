package com.kh.thread.ex1;

// * Runnable 인터페이스 구현(상속)
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		int n1 = 10;
		int n2 = 7;
		
		// * 현재 스레드 정보 : Thread.currentThread()
		String name = Thread.currentThread().getName();
		System.out.println(name + ":" + (n1+n2));
		
	}

	
	
}

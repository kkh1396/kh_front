package com.kh.thread.ex1;

public class Run {

	
	/*
	 * 쓰레드(Thread) : 프로그램 내에서 실행 흐름 가지고 있는 최소 작업 단위
	 * - main 메소드 실행 시 메인쓰레드가 실행됨
	 * 
	 */
	public static void main(String[] args) {
		// 쓰레드 생성 (1) : Thread 클래스를 상속받아 생성
		//					=> Task 클래스로 정의
		Task t1 = new Task();
		
		
		// 쓰레드 생성 (2) : Runnable 인터페이스를 구현하여 생성
		Runnable task = new MyRunnable();
		Thread t2 = new Thread(task);
		
		Runnable task2 = () -> {
			String name = Thread.currentThread().getName();
			
			System.out.println(name + ":: 람다식으로 작성한 스레드");
		};
		Thread t3 = new Thread(task2);
		
		
		t1.start();
		t2.start();
		t3.start();
		
		
		String name = Thread.currentThread().getName();
		System.out.println(name + ":" + "End =========");
		

	}

}

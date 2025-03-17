package com.kh.thread.ex2;

//Thread1 : 20미만의 짝수 출력 (0.2초 동안 대기)
public class Task1 extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 1; i < 20; i++) {
				if (i % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + "::" + i);
				}
				Thread.sleep(500); // 0.2초 동안 현재 스레드를 재운다.(대기)
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

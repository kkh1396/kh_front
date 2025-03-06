package com.kh.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender extends Thread {

	private Socket socket;

	public ClientSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		// Socket 객체로부터 출력용 스트림 생성
		try (PrintWriter pw = new PrintWriter(socket.getOutputStream());) {
			Scanner sc = new Scanner(System.in);

			while (true) {
				String message = sc.nextLine();
				pw.println(message);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

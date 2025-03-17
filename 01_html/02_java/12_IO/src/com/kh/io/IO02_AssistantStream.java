package com.kh.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IO02_AssistantStream {
	/*
	 * * 보조 스트림 : 기반 스트림만으로 부족한 성능을 향상시켜주는 스트림(보조해줌!) 기반 스트림에서 제공하지 않는 추가적인 메소드를 가짐
	 * => 데이터 전송 속도 외부 매체와 직접적으로 연결되지 않기 때문에 단독 사용 불가!! => 반드시 기반 스트림과 함께 사용!
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		fileSave();
//		fileRead();
		objectSave();
		objectRead();
	}

	// 파일 --> 프로그램 : 입력. 객체에 저장된 데이터
	public static void objectRead() {
		// FileInputStream : 기반스트림
		// ObjectInputStream : 보조스트림
		
		try (ObjectInputStream ois = new ObjectInputStream(
										new FileInputStream("myProducts.txt"));){
			
//			System.out.println( ois.readObject() );
//			System.out.println( ois.readObject() );
//			System.out.println( ois.readObject() );
	

			while (true) {
			System.out.println( ois.readObject() );
			}
		} catch (EOFException e) {
			System.out.println("파일데이터 모두 입력 완료!!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	// 프로그램 --> 파일 : 출력. 객체에 저장된 데이터
	
	public static void objectSave() {
		  //출력할 데이터
		  Product p1 = new Product("텀블러", 10000);
		  Product p2 = new Product("마우스", 30000);
		  Product p3 = new Product("노트", 5500);
		  
		  // FileOutputStream : 기반스트림 . 1바이트 단위로 파일에 출력하는 스트림.
		  // objectOutputStream : 보조스트림. 객체 단위로 출력을 도와주는 스트림.
		  
		  try (ObjectOutputStream oos = new ObjectOutputStream(
				  						new FileOutputStream("myProducts.txt"));){
			  
			  oos.writeObject(p1);
			  oos.writeObject(p2);
			  oos.writeObject(p3);
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
	}
	
	
    // 파일 ------> 프로그램 : 입력
	public static void fileRead() {
		 // FileReader : 기반스트림, 파일에 직접 연결하여 2바이트씩 데이터를 입력받을 수 있는 스트림.
		 // BufferedReader : 한 줄씩 데이터를 읽어오도록 도와주는 보조 스트림
		System.out.println("================= fileRead Start=================");
		
		try (BufferedReader br = new BufferedReader(
							new FileReader("as_test.txt"));){
//		FileReader s1 = new FileReader("as_text.txt");
//		BufferedReader br = new BufferedReader(s1);
		
		
			
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			// => 읽어 올 내용이 없을 땐 null 값으로 출력!
			
			String data = null;
			while ((data = br.readLine()) != null ) {
				System.out.println(data);
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("파일에 없습니다.");
			System.out.println(e.getMessage());
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	// 프로그램 ---> 파일 : 출력
	public static void fileSave() {
		// FileWriter : 기반스트림. 파일을 직접적으로 연결하여 2바이트씩 출력하는 스트림.
		// BufferdWriter : 속도 향상을 도와주는 스트림
//
		
		System.out.println("================= fileSave Start=================");
		// try with resources 구문 : 자원을 알아서 해제(반납)해주는 문법
		try (BufferedWriter bw = new BufferedWriter(
									new FileWriter("as_test.txt")
									)){
//		try {
//			// 1. 기반스트림 생성
//			FileWriter fw = new FileWriter("as_test.txt");
//
//			// 2. 보조스트림 => 기반스트림 객체를 전달
//			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("기반스트림 사용!!\n");
			bw.write("반가워요 ~~");
			bw.newLine();
			bw.write("여기까지 작성 끝!");

			bw.flush();

//			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

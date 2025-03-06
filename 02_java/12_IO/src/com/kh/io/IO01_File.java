package com.kh.io;

import java.io.File;
import java.io.IOException;

public class IO01_File {

	
	public static void main(String[] args) {
//		fileTest1();
		fileTest2();
	}
	
	public static void fileTest2() {
		// * sample 폴더 생성 후 myDiary.txt 파일을 만들어보자
		
		
		// sample 폴더에 대한 File 객체 생성
		 File folder =new File("sample");
		 
		 // sample이라는 폴더가 존재하는지 확인
		 if (!folder.exists()) {
			 //존재하지 않을 경우 폴더 생성
			 folder.mkdir();
		 }
		 
		 // sample 폴더에 myDiary.txt 파일 객체 생성
		 File file = new File("sample\\myDiary.txt");
		 
		 try {
		 // myDiary.txt 파일이 존재하는지 확인
		 if (!file.exists()) {
			  //파일이 존재하지 않으면 파일 생성
			  file.createNewFile();
		 	}
		 
		 
		 // * 파일 객체로부터 파일 정보 얻기
		 System.out.println("파일명 : " + file.getName());
		 System.out.println("파일경로 : " + file.getAbsolutePath());
		 System.out.println("파일용량 : " + file.length());
		 System.out.println("파일상위폴더 : " + file.getParent());
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		
		
		
		/* 내가 작성한 코드 */
//		File s1 = new File("sample\\myDiary.txt");
//		File s1_folder = new File("sample");
//		
//		try {
//		s1_folder.mkdir();
//		s1.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public static void fileTest1() {
		// File 객체 생성 => new File("파일명");
		
		// [1] 파일명만 전달하여 생성
		File f1 = new File("test1.txt");
		// > 파일 객체를 생성한 상태 (실제  파일을 생성되지 않음!)
		
		// [2] 실제로 존재하는 폴더경로+파일명 전달하여 생성
		// >> D:\\test2.txt
		File f2 = new File("D:\\test2.txt");
	
		// [3] 존재하지 않는 폴더 경로+파일명 전달하여 생성
		File f3 = new File("D:\\tmp\\test3.txt");
		// => 존재하지 않는 폴더에는 파일 생성 불가!
		File f3_folder = new File("D:\\tmp");
		//
		
		File f4 = new File("test4.txt");
		
		
		
		// File객체명.createNewFile(); // => 실제 파일을 만들어주는 메소드
		try {
			f1.createNewFile();
			 f2.createNewFile();
//			 f3.createNewFile();
			 // *폴더 생성 : File객체명.mkdir()
			 f3_folder.mkdir();
			 f3.createNewFile();
			 
			 // * 파일이 존재하는지 확인 메소드 : exists() : boolean
			 System.out.println("f1 파일이 존재하는가? " + f1.exists());
			 System.out.println("f4 파일이 존재하는가? " + f4.exists());
			 
			 System.out.println();
			 // * 파일인지 확인하는 메소드 => isFile():boolean
			 System.out.println("f1은 파일인가? " + f1.isFile());
			 System.out.println("f3_folder는 파일인가? " + f3_folder.isFile());
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

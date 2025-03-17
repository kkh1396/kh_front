package com.kh.practice.file.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {

	public boolean checkName(String file) {
		/*
		 *  존재하는 파일이 있는지 확인 후 반환
		 *  @param file 파일명
		 *  @return 존재하는 파일인지 여부(boolean)
		 */
		
		File f1 = new File(file);
		return f1.exists();
	}
	
	/*
	 *  매개변수로 받은 파일명에 문자열 저장
	 *  @param file 파일명
	 *  @return s 저장할 내용
	 */
	
	public void fileSave(String file, String s) {
		
		try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(file) );){
			
			bw.write(s);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 *  매개변수로 받은 파일 명을 이용하여 저장 되어 데이터 반환 (입력)
	 *  @param file 파일명
	 *  @return 파일 내용(String)
	 */
	
	public String fileOpen(String file) {
		String content = "";       // 파일 전체 데이터를 저장하는 변수
		try(BufferedReader br = new BufferedReader(
									new FileReader(file));){
			
			String data = null;	   // 한줄한줄 읽어와서 저장하는 변수
			while ((data = br.readLine()) != null) {
				  content += data;
				
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	/*
	 *  매개변수로 받은 파일 명을 문자열 저장 (기존 내용에 이어서 저장,출력)
	 *  @param file 파일명
	 *  @return s 추가할 내용
	 */
	
	public void fileEdit(String file, String s) {
		
		try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(file,true));){
			
			bw.write(s);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

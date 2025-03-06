package com.kh.api;

public class Mrun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			MyArray mArr = new MyArray(5);
			

			mArr.add("문자열 데이터");
			mArr.add(1000);
			
			
			MyArray<String> sArr = new MyArray<>(5);
			MyArray<Integer> iArr = new MyArray<>(5);
			

			for(int i=0; i<(int)mArr.size(); i++) {
				System.out.println(mArr.get(i));
			}
		
		} catch (MyException e) {
			System.out.println("오류 발생#################");
			e.printStackTrace();
		}		

	}
}

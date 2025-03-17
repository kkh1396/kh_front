package com.kh.object.practice6.model.run;

import com.kh.object.practice6.model.vo.*;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book b1 = new Book();
		
		b1.inform("집에가는법", "교보문구", "홍길동");
		System.out.println();
		b1.inform("집에가는법", "교보문구", "홍길동",20000,30);
	}

}

package com.kh.run;

import com.kh.common.JDBCTemplate;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JDBCTemplate
		
		JDBCTemplate.createPropperties();
		JDBCTemplate.createXml();
		JDBCTemplate.conn();
	}

}

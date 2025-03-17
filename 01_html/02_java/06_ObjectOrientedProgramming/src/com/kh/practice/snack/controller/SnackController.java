package com.kh.practice.snack.controller;
 
import com.kh.practice.snack.model.vo.*;

public class SnackController {

	private Snack s = new Snack();
	public SnackController(){}
	
	public String saveData(String kind, String name, String flavor, int numOF, int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOF(numOF);
		s.setPrice(price);
		// 저장 완료 메시지 
		return "저장 완료";
		
	}
	
	public String confirmData() {
		String data = s.information();
		return 	data;
		
	}
}

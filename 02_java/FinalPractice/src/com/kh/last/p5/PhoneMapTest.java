package com.kh.last.p5;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Phone> map = new HashMap<String, Phone>();
		
		Phone samsung = new Phone("galaxy S7",563500,"삼성",7);
		Phone apple = new Phone("iphone 6s",840000,"애플",3);
		Phone lg = new Phone("G5",563500,"LG",5);
		
		
		map.put(samsung.getModel(), samsung);
		map.put(apple.getModel(), apple);
		map.put(lg.getModel(), lg);
		
		Set<Entry<String, Phone>> entrySet = map.entrySet();
		Iterator<Entry<String, Phone>> it = entrySet.iterator();
		
		while(it.hasNext()) {
			Entry<String, Phone> entry = it.next();
			
			String key = entry.getKey();
			Phone value = entry.getValue();
			
			System.out.println(key + " : " + value);

		}
		
		// 맵에 저장된 객체 정보를 Properties를 사용해 "phone.xml"파일에 기록 저장한다.
		
		Properties prop = new Properties();
		
		// * 맵에서 키 목록 조회 => keyset():Set<K>
		Set<String> keyList = map.keySet();
		for (String key : map.keySet()) {
			
			prop.setProperty(key, map.get(key).toString());
			// Map의 데이터를 Properties로 복사
			// => map.put()과 유사한 메소드
		}
		
		// "phone.xml" 파일에 기록 저장한다.
		try {
			prop.storeToXML(new FileOutputStream("phone.xml"), "phone 정보");
			// store => 파일(외부매체)에 출력
			// load => 파일(외부매체)로부터 입력
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		map.put("galaxy S7", samsung);
//		map.put("iphone 6s", apple);
//		map.put("G5", lg);
//		
		
//		for (Map.Entry<String, Phone> entry : map.entrySet())
//		{
//		    System.out.println( entry.getKey() + " : " + entry.getValue());
//		}
//		
//		Properties pp = new Properties();
		
		
	}

}

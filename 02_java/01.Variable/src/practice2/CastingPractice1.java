package practice2;


import java.util.Scanner;

public class CastingPractice1 {

	
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in) ;
	
		System.out.print("문자를 입력하세요 : "); // "문자 : 내용을 콘솔창에 출력"
		String k = sc.next(); 				// 문자열을 입력받아 in이라는 변수에 저장
		
		// 문자(char) -> 정수(int)
		char i = k.charAt(0); // 문자열변수 in에 저장된 값 중 첫번쨰 위치의 글자를 추출...
		
		
		
		
		System.out.printf("%s의 유니코드는 %s입니다.",k,i);
		
		// "{입력받은값} unicode : " {정수값} 형식으로 출력
		// println 메소드
		
		 System.out.println(i + " unicode :" + (int)i);
		// printf 메소드
		 System.out.printf("%c unicode : %d",i,(int)i);
		
		
	}
}

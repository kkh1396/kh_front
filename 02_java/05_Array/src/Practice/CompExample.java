package Practice;

import java.util.Scanner;

public class CompExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
//		method9();
//		method10();
//		method11();
//		method12();
		method13();
	}
	
	public static void method13() {
		
		int[] Rarr = new int[10];
		int i = 0;
		while (i<Rarr.length) {
			
			int ran = (int)(Math.random()*10 +1);
			Rarr[i] = ran;
			
			for(int j=0; i<Rarr.length; j++) {
				
			}
			
			i++;
			
			
			
		}
		
		
//		for (int i=0; i<Rarr.length;i++) {
//			int ran = (int)(Math.random()*10 +1);
//			Rarr[i] = ran;
//			System.out.print(Rarr[i]+ " ");
//		}

		
		
	}
	
	
	public static void method12() {

		int[] Rarr = new int[10];
		int max = 0;
		int min = Rarr.length;
		
		for (int i=0; i<Rarr.length;i++) {
			int ran = (int)(Math.random()*10 +1);
			Rarr[i] = ran;
			max = Math.max(max, Rarr[i]);
			min = Math.min(min, Rarr[i]); 
			System.out.print(Rarr[i]+ " ");
		}
		System.out.println(" ");
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}
	
	public static void method11() {
	
		int[] Rarr = new int[10];
		
		for (int i=0; i<Rarr.length;i++) {
			int ran = (int)(Math.random()*10 +1);
			Rarr[i] = ran;
			System.out.print(Rarr[i]+ " ");
		}
	}
	
	
	public static void method10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String myNumber = sc.nextLine();
		
		char[] chmyNumber = new char[myNumber.length()];
		char[] chmyNumber1 = new char[chmyNumber.length];
		
//		System.out.println(chmyNumber.hashCode());
//		System.out.println(chmyNumber1.hashCode());
		
		for (int i=0; i<chmyNumber.length;i++) {
			chmyNumber[i] = myNumber.charAt(i);
			chmyNumber1[i] = chmyNumber[i];
		}
		
		for (int j=0; j<chmyNumber1.length;j++) {
			
			if ( j <= 7 ) {
				System.out.print(chmyNumber1[j]);
				
			} else {
				System.out.print("*");
			}
		}
		
		
		
		
		
	}
	
	public static void method9() { 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 : ");
		String str = sc.nextLine();
		
		String[] menu = new String[] {"후라이드","양념","간장","파닭" };
		
		int j= 0;
		for (int i=0; i<menu.length; i++) {
			
			if (menu[i].equals(str)) {
				j=i;
			}
			
		}
		
		if (menu[j].equals(str)) {
			System.out.printf("%s 배달 가능",menu[j]);
		} else {
			System.out.printf("%s 배달 불가",str);
		}
		
		
	}
	
	public static void method8() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		System.out.print("정수 : ");
		int num = sc.nextInt();	
		int[] sum = new int[num];
			
		if (num%2!=0 && num > 3) {
			for (int i =0; i<num; i++) {
				
				if (i<(num/2)) {
					sum[i]=i+1;
					System.out.print(sum[i]+" ");
				} else {
					sum[i]=num-i;
					System.out.print(num-i+ " ");
				}
				
			}
				break;
		} else {
			System.out.println("다시 입력하세요.");
		 }
		 
	  }
	}
	
	public static void method7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();

		int[] Narr = new int[num];
		int sum = 0;
		for (int i=0; i<num; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 :",i);
			Narr[i] = sc.nextInt();
			sum += Narr[i];
		}
		for (int j=0; j<num; j++ ) {
			System.out.print(Narr[j]+" ");
		}
		
		System.out.println();
		System.out.print("총합 : " + sum);
		
		
	}
	
	public static void method6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		char[] day = new char[]{'월','화','수','목','금','토','일'};
			
			if (num >=0 && num <= 6) {
				System.out.printf("%s요일 \n",day[num]);
			}else {
				System.out.print("잘못 입력하셨습니다.");
			}	
	}
	
	public static void method5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열");
		String str1 = sc.nextLine();
		System.out.print("문자");
		char ch = sc.next().charAt(0);
		
		char[] strch = new char[str1.length()];
		
		String num =" " ;
		int num1 = 0 ;
		for (int i=0; i<str1.length(); i++) {
			strch[i] +=  str1.charAt(i);
//			System.out.print(strch[i]+" ");	
				
			if ( strch[i] == ch ) {
				num += i + " ";  
				num1++;
			}
		}	
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : %s \n",str1,ch,num);
		System.out.printf("%c 개수 : %d",ch,num1);
		
		
		
			
	}
	
	public static void method4() {
		
		String[] fruit = {"사과","귤", "포도", "복숭아", "참외"};
		
		System.out.print(fruit[1]);
		
		
		
		
	}
	
	public static void method3() {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수");
		int num = sc.nextInt();
		
		int[] arr = new int[num];		
		for (int i=0; i<num; i++) {
				arr[i] = i + 1;
			    System.out.print(arr[i]+ " ");			
		}
	}
	
	public static void method2() {
		int[] arr = new int[10];
		
		for (int i=0; i<arr.length; i++) {
			    int j = arr.length;
				arr[i] = j - i;
			    
			    System.out.print(arr[i]+ " ");
			
		}
		
	}
	
	public static void method1() {
		
		int[] arr = new int[10];
		
		for (int i=0; i < arr.length; i++) {
			arr[i] = i +1 ;
			System.out.print(arr[i]+ " ");
		}
	}

}

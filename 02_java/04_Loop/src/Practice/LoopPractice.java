package Practice;

import java.util.Scanner;

public class LoopPractice {

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
//		method13();
		method14(); //
		
	}
	
	
	public static void  method14() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int num = sc.nextInt();
		
		
//		String sum = "";
//		for (int i=1; i<=num; i++) {
//			sum += "*";
//		}
//		
//		for (int i=1; i<=num; num--) {
//			sum = sum.substring(0,num);
//			System.out.println(sum);
//		}
		
		
		for (int i=1; i<=num; num--) {
			  for(int j=1; j<=num; j++) {
				  System.out.print("*");
			  }
			  System.out.println();

		}
		
	}
		
		
	
	
	public static void  method13() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int num = sc.nextInt();
		
//		String sum = "";
//		for (int i=1; i<=num; i++) {
//			sum += "*";
//			System.out.println(sum);
//		}
		
		for (int i=1; i<=num; i++) {
			  for(int j=1; j<=i; j++) {
				  System.out.print("*");
			  }
			  System.out.println();

		}
		
	}
	
	
public static void  method12() {
		
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		while (run) {

			System.out.print("연산자(+, -, *, /, %) : ");
			
			String ja = sc.next();
			char ja1 =  ja.charAt(0);
			
			if (ja.equals("exit")) {
				System.out.print("프로그램을 종료합니다.");
				break;
			} else {

					System.out.print("정수1 :");
					int num1 = sc.nextInt();
					System.out.print("정수2 :");
					int num2 = sc.nextInt();
			
						switch (ja1) {
							case '+':
//							case "+":
									int num3 = num1 + num2;
									System.out.printf("%d %c %d = %d \n",num1,ja1,num2,num3);
									run = false;
									break;
							case '-':
//							case "-":
									num3 = num1 - num2;
									System.out.printf("%d %c %d = %d \n",num1,ja1,num2,num3);
									run = false;
									break;
							case '*':
//							case "*":
									num3 = num1 * num2;
									System.out.printf("%d %c %d = %d \n",num1,ja1,num2,num3);
									run = false;
									break;
							case '/':
//							case "/":
									if ( num2 != 0) {
										num3 = num1 / num2;
										System.out.printf("%d %c %d = %d \n",num1,ja1,num2,num3);
										run = false;
										break;
									} else {
										System.out.println("0으로 나눌 수 없습니다 다시 입력하세요.");
										break;
									}
							case '%':
//							case "%":
									num3 = num1 % num2;
									System.out.printf("%d %c %d = %d \n",num1,ja1,num2,num3);	
									run = false;
									break;

							default:
									System.out.println("없는 연산자입니다. 다시입력해주세요.");
						}
				}
			}
		}
	
	public static void  method11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자 :");
		int num = sc.nextInt();
		System.out.print("공차 :");
		int plus = sc.nextInt();
		
		int sum =0;
		String total ="";
		
		for (int i=1; i<=10; i++) {
			total += num + " ";
			num += plus ;
			
			
		}
		System.out.println(total);
		 
		 
	}
	
	
	
	public static void  method10() {
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
		 System.out.print("숫자 :");
		 int dan = sc.nextInt();
		
		 int sum = 0 ;
		 if (dan <=9 && dan >= 1) {
				
				for (; dan<=9; dan++) {
					System.out.printf("==== %d단 ==== \n",dan);
					
					for(int i=1; i<=9; i++) {
						sum = i * dan;
						System.out.printf("%d * %d = %d \n",dan,i,sum);
						
					}
					
				}
					break;
				} else {
					System.out.println("0 이상 9 이하의 숫자만 입력하세요.");
				}
		
		}
	}
	
	public static void  method9() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 :");
		int dan = sc.nextInt();
		
		int sum = 0;
		
		if (dan <=9 && dan >= 1) {
		
		for (; dan<=9; dan++) {
			System.out.printf("==== %d단 ==== \n",dan);
			
			for(int i=1; i<=9; i++) {
				sum = i * dan;
				System.out.printf("%d * %d = %d \n",dan,i,sum);
				
			}
			
		}
		} else {
			System.out.print("0 이상 9 이하의 숫자만 입력하세요.");
		}
		
		
	}
	
	
	public static void  method8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 :");
		int dan = sc.nextInt();
		
		int sum = 0;
		for (int i=1; i<=9; i++) {
			sum = i * dan;
			System.out.printf("%d * %d = %d \n",dan,i,sum);
		}
		
		
	}
	
	public static void  method7() {
		
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("첫번째 숫자 :");
			int num1 = sc.nextInt();
			System.out.print("두번째 숫자 :");
			int num2 = sc.nextInt();
			
			if (num1 <1 || num2 <1) {
				System.out.println("1 이상의 숫자를 입력해주세요");
				continue;
			} else {
				if (num1 > num2) {
					for (; num2<=num1; num2++) {
						System.out.print(num2 + " ");
					}
					break;
					
				} else {
				int temp=0;
					temp = num1;
					num1 = num2;
					num2 = temp;

					for (; num2<=num1; num2++) {
						System.out.print(num2 + " ");
					}
					break;
				}
			}		
		} while(true);	
	}
	
	public static void  method6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 :");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 :");
		int num2 = sc.nextInt();
		
		
		if (num1 <1 || num2 <1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			if (num1 > num2) {
				for (; num2<=num1; num2++) {
					System.out.print(num2 + " ");
				}
				
			} else {
			int temp=0;
				temp = num1;
				num1 = num2;
				num2 = temp;

				for (; num2<=num1; num2++) {
					System.out.print(num2 + " ");
				}
			}
		}
	}
	
	
	public static void  method5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 :");
		int num = sc.nextInt();
		
		int sum =0;
		String sum1 = "";
		for (int i=1 ; i<=num ; i++) {
			sum += i;
			sum1 += i + "+";
			
		}
		System.out.print(sum1 + " = "+ sum);
		
		
	}
	
	public static void  method4() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			System.out.print("1이상의 숫자를 입력하세요 :");
			int num = sc.nextInt();
			
			if (num >=1 ) {
				for (int i=1; num>=i; num--) {
					
					System.out.print(num+" ");
				}
				break;
			} else {
				System.out.print("1이상의 숫자를 입력하세요");
			}
			
		}
	}
	
	
	public static void  method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 :");
		int num = sc.nextInt();
		
		if (num >= 1 ) {
		for (int i=1; num>=i; num--) {
			
			System.out.print(num+" ");
		}
		} else {
			System.out.print("1 이상의 숫자를 입력하세요 ");
		}
	}
	
	public static void  method2() {
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			System.out.print("1이상의 숫자를 입력하세요 :");
			int num = sc.nextInt();
			
			if (num > 1) {
				 for (int i=1; i<=num; i++) {
					 System.out.print(i+" ");
				 }
				 break;
				 
			 } else {
				 System.out.println("1이상의 숫자를 입력하세요");
			 }
			
		}	
	}
	
	
	public static void  method1() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("1이상의 숫자를 입력하세요");
		int num = sc.nextInt();
		
		if (num >=1 ) {
			 for (int i=1; i<=num; i++) {
				 System.out.print(i+" ");
			 }
			
		} else {
			System.out.print("1이상의 숫자를 입력하세요");
		}
		
	}

}

package com.kh.last.p1;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("할당된 배열의 크기 : ");
		int[] nArr;
		int arrNum = sc.nextInt();
		nArr = new int[arrNum];

		System.out.print("array : "); print(nArr);
		System.out.println("가장 큰 값 : "+ max(nArr));
		System.out.println("가장 작은 값 : "+ min(nArr));
		System.out.println("짝수의 개수 : "+ evenCount(nArr));
		System.out.println("홀수의 개수 : "+ oddCount(nArr));
		System.out.println("합계 : "+ sum(nArr));
		System.out.printf("평균 : %.2f\n" , avg(nArr));

	}

	public static void print(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int ran = (int) (Math.random() * 100 + 1);
			arr[i] = ran;
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	
	public static int max(int[] nArr) {
		
		int max = nArr[0];
		for(int i=0; i<nArr.length;i++) {
			max = Math.max(max, nArr[i]);
		}
         
         return max;
         
         
         
	}
	
	public static int min(int[] nArr) {
		
		int min = nArr[0];
		for(int i=0; i<nArr.length;i++) {
				min = Math.min(min, nArr[i]);
		}
		
		return min;
	}
	
	public static int evenCount(int[] nArr) {
		
		int count =0;
		for(int s : nArr) {
			
			if ( s % 2 == 0 ) {
				count++;
			}
		}
		return count;
	}
	
	public static int oddCount(int[] nArr) {
		
		int count =0;
		for(int s : nArr) {
			
			if ( s % 2 != 0 ) {
				count++;
			}
		}
		return count;
	}
	
	public static int sum(int[] nArr) {
		
		int total =0;
		 for(int s : nArr) {
			 total += s;
		 }
		return total;
	}
	
	
	public static double avg(int[] nArr) {
		
		double avg = 0;
		
		avg = (double)sum(nArr) / nArr.length;
		
		return avg;
	}

}

package com.kh.array;

public class Array_02 {

	/*
	 * 
	 * * 변수 종류
	 *  - 일반 변수 : 리터럴 자체를 담을 수 잇는 변수
	 *  => 기본 자료형(boolean, int, char, double, ..)으로 선언된 변수
	 *  
	 *  -참조 변수(레퍼런스 변수) : 주소 값을 담고 있는 변수
	 *  => 그 외 자료형(int[], double[], char[]. ..., String, Scanner...)으로 선언된 변수
	 *  
	 *  * 배열 특징
	 *  - 배열 선언 된 할당까지만 한 후 직접 초기화하지 않아도 기본적으로 값들이 저장됨!
	 *   => Heap이라는 공간에는 빈 공간으로 존재할 수 없어서
	 *      공간이 만들어 질 때 JVM에 의해서 기본값으로 초기화됨! 
	 *    
	 *  * 배열 단점
	 *   - 한번 지정한 배열의 크기는 변경 불가능!
	 *    => 크기를 변경하고자 한다면 다시 만들어야 함.
	 * 
	 */
	public static void main(String[] args) {
		//정수형 배열 10개 크기의 iArr 변수 선언 및 할당
		
		 int[] iArr = new int[10];     // 인덱스 번호 0 ~ 9
		
		// 실수형 배열 4개의 크기의 dArr 변수 선언 및 할당
		 
		 double[] dArr = new double[4];  // 인덱스 번호 0 ~ 3
		 // 배열 선언하고 할당만 한 상태
		 
		 
		 // iArr 배열의 값들을 모두 출력
		 for(int i=0; i<iArr.length; i++ ) {
			 System.out.print(iArr[i]+ " ");
		 }
		 
		 System.out.println("------------");
		 
		 // dArr 배열의 값들을 모두 출력
		 for(int i=0; i<dArr.length; i++ ) {
			 System.out.print(dArr[i]+ " ");
		 }
		 
		 System.out.println("\n-----------------");
		 
		 System.out.println(iArr);
		 // => 배열의 자료형 + @ + 주소값의 16진수 형태
		 System.out.println(iArr.hashCode());
		 // => 주소값의 10진수 형태
		 
		 
		 // ---------------------------------
		 
		 int[] arr = null; // 아무것도 참조하지 않음!
		 // => 주소값을 가지는 참조변수		 
//		 System.out.println(arr);
		 
		 /*
		  *  null값을 가지고 있는 참조변수에 접근하여
		  *  다른 정보를 얻고자 하면 항상 오류가 발생!!
		  *  => NullPointerException
		  *  
		  */
//		 System.out.println(arr.hashCode());
//		 System.out.println(arr.length);
		 
		 /*
		  * 
		  * 
		  */
		 arr = new int[5];       // 인덱스 범위; 0 ~ 4
		 System.out.println(arr[4]);
//		 System.out.println(arr[5]);
		 
		// ---------------------------------
		 
		 System.out.println(arr.hashCode());
		 arr =new int[7];
		 
		 System.out.println(arr.hashCode());
		 //=> 주소값이 변경됨! --> 새로운 곳을 참조하고 있음.
		 
		 /*
		  *  연결이 끊어진 기존 배열은 Heap 영역에서
		  *  (어디에도 참조되고 않고 잇어, 필요엇ㅂ는 존재가 됨!)
		  *  => 일정 시간이 지나면 "가비지 컬렉터(GC)"가 알아서 제거해줌!
		  *  => 자바에서의 "자동 메모리 관리" 특징 -> 개발자는 코드 작성에만 집중할수 잇음!
		  */
		 
		 // 배열을 강제로 삭제시키고자 한다면 -> 연결고리를 끊어주면 됨! (null 대입)
		 arr = null;
		 System.out.println(arr.hashCode());
		 
		// ---------------------------------
		 
		 // 배열 선언, 할당, 초기화 전부 동시에 진행하기
		 int[] arr2= new int[] {1,2,3,4};
		 int[] arr3= {1,2,3,4};
		 
//		 System.out.println(arr == arr3);
		 // => false. 각각의 변수에 담겨있는 주소값 비교! 
		 			// 다른 위치에 데이터가 저장되어 있음!
	}
}

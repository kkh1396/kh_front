package com.kh.api;

public class MyArray<T> {

	private T[] arr;

	public MyArray(int size) throws MyException {
		if (size < 0) throw new MyException("size는 0보다 작을 수 없습니다."); 
		arr = new T[size];
	}

	public boolean add(T element) throws MyException {
		for(int i=0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = element;
				return true;
			}
		}

		return false;
	}

	public T get(int index) throws MyException {
		if (index < 0) throw new MyException("index는 0보다 작을 수 없습니다.");
		if (index >= arr.length) throw new MyException("index는 size보다 작아야 합니다.");
		return arr[index];
	}
 
	public void remove(int index) throws MyException {
		if (index < 0) throw new MyException("index는 0보다 작을 수 없습니다.");
		if (index >= arr.length) throw new MyException("index는 size보다 작아야 합니다.");
		arr[index] = null;
	}

	public int size() {
		return arr.length;
	}

}

class MyException extends Exception {
	public MyException() {}

	public MyException(String msg) {
		super(msg);
	}
}

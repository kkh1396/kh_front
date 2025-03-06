package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	private Book[] bArr = new Book[10];

	public void fileSave(Book[] bArr) {
		File blist = new File("book.txt");
		try (ObjectOutputStream bbs = 
				new ObjectOutputStream(
						new FileOutputStream("book.txt"));) {
			if(bArr !=null) {
				bbs.writeObject(bArr);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public Book[] fileRead() {
		try (ObjectInputStream bbs = new ObjectInputStream(
				new FileInputStream("book.txt"));){

			while(true) {
				bArr = (Book[]) bbs.readObject();
			}
		} catch (EOFException e) {
			System.out.println("");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bArr;
	}
}		






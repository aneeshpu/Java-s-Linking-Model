package com.aneeshpu.classloader;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private List<Book> books = new ArrayList<Book>();
	
	public void add(Book book){
		books.add(book);
	}
}
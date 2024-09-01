package com.sudheer.service;

import java.util.ArrayList;
import java.util.List;

import com.sudheer.model.Book;

public interface BookService {
	Book saveBook(Book book) throws Exception;

	// Read operation
	List<Book> fetchBookList();

	// Update operation
	Book updateBook(Book book, int bid);

	// Delete operation
	void deleteBookById(int bid);
	
	public ArrayList<String> findByBname(String name);
	public Book fetchByIdAuthor(Integer id);
}

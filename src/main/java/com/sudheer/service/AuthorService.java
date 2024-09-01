package com.sudheer.service;

import java.util.List;

import com.sudheer.model.Author;

public interface AuthorService {
	Author saveAuthor(Author author);

	// Read operation
	List<Author> fetchAuthorList();

	// Update operation
	Author updateAuthor(Author book, int aid);

	// Delete operation
	void deleteAuthorById(int aid);

	//String fetchAuthorBookcount(int aid);
}

package com.sudheer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.model.Author;
//import com.sudheer.model.Book;
@Repository
public interface AuthorDao extends JpaRepository<Author, Integer>  {
	//public String fetchAuthorBookcount(int aid);
}

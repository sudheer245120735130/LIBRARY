package com.sudheer.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	public ArrayList<String> findByBname(String name);
}

package com.sudheer.service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.exception.EnterValidElementException;
import com.sudheer.model.Book;
import com.sudheer.repository.BookDao;

@Service
public class BookServiceImp implements BookService {
	@Autowired
	private BookDao d;

	@Override
	public Book saveBook(Book book){
		if(book!=null && book.getBname()!=null) {
			d.save(book);
			return book;
		}else {
			throw new EnterValidElementException("please enter a valid element");
		}
			
	}
	public Book fetchByIdAuthor(Integer id) {
		return d.findById(id).get();
	}

	@Override
	public ArrayList<Book> fetchBookList() {
		return (ArrayList<Book>) d.findAll();
	}
	@Override
	public Book updateBook(Book book, int bid) {

		Book DB = d.findById(bid).get();
		if (Objects.nonNull(book.getBname()) && !"".equalsIgnoreCase(book.getBname())) {
			DB.setBname(book.getBname());
		}

		if (Objects.nonNull(book.getAuthor())) {
			DB.setAuthor(book.getAuthor());
		}

		if (Objects.nonNull(book.getBranch()) && !"".equalsIgnoreCase(book.getBranch())) {
			DB.setBranch(book.getBranch());
		}

		return d.save(DB);

	}

	@Override
	public void deleteBookById(int bid) {
		if(bid>0) {
			d.deleteById(bid);
		}else {
			throw new EnterValidElementException("please enter a valid element");
		}
	}
	@Override
	public ArrayList<String> findByBname(String name){
		
   ArrayList<String> a = d.findByBname(name);
   return a;
//		ArrayList<Book> k = fetchBookList();
//		for(Book a1 : k) {
//			if(a1.getBname().equals(name)) {
//				a.add(name+":"+a1.getAuthor());
//			}
//		}
//		if(name!=null) {
//		return a;
//		}
//		else {
//			throw new EnterValidElementException("no element found");
//		}
	}


}

package com.sudheer.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.model.Book;
import com.sudheer.service.BookService;

@RequestMapping("/book")
@RestController()
public class BookController {
	private Logger logger= LoggerFactory.getLogger(BookController.class);
	
	
	@Autowired
	private BookService bs;

	@PostMapping("create")
	public Book saveBook(@RequestBody Book book) throws Exception {
		logger.info("Going to create book for :{}",book);
		return bs.saveBook(book);
	}

	@GetMapping("findAll")
	public List<Book> fetchBookList() {
		return bs.fetchBookList();
	}
	@GetMapping("findById/{bid}")
	public Book fetchByIdAuthor(@PathVariable Integer bid) {
		return bs.fetchByIdAuthor(bid);
	}
    @GetMapping("Author")
    public ArrayList<String> findByBname( String name){
    	return bs.findByBname(name);
    }
	@PutMapping("update/{bid}")
	public Book updateBook( @RequestBody Book book, @RequestBody int bid) {
		return bs.updateBook(book, bid);
	}

	@PostMapping("delete/{bid}")
	public String deletebookById(@PathVariable int bid) {
		bs.deleteBookById(bid);
		return "Deleted Successfully";
	}
	
}

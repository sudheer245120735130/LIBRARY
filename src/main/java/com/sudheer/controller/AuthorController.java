package com.sudheer.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.model.Author;
import com.sudheer.service.AuthorService;
@RequestMapping("/Author")
@RestController
public class AuthorController {
	@Autowired
	private AuthorService sv;
	private Logger logger= LoggerFactory.getLogger(BookController.class);
	
	@PostMapping("/create")
	public Author saveAuthor( @RequestBody Author author) {
		logger.info("Going to create book for :{}",author);
		return sv.saveAuthor(author);
	}
	@GetMapping("/findAll")
	public List<Author> fetchAuthorList() {
		return sv.fetchAuthorList();
	}
	@PostMapping("/update/{aid}")
	public Author updateAuthor(Author author, int aid) {
		return sv.updateAuthor(author, aid);
	}

	@PostMapping("/delete/{aid}")
	public String deleteAuthorById(@PathVariable int aid) {
		sv.deleteAuthorById(aid);
		return "Deleted Successfully";
	}

}

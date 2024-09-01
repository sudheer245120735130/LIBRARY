package com.sudheer.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.exception.EnterValidElementException;
import com.sudheer.model.Author;
import com.sudheer.repository.AuthorDao;
@Service
public class AuthorServiceImp implements AuthorService{
	@Autowired
	private AuthorDao dao;
	@Override
	public Author saveAuthor(Author author) {
		if(author!=null && author.getAname()!=null) {
			dao.save(author);
			return author;
		}else {
			throw new EnterValidElementException("please enter a valid element");
		}
	}

	@Override
	public List<Author> fetchAuthorList() {
		dao.findAll();
		return dao.findAll();
	}

	@Override
	public Author updateAuthor(Author author, int aid) {
	    Author DB = dao.findById(aid).get();
	    if (Objects.nonNull(author.getAname()) && !"".equalsIgnoreCase(author.getAname())) {
			DB.setAname(author.getAname());
		}

		return dao.save(DB);
	}

	@Override
	public void deleteAuthorById(int aid) {
		if(aid>0) {
			dao.deleteById(aid);
		}else {
			throw new EnterValidElementException("please enter a valid element");
		}
		
	}

}

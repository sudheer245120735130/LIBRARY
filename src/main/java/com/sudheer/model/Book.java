package com.sudheer.model;
//import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="library")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	
	private String bname;
	
	private String branch;
	
	@ManyToOne
    @JoinColumn(name = "aid")
    private Author author;
	
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", branch=" + branch + ", author=" + author + "]";
	}
	
	
}


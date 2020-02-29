package com.desale.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="Book")
public class Book implements Serializable {
	 private static final long serialVersionUID = -908L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	
	public Book() {
		
	}
	
	public Book(Long id, String title, String author) {
		super();
		id = id;
		this.title = title;
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [Id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}

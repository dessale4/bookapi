package com.desale.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desale.spring.model.Book;
import com.desale.spring.service.BookService;

@CrossOrigin("*") // allows these methods to be allowed from Angular generated web pages
@RestController
//@Controller
public class BookController {
	{
		System.out.println("From bookcontroller");
	}
	@Autowired
	private BookService bookService;
	
	//Get all the books
	@GetMapping("/api/book")
	@ResponseBody
	public ResponseEntity<List<Book>> list() throws Exception{
		
		List<Book> list = bookService.list();
		System.out.println("From bookcontroller method");
		System.out.println(list.toString());
		return ResponseEntity.ok().body(list);
	}
	
	//Save the book
	@PostMapping("/api/book")
	public ResponseEntity<?> save(@RequestBody Book book){
		long id = bookService.save(book);
		
		return ResponseEntity.ok().body("Book created with id: " + id);
		
	}
	
	// Get a single record
	@RequestMapping("/api/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id){
		
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}
	
	// Update the book record
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book){
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been updated successfully");
	}
	
	// Delete a book from a record
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		bookService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted successfully");
	}
}

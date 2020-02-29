package com.desale.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desale.spring.dao.BookDAO;
import com.desale.spring.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public long save(Book book) {
		
		return bookDAO.save(book);
	}

	@Override
	public Book get(long id) {
		// call the get method from BookDAO to retrieve the desired book and return it to the controller
		return bookDAO.get(id);
	}

	@Override
	public List<Book> list() {
		System.out.println("From bookserviceImpl method");
		// Return the list of all books
		return bookDAO.list();
	}

	@Override
	public void update(long id, Book book) {
		// Update a book
		bookDAO.update(id, book);
		
	}

	@Override
	public void delete(long id) {
		// Remove a book from a record
		bookDAO.delete(id);
		
	}

}

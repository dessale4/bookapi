package com.desale.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desale.spring.model.Book;

@Repository
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	SessionFactory sessionFactory;
//	@Autowired
//	Transaction tx;
	
	@Override
	public long save(Book book) {
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		try {
			sessionFactory.getCurrentSession().save(book);	
		}
		catch (Exception e) {
         tx.rollback();
		}
		finally {
			tx.commit();
		}
		return book.getId();
	}

	@Override
	public Book get(long id) {
		System.out.println("Comming soon");
		// gate a book from data base
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		Book book = sessionFactory.getCurrentSession().get(Book.class, id);
		tx.commit();
		return book;
	}

	@Override
	public List<Book> list() {
		// Get the list of all books
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		System.out.println("From bookDAOImpl method");
		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		tx.commit();
		return list;
	}

	@Override
	public void update(long id, Book book) {
		// update a book
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		
		Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(id);
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		session.flush();
	
		tx.commit();
	}

	@Override
	public void delete(long id) {
		// Delete a book from a record
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
		tx.commit();
	}
	
}

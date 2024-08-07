package com.tidz.booksSys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tidz.booksSys.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Book> getAllBooks() {
		return this.entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		return Optional.ofNullable(this.entityManager.find(Book.class, id));
	}

	@Override
	@Transactional
	public Book saveBook(Book book) {
		if (book.getId() == null) {
			this.entityManager.persist(book);
		} else {
			book = this.entityManager.merge(book);
		}
		return book;
	}

	@Override
	public void deleteBookById(Long id) {
		Book book = this.entityManager.find(Book.class, id);
		if (book != null) {
			this.entityManager.remove(book);
		}
	}

}

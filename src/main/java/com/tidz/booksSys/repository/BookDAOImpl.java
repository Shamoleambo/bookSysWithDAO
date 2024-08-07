package com.tidz.booksSys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tidz.booksSys.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Book> getAllBooks() {
		return this.entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		return null;
	}

	@Override
	public Book saveBook(Book book) {
		return null;
	}

	@Override
	public void deleteBookById(Long id) {

	}

}

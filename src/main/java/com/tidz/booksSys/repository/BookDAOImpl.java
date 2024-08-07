package com.tidz.booksSys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tidz.booksSys.entity.Book;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBooks() {
		return null;
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

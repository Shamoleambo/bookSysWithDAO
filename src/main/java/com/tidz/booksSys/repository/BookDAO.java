package com.tidz.booksSys.repository;

import java.util.List;
import java.util.Optional;

import com.tidz.booksSys.entity.Book;

public interface BookDAO {

	List<Book> getAllBooks();

	Optional<Book> getBookById(Long id);

	Book saveBook(Book book);

	void deleteBookById(Long id);
}

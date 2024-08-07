package com.tidz.booksSys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidz.booksSys.entity.Book;
import com.tidz.booksSys.repository.BookDAO;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDao;

	public List<Book> getAllBooks() {
		return this.bookDao.getAllBooks();
	}

	public Optional<Book> getBookById(Long id) {
		return this.bookDao.getBookById(id);
	}

	public Book saveBook(Book book) {
		return this.bookDao.saveBook(book);
	}
	
	public void deleteBookById(Long id) {
		this.bookDao.deleteBookById(id);
	}
}

package com.tidz.booksSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tidz.booksSys.entity.Book;
import com.tidz.booksSys.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public String getAllBooks(Model model) {
		List<Book> books = this.bookService.getAllBooks();
		model.addAttribute("books", books);
		return "books";
	}
}

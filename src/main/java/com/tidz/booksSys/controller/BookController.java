package com.tidz.booksSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/new")
	public String showNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "new_book";
	}

	@PostMapping
	public String saveBook(@ModelAttribute Book book) {
		this.bookService.saveBook(book);
		return "redirect:/books";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@RequestParam("id") Long id, Model model) {
		Book book = this.bookService.getBookById(id).orElseThrow(() -> new IllegalArgumentException());
		model.addAttribute("book", book);
		return "edit_book";
	}

	@PostMapping("/{id}")
	public String updateBook(@RequestParam("id") Long id, @ModelAttribute Book book) {
		book.setId(id);
		this.bookService.saveBook(book);
		return "redirect:/books";
	}
}

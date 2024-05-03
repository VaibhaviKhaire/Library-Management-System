package com.project.LibraryManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import com.project.LibraryManagementSystem.Model.Book;
import com.project.LibraryManagementSystem.Model.MyBookList;

import com.project.LibraryManagementSystem.ServiceImpl.BookServiceImpl;
import com.project.LibraryManagementSystem.ServiceImpl.MyBookListServiceImpl;

import java.util.List;

@Controller
public class BookController {

	@Autowired
	private BookServiceImpl service;

	@Autowired
	private MyBookListServiceImpl mbl;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Book> list = service.getAllBooks();
		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String addBook(Book book) {
		service.save(book);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = mbl.getAllMyBooks();
		model.addAttribute("book", list);
		return "mybooks";
	}

	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") long id) {

		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		mbl.saveMyBooks(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") long id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id) {
		return "redirect:/available_book";
	}
}

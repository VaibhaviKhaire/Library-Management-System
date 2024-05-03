package com.project.LibraryManagementSystem.Service;

import com.project.LibraryManagementSystem.Model.Book;
import java.util.List;

public interface BookService {
	void save(Book book);

	List<Book> getAllBooks();

	public Book getBookById(long id);

	public void deleteById(long id);
}

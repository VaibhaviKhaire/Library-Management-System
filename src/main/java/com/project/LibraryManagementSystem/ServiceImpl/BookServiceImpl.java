package com.project.LibraryManagementSystem.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.LibraryManagementSystem.Model.Book;
import com.project.LibraryManagementSystem.Repository.BookRepository;
import com.project.LibraryManagementSystem.Service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bRepo;

    @Override
    public void save(Book book) {
        bRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bRepo.findAll();
    }
    
    
    public Book getBookById(long id) {
    	return bRepo.findById(id).get();
    }
    
    public void deleteById(long id) {
		bRepo.deleteById(id);
	}
}

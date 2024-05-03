package com.project.LibraryManagementSystem.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagementSystem.Model.MyBookList;
import com.project.LibraryManagementSystem.Repository.MyBookRepository;

@Service
public class MyBookListServiceImpl {

	@Autowired
	private MyBookRepository mbr;

	public void saveMyBooks(MyBookList book) {
		mbr.save(book);
	}

	public List<MyBookList> getAllMyBooks() {
		return mbr.findAll();
	}

	public void deleteById(long id) {
		mbr.deleteById(id);
	}

}

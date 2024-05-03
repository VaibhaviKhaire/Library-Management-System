package com.project.LibraryManagementSystem.Service;

import java.util.List;

import com.project.LibraryManagementSystem.Model.MyBookList;

public interface MyBookListService {

	public void saveMyBooks(MyBookList book);

	public List<MyBookList> getAllMyBooks();

	public void deleteById(long id);

}

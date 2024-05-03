package com.project.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LibraryManagementSystem.Model.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Long> {

}

package com.project.LibraryManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.LibraryManagementSystem.ServiceImpl.MyBookListServiceImpl;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListServiceImpl service;

	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_books";
	}

}

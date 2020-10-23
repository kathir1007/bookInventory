package com.msys.bookinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msys.bookinventory.model.Book;
import com.msys.bookinventory.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("admin/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(service.getAllBooks(),new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("admin/createBookData")
	public void createBookData(Book book) {
		service.createBookData(book);
	}
	
	@PostMapping("admin/update/")
	public void updateBookData(Book book) {
		service.updateBookData(book);
	}
	
	@GetMapping("user/getBookData/{id}")
	public ResponseEntity<Book> getBookData(@PathVariable Long id) {
		return new ResponseEntity<Book>(service.getBookData(id),new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("admin/deleteBookData/{id}")
	public void deleteBookData(@PathVariable Long id) {
		service.deleteBookData(id);
	}

}

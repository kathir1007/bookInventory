package com.msys.bookinventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msys.bookinventory.model.Book;

@Service
public interface BookService {

	List<Book> getAllBooks();


	Book getBookData(Long id);


	void createBookData(Book book);


	void updateBookData(Book book);


	void deleteBookData(Long id);

}

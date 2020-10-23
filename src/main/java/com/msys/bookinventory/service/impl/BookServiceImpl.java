package com.msys.bookinventory.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msys.bookinventory.model.Book;
import com.msys.bookinventory.repository.BookRepository;
import com.msys.bookinventory.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {
		List<Book> booksList =  bookRepo.findAll();
		/*
		 * All datas sorted based on ratings
		 */
		Collections.sort(booksList, new Comparator<Book>(){
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getRating() - b2.getRating();
			}
		});
		return booksList;
	}


	@Override
	public Book getBookData(Long id) {
		return bookRepo.findById(id).get();
	}


	@Override
	public void createBookData(Book book) {
		bookRepo.save(book);
		
	}


	@Override
	public void updateBookData(Book book) {
		Optional<Book> bookData = bookRepo.findById(book.getId());
		if(bookData.isPresent()) {
			Book oldBook = bookData.get();
			oldBook.setPrice(book.getPrice());
			oldBook.setRating(book.getRating());
			bookRepo.save(oldBook);
		}
	}


	@Override
	public void deleteBookData(Long id) {
		bookRepo.deleteById(id);
		
	}

}

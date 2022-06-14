package com.optum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optum.entity.Book;
import com.optum.exceptions.BookAlreadyExistsException;
import com.optum.exceptions.BookNotFoundException;
import com.optum.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(String id) {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not found with id " + id));
	}

	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	public Book save(Book book) {
		Book book1 = bookRepository.findByName(book.getName());
		if (book1 != null)
			throw new BookAlreadyExistsException("Book already exists with name " + book.getName());
		book.setId(book.getIsbn() + book.getRack());
		return bookRepository.save(book);

	}

	public void delete(String id) {
		Book book = bookRepository.findById(id).orElseThrow(
				() -> new BookNotFoundException("Book not found with id " + id + " cannot delete the book"));
		bookRepository.delete(book);
	}
}

package com.optum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.optum.entity.Book;
import com.optum.exceptions.BookAlreadyExistsException;
import com.optum.exceptions.BookNotFoundException;
import com.optum.repository.BookRepository;

@Service
public class BookService {
//63055 47515 cook kumari
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

	public List<Book> sortBooks(String field, String order) {
		Sort sort = Sort.by(Direction.fromString(order), field);
		return bookRepository.findAll(sort);
	}

	public List<Book> pagingBooks(int pageNo, int size) {
		Pageable page = PageRequest.of(pageNo, size);
		return bookRepository.findAll(page).getContent();
	}
}

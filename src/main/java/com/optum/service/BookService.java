package com.optum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

	@Autowired
	BookRepository bookRepository;

	@Cacheable("books")
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Cacheable(value = "book", key = "#p0")
	public Book findById(String id) {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not found with id " + id));
	}

	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@CacheEvict(value = "books", allEntries = true)
	public Book save(Book book) {
		Book book1 = bookRepository.findByName(book.getName());
		if (book1 != null)
			throw new BookAlreadyExistsException("Book already exists with name " + book.getName());
		book.setId(book.getIsbn() + book.getRack());
		return bookRepository.save(book);

	}

	@Caching(evict = { @CacheEvict(value = "books", allEntries = true), @CacheEvict(value = "book", key = "#p0") })
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

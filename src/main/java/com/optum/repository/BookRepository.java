package com.optum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optum.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	public List<Book> findByAuthor(String author);

	public Book findByIsbn(String isbn);
	
    public Book findByName(String name);
}

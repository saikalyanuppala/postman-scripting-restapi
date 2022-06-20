package com.optum.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optum.entity.Book;
import com.optum.service.BookService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	BookService bookService;

	public Book createBook(BookRequest request) {
		Book book = new Book(request.getName(), request.getIsbn(), request.getRack(), request.getAuthor());
		return bookService.save(book);
	}
}

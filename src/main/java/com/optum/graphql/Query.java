package com.optum.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.optum.entity.Book;
import com.optum.service.BookService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	BookService bookService;

	public String firstQuery() {
		return "First Grapghql Query";
	}

	public String sayHello(String name) {
		return "Hello " + name + " Welcome to grapghQL";
	}
	
	public String readFromJson(FullNameBean name) {
		return name.getFirstName()+" "+name.getLastName();
	}

	public Book getBookById(String id) {
		return bookService.findById(id);
	}
	
	public List<Book> getAllBooks(){
		return bookService.findAll();
	}
}

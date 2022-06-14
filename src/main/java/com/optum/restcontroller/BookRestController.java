package com.optum.restcontroller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.optum.entity.Book;
import com.optum.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	public BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}

	@GetMapping("/books/{id}")
	public EntityModel<Book> getBookById(@PathVariable("id") String id) {
		Book book = bookService.findById(id);
		EntityModel<Book> model = EntityModel.of(book);

		Link linkToBooks = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllBooks())
				.withRel("All Books");
		Link linkToDelete = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass(), id).deleteBook(id))
				.withRel("Delete book");

		model.add(linkToBooks, linkToDelete);

		return model;
	}

	@GetMapping("/books/author/{author}")
	public List<Book> getBookByAuthor(@PathVariable("author") String author) {
		return bookService.findByAuthor(author);
	}

	@PostMapping("/books")
	public ResponseEntity<Object> saveBook(@Valid @RequestBody Book book) {
		Book savedBook = bookService.save(book);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") String id) {
		bookService.delete(id);
		return ResponseEntity.ok("Book deleted with id " + id);
	}
}

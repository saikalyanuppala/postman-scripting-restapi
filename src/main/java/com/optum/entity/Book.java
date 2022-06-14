package com.optum.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {

	@Id
	private String id;

	@NotBlank(message = "name can't be blank")
	private String name;
	@NotEmpty(message = "isbn can't be empty")
	private String isbn;
	@NotEmpty(message = "rack can't be empty")
	private String rack;
	@NotNull(message = "author can't be null")
	@NotEmpty(message = "author can't be empty")
	private String author;

	public Book() {
	}

	public Book(String name, String isbn, String rack, String author) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.rack = rack;
		this.author = author;
	}

	public Book(String id, String name, String isbn, String rack, String author) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.rack = rack;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", rack=" + rack + ", author=" + author + "]";
	}

}

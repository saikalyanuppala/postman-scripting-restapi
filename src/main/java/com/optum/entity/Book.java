package com.optum.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

	public Book(String name, String isbn, String rack, String author) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.rack = rack;
		this.author = author;
	}

}

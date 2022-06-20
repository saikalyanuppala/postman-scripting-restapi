package com.optum.graphql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

	private String name;
	private String isbn;
	private String rack;
	private String author;

}

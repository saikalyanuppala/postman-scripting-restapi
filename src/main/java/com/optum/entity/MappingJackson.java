package com.optum.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonFilter("jacksonFilter")
public class MappingJackson {

	@JsonProperty("field_1")
	private String field1;
	@JsonProperty("field_2")
	private String field2;
	@JsonProperty("field_3")
	private String field3;
	@JsonProperty("field_4")
	private String field4;
	@JsonProperty("field_5")
	private String field5;

}

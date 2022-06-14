package com.optum.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public MappingJackson(String field1, String field2, String field3, String field4, String field5) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}

	public MappingJackson() {
	}

	protected String getField1() {
		return field1;
	}

	protected void setField1(String field1) {
		this.field1 = field1;
	}

	protected String getField2() {
		return field2;
	}

	protected void setField2(String field2) {
		this.field2 = field2;
	}

	protected String getField3() {
		return field3;
	}

	protected void setField3(String field3) {
		this.field3 = field3;
	}

	protected String getField4() {
		return field4;
	}

	protected void setField4(String field4) {
		this.field4 = field4;
	}

	protected String getField5() {
		return field5;
	}

	protected void setField5(String field5) {
		this.field5 = field5;
	}

}

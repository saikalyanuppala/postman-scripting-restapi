package com.optum.restcontroller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.optum.entity.MappingJackson;

@RestController
public class MappingJacksonController {

	@GetMapping("/jackson/123")
	public MappingJacksonValue getFields123() {
		MappingJackson jackson = new MappingJackson("abc", "def", "jkl", "nmb", "xcv");

		SimpleBeanPropertyFilter beanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field_1","field_2","field_3");
		FilterProvider provider = new SimpleFilterProvider().addFilter("jacksonFilter", beanFilter);
		MappingJacksonValue value = new MappingJacksonValue(jackson);
		value.setFilters(provider);

		return value;
	}
}

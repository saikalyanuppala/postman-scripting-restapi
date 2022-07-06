package com.optum.restcontroller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18NController {

	@Autowired
	private MessageSource bundle;

	//use accept-language header to see different results
	@GetMapping("/i18n")
	public String getMessages(Locale locale) {
		return bundle.getMessage("welcome", null, "Welcome default message", locale);
	}

}

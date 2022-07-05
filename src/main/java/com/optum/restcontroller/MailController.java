package com.optum.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optum.mail.SendEmail;

@RestController
public class MailController {

	@Autowired
	private SendEmail sendEmail;

	@GetMapping("/simpleMail")
	public String sendSimpleMail() {
		sendEmail.sendSimpleMail();
		return "simple mail sent successfully";
	}
}

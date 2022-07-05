package com.optum.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendSimpleMail() {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo("cleansai@gmail.com","saikalyan.uppala@gmail.com","saikalyan.0889@gmail.com");
		msg.setSubject("Mail from JavaMailSender springboot.. 2 step password added");
		msg.setText("This simple email is coming from springboot...");
		msg.setText("The new 2 step generated password for spring mailer is:  kgvuocrajdawcxyw");

		javaMailSender.send(msg);
	}
}

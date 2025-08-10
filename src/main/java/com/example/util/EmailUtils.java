package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String username;
	
	public void sendEmail(String toEMail, String body, String subject) {
		SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
		simpleMailMessage.setFrom(username);
		simpleMailMessage.setTo(toEMail);
		simpleMailMessage.setText(body);
		simpleMailMessage.setSubject(subject);
		
		javaMailSender.send(simpleMailMessage);
	}

}

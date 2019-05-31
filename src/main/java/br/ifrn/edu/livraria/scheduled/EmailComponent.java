package br.ifrn.edu.livraria.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailComponent {
	
	@Autowired
	public JavaMailSender emailSender;
		
	public void sendSimplesMessage(String to, String subject, String text, String from) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		message.setFrom(from);
		
		emailSender.send(message);
		System.out.println("#e-mail enviaddo com sucesso!");
	}

}

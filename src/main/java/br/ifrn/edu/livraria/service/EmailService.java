package br.ifrn.edu.livraria.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import br.ifrn.edu.livraria.model.Email;
import freemarker.core.Configurable;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender emailSender;

	/* Pegar as configurações */
	@Autowired
	private Configuration config;
	

	public void sendSimpleMessage(Email mail, Map<String,Object> model) throws MessagingException, IOException, TemplateException {
		MimeMessage message = emailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.addAttachment("ifrn.png", new ClassPathResource("ifrn.png"));

		Template t = config.getTemplate("email.ftl");	
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		
		helper.setTo(mail.getTo());
		helper.setText(html, true);
		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());
		
		emailSender.send(message);		
		

	

		
	}
}

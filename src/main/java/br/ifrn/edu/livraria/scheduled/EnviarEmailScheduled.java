package br.ifrn.edu.livraria.scheduled;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.model.Email;
import br.ifrn.edu.livraria.service.EmailService;


@Component
public class EnviarEmailScheduled {
	private final long SEGUNDO = 1000;
	private final long MINUTOS = SEGUNDO *60;
	
	@Autowired
	private EmailService emailService;
	
	@Scheduled(initialDelay=MINUTOS*1000 , fixedDelay= MINUTOS)
	public void verificarHora() throws MessagingException, IOException {
	

        Email mail = new Email();
        mail.setFrom("disciplina.dsc@gmail.com");
        mail.setTo("jefersonqueiroga@gmail.com");
        mail.setSubject("Livraria IFRN");

        Map <String,Object> model = new HashMap<String,Object>();
        model.put("name", "Jeferson Queiroga" );
        
        model.put("nome", "Antonia Francimar");
        model.put("location", "Pau dos Ferros");
        model.put("signature", "https://suap.ifrn.edu.br");
        

//        try {
//			emailService.sendSimpleMessage(mail,model);
//		} catch (TemplateException e) {
//			e.printStackTrace();
//		}
		
	}

}

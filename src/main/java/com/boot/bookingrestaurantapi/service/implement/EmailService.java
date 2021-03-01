package com.boot.bookingrestaurantapi.service.implement;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.dtos.EmailTemplateDto;
import com.boot.bookingrestaurantapi.entities.Notification;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.repositories.NotificationRepositoryI;
import com.boot.bookingrestaurantapi.service.EmailServiceI;

@Service
public class EmailService implements EmailServiceI{

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationService.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private NotificationRepositoryI notificationRepository;
	
	@Override
	public String processSendEmail(String receiver, String templadeCode, String currentName)
			throws BookingException {
		
		final EmailTemplateDto emailTemplateDto = findTemplateAndReplace(templadeCode, currentName);
		this.sendEmail(receiver, emailTemplateDto.getSubject(), emailTemplateDto.getTemplate());
		
		return "Email Enviado";
	}
	
	private void sendEmail(final String receiver, final String subject, final String template) throws BookingException{
		final MimeMessage email = mailSender.createMimeMessage();
		final MimeMessageHelper content;
		
		try {
			content = new MimeMessageHelper(email, true);
			content.setSubject(subject);
			content.setTo(receiver);
			content.setText(template, true);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "ERROR SERVICE -> EmailService");
		}
		
		mailSender.send(email);
	}

	private EmailTemplateDto findTemplateAndReplace(final String templateCode, final String currentName) throws BookingException {
		
		final Notification notificationEntity = notificationRepository.findByTemplateCode(templateCode)
				.orElseThrow(() -> new NotFoundException("TEMPLATE_NOT_FOUD", "Template code no encontrado"));
		
		final EmailTemplateDto emailTemplateDto = new EmailTemplateDto();
		emailTemplateDto.setSubject(notificationEntity.getTemplateCode());
		emailTemplateDto.setTemplate(notificationEntity.getTemplate().replaceAll("\\{"+"name"+"\\}", currentName));
		
		return emailTemplateDto;
	}
}

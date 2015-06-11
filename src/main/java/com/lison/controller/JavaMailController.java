package com.lison.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import com.lison.model.Membre;

@Controller
public class JavaMailController {

	public void sendMail(final Membre membre, final String comment) {

		final String username = "sportcomptasso@gmail.com";
		final String password = "admin411";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String message = "Bonjour, \n\n";
		if (membre.getCompte_valide().getID() == 2) {
			message += "Votre compte a été validé.\n";
			message += "Votre mot de passe :" + membre.getPassword() + "\n\n";
			message += "Merci";
		} else {
			if (membre.getCompte_valide().getID() == 3) {
				message += "Votre compte n'a pas été validé.\n";
				message += "En attente de validation, \n\n";
				message += "Merci";
			} else {
				message += "Votre est en attente de validation.\n";
				message += "Merci";
			}
		}

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("sportcomptasso@gmail.com", " AdminSportCompAsso"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(membre.getEmail(), membre.getPrenom() + " " + membre.getNom()));
			msg.setSubject("Sport - compétion : Demande d'inscription");
			msg.setText(message);
			Transport.send(msg);

		} catch (AddressException e) {
			System.out.println("exception1");
		} catch (MessagingException e) {
			System.out.println("exception2" + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("exception3");
		}
	}
}
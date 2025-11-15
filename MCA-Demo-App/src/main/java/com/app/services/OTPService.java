package com.app.services;

import java.util.Properties;

import com.app.config.AppConfig;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class OTPService {
	
	public static boolean sendRegisterOTP(String to, String userName, int OTP) {
		String senderEmail = "piebytwo014@gmail.com";
		String senderPassword = AppConfig.getSecretData("EMAIL_PASSWORD");
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		};
	
		Session session = Session.getInstance(properties, auth);
		
		Message msg = new MimeMessage(session);
		
		try {
			msg.setFrom(new InternetAddress(senderEmail));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject("Registration Success 🙏");
			msg.setText("Hello, "+ userName + "\n\n"
						+"Your One Time Password (OTP) is : "+OTP+"\n\n"
						+"This OTP will expire in next 10 mins. \n\n"
						+"Please do not share this OTP with anyone. \n\n"
						+"Thanks and Regards, \n"
						+"Team MCA.");
			Transport.send(msg);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}




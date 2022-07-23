package com.swp.swp.service;

import com.swp.swp.database.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ojt.sender@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        System.out.println(toEmail);
        System.out.println(body);
        System.out.println(subject);
        //mailSender.send(message);
        System.out.println("Success");
    }
}

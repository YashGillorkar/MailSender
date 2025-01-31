package com.yash.resumemailer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yash.resumemailer.model.EmailDetails;
import com.yash.resumemailer.repository.EmailDetailsRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailDetailsServiceImpl implements EmailDetailsServiceI {

    private static final Logger logger = LoggerFactory.getLogger(EmailDetailsServiceImpl.class);

    @Autowired
    EmailDetailsRepository detailsRepository;

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(String toEmail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(toEmail);
            helper.setFrom(fromEmail);
            helper.setSubject("Application for Java Developer Position");
            helper.setText("Dear Hiring Manager,\n\n"
                    + "I am writing to express my interest in the Java Developer role. "
                    + "With 2+ years of experience in backend development, I have worked extensively with Java, JDBC, "
                    + "Hibernate, Spring Boot, SQL, and databases like MySQL and PostgreSQL, following agile methodologies "
                    + "to deliver scalable solutions.\n\n"
                    + "I am confident my skills and experience align well with the requirements of this position. "
                    + "I would welcome the opportunity to contribute to your team and discuss how I can add value to your projects.\n\n"
                    + "Thank you for considering my application. I look forward to hearing from you.\n\n"
                    + "Best regards,\n" + "Yash Gillorkar\n" + "7058157670");

            FileSystemResource resource = new FileSystemResource("C:/Users/mkgil/Downloads/Yash_Gillorkar_2_Yr_Exp.pdf");
            helper.addAttachment("Yash_Gillorkar_2_Yr_Exp.pdf", resource);

            // Send email
            mailSender.send(mimeMessage);
            logger.info("Email sent successfully to: " + toEmail);
        } catch (MessagingException e) {
            logger.error("Failed to send email to: " + toEmail, e);
        }
    }

    @Override
    public void send() {
        List<EmailDetails> listOfRecruiter = detailsRepository.findAll();
        for (EmailDetails recruiter : listOfRecruiter) {
            logger.info("Sending email to: " + recruiter.getEmail());
            sendEmail(recruiter.getEmail());
        }
    }
}

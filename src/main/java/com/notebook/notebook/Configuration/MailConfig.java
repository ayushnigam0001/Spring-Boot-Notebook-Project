package com.notebook.notebook.Configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(465);
    mailSender.setUsername("ayushnigam0001@gmail.com");
    mailSender.setPassword("ptyidqsdrersulue");

    Properties props = mailSender.getJavaMailProperties();
    // props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    // props.put("mail.smtp.starttls.enable", "true");
    // google dosent allow unsecured connection
    props.put("mail.debug", "true");

    props.put("mail.smtp.ssl.enable", "true");
    return mailSender;
  }
}

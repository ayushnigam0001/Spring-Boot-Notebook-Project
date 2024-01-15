package com.notebook.notebook.Service.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.notebook.notebook.Service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender emailSender;// = new MailConfig().getJavaMailSender();

  @Override
  public void sendSimpleMail(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("ayushnigam0001@gmail.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);
    System.out.println("Mail Send-------------------------------------------------");
  }

  @Override
  public void sendMailWithAttachment(String to, String subject, String text)
      throws MessagingException {
    MimeMessage mimeMessage = emailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
    // String path = "C:\\Users\\Ayush Nigam\\Downloads\\Ayush_Nigam-2022.pdf";
    // File file = new File(path);
    mimeMessageHelper.setFrom("ayushnigam0001@gmail.com");
    mimeMessageHelper.setTo(to);
    mimeMessageHelper.setSubject(subject);
    mimeMessageHelper.setText(text, true);
    emailSender.send(mimeMessage);
  }

}

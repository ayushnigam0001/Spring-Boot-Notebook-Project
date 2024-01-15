package com.notebook.notebook.Security.helper;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.notebook.notebook.Service.serviceImpl.EmailServiceImpl;

import lombok.Getter;
import lombok.Setter;

@Service
@Setter
@Getter
public class Mailer {
  private String to;
  private String link;
  private String subject;

  @Autowired
  private EmailServiceImpl emailServiceImpl;

  @Async("taskExecutor")
  public void send() throws MessagingException {
    String text = "<a href=" + link + "> + Click-Here  </a>";
    emailServiceImpl.sendMailWithAttachment(to, subject, text);
    System.out.println("********* current Thread in send : " + Thread.currentThread().getName());
  }
}

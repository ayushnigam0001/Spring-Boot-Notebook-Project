package com.notebook.notebook.Service;

import javax.mail.MessagingException;

public interface EmailService {
  void sendSimpleMail(String to, String subject, String text);

  void sendMailWithAttachment(String to, String subject, String body) throws MessagingException;
}
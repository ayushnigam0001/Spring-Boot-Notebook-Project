package com.notebook.notebook.Security.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.notebook.Model.TemporaryUser;
import com.notebook.notebook.Model.User;
import com.notebook.notebook.Security.Utils.JwtUtils;
import com.notebook.notebook.Security.helper.MD5;
import com.notebook.notebook.Security.helper.Mailer;
import com.notebook.notebook.Security.payload.JwtRequest;
import com.notebook.notebook.Security.payload.JwtResponse;
import com.notebook.notebook.Security.service.serviceImpl.TemporaryUserServiceImpl;
import com.notebook.notebook.Service.serviceImpl.CustomUserDetailsService;
import com.notebook.notebook.Service.serviceImpl.UserServiceImpl;
import com.notebook.notebook.payload.RequestDto.UserRequestDto;
import com.notebook.notebook.payload.ResponseDto.UserResponseDto;

@RestController
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserServiceImpl userServiceImpl;

  @Autowired
  private TemporaryUserServiceImpl temporaryUserService;

  @Autowired
  private Mailer mailer;

  @PostMapping("/signin")
  public JwtResponse signIn(@RequestBody JwtRequest jwtRequest) throws Exception {
    try {
      this.autheticate(jwtRequest.getUsername(), jwtRequest.getPassword());
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("no user found");
    }
    String token = this.getJsonToken(jwtRequest.getUsername());

    return new JwtResponse(token);
  }

  @PostMapping("/signup")
  public String signUp(@RequestBody UserRequestDto userRequestDto) throws MessagingException {
    TemporaryUser temporaryUser = TemporaryUser.buildTemporaryUser(userRequestDto);
    String hash = MD5.getMd5(temporaryUser.getEmail() + temporaryUser.getPhoneNo());
    temporaryUser.setHash(hash);
    String link = "http://localhost:8080/verify?value=" + hash;
    String subject = "NoteBook Mail Varification";
    System.out.println(link);

    mailer.setTo(userRequestDto.getEmail());
    mailer.setLink(link);
    mailer.setSubject(subject);
    System.out.println("********* current Thread in controller: " + Thread.currentThread().getName());
    mailer.send();
    temporaryUserService.createTemporaryUser(temporaryUser);
    return "Click on the link in mail to activate account : " + link;
  }

  @PostMapping("/verify")
  public UserResponseDto emailAuth(@RequestParam("value") String hash) {
    TemporaryUser temporaryUser = temporaryUserService.getTemporaryUser(hash);
    User user = TemporaryUser.buildUser(temporaryUser);
    User resUser = userServiceImpl.createUser(user);
    temporaryUserService.deleteTemporaryUser(temporaryUser);
    return UserResponseDto.buildDto(resUser);
  }

  private void autheticate(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
  }

  private String getJsonToken(String username) {
    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
    String token = jwtUtils.generateToken(userDetails);
    return token;
  }
}

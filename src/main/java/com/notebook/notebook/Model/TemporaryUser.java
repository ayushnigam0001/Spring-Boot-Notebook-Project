package com.notebook.notebook.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.notebook.notebook.payload.RequestDto.UserRequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TemporaryUser {
  @Id
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone_no", nullable = false)
  private int phoneNo;

  @Column(name = "hash", nullable = false)
  private String hash;

  public static User buildUser(TemporaryUser temporaryUser) {
    User user = new User();
    user.setUsername(temporaryUser.getUsername());
    user.setPassword(temporaryUser.getPassword());
    user.setFirstName(temporaryUser.getFirstName());
    user.setLastName(temporaryUser.getLastName());
    user.setEmail(temporaryUser.getEmail());
    user.setPhoneNo(temporaryUser.getPhoneNo());
    return user;
  }

  public static TemporaryUser buildTemporaryUser(UserRequestDto userRequestDto) {
    TemporaryUser temporaryUser = new TemporaryUser();
    temporaryUser.setUsername(userRequestDto.getUsername());
    temporaryUser.setPassword(userRequestDto.getPassword());
    temporaryUser.setFirstName(userRequestDto.getFirstName());
    temporaryUser.setLastName(userRequestDto.getLastName());
    temporaryUser.setEmail(userRequestDto.getEmail());
    temporaryUser.setPhoneNo(userRequestDto.getPhoneNo());
    return temporaryUser;
  }
}

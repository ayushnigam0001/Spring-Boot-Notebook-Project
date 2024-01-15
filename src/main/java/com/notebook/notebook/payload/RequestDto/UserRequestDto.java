package com.notebook.notebook.payload.RequestDto;

import com.notebook.notebook.Model.User;

import lombok.Data;

@Data
public class UserRequestDto {
  private String username;

  private String password;

  private String firstName;

  private String lastName;

  private String email;

  private int phoneNo;

  public static User buildUser(UserRequestDto userRequestDto) {
    User user = new User();
    user.setUsername(userRequestDto.getUsername());
    user.setPassword(userRequestDto.getPassword());
    user.setFirstName(userRequestDto.getFirstName());
    user.setLastName(userRequestDto.getLastName());
    user.setEmail(userRequestDto.getEmail());
    user.setPhoneNo(userRequestDto.getPhoneNo());
    return user;
  }
}

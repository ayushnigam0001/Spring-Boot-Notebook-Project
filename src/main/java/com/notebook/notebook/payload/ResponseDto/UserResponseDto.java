package com.notebook.notebook.payload.ResponseDto;

import com.notebook.notebook.Model.User;

import lombok.Data;

@Data
public class UserResponseDto {
  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private int phoneNo;

  public static UserResponseDto buildDto(User user) {
    UserResponseDto userResponseDto = new UserResponseDto();
    userResponseDto.setUsername(user.getUsername());
    userResponseDto.setEmail(user.getEmail());
    userResponseDto.setFirstName(user.getFirstName());
    userResponseDto.setLastName(user.getLastName());
    userResponseDto.setEmail(user.getEmail());
    userResponseDto.setPhoneNo(user.getPhoneNo());
    return userResponseDto;
  }
}

package com.notebook.notebook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.notebook.Model.User;
import com.notebook.notebook.Service.serviceImpl.UserServiceImpl;
import com.notebook.notebook.helper.CurrentSession;
import com.notebook.notebook.payload.RequestDto.UserRequestDto;
import com.notebook.notebook.payload.ResponseDto.UserResponseDto;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @PostMapping("/update")
  public UserResponseDto update(@RequestBody UserRequestDto userRequestDto) {
    String username = CurrentSession.getUsername();
    userRequestDto.setUsername(username);
    User user = UserRequestDto.buildUser(userRequestDto);
    user.setUsername(username);
    User resUser = userServiceImpl.updateUser(user);
    return UserResponseDto.buildDto(resUser);
  }

  @DeleteMapping
  public void delete() {
    User user = (User) CurrentSession.getLoggedInUser();
    userServiceImpl.deleteUser(user);
  }

  @GetMapping
  public UserResponseDto getUser() {
    User user = (User) CurrentSession.getLoggedInUser();
    return UserResponseDto.buildDto(user);
  }
}

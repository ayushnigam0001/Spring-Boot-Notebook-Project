package com.notebook.notebook.Service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.notebook.Model.User;
import com.notebook.notebook.Service.UserService;
import com.notebook.notebook.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUser(User user) {
    return userRepository.findByUsername(user.getUsername());
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }

}

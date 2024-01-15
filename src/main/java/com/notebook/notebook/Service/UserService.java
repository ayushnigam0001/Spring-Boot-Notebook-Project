package com.notebook.notebook.Service;

import com.notebook.notebook.Model.User;

public interface UserService {
  User createUser(User user);

  User updateUser(User user);

  User getUser(User user);

  void deleteUser(User user);
}

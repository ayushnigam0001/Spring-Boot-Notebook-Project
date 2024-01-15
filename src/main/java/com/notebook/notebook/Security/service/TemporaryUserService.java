package com.notebook.notebook.Security.service;

import com.notebook.notebook.Model.TemporaryUser;

public interface TemporaryUserService {
  void createTemporaryUser(TemporaryUser temporaryUser);

  TemporaryUser getTemporaryUser(String hash);

  void deleteTemporaryUser(TemporaryUser temporaryUser);
}

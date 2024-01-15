package com.notebook.notebook.Security.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.notebook.Model.TemporaryUser;
import com.notebook.notebook.Security.Repository.TemporaryUserRepository;
import com.notebook.notebook.Security.service.TemporaryUserService;

@Service
public class TemporaryUserServiceImpl implements TemporaryUserService {

  @Autowired
  private TemporaryUserRepository temporaryUserRepository;

  @Override
  public void createTemporaryUser(TemporaryUser temporaryUser) {
    temporaryUserRepository.save(temporaryUser);
  }

  @Override
  public TemporaryUser getTemporaryUser(String hash) {
    TemporaryUser temporaryUser = temporaryUserRepository.findByHash(hash);
    return temporaryUser;
  }

  @Override
  public void deleteTemporaryUser(TemporaryUser temporaryUser) {
    temporaryUserRepository.delete(temporaryUser);
  }

}

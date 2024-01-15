package com.notebook.notebook.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.notebook.Model.TemporaryUser;

public interface TemporaryUserRepository extends JpaRepository<TemporaryUser, Integer> {
  TemporaryUser findByHash(String hashCode);
}

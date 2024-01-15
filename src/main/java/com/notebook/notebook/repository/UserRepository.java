package com.notebook.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.notebook.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);
}

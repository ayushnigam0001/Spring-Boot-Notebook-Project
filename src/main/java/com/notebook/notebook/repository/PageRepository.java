package com.notebook.notebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.User;

public interface PageRepository extends JpaRepository<Page, Integer> {
  Page findByIdAndUserAndBook(int id, User user, Book book);

  List<Page> findByUserAndBook(User user, Book book);

  Page findByUserAndPageNo(User user, Integer pageId);
}

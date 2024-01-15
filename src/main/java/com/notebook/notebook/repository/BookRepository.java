package com.notebook.notebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.User;

public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByUserAndBookNameContaining(User user, String bookName);

  Book findByUserAndBookId(User user, Integer bookId);
}

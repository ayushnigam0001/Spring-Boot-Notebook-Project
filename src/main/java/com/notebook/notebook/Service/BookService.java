package com.notebook.notebook.Service;

import java.util.List;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.User;

public interface BookService {
  List<Book> getAllbook(User user, Book book);

  List<Page> getPageOfBook(User user, Book book);

  Book createBook(Book book);

  Book updateBook(User user, Integer bookId);

  void deleteBook(User user, Integer bookId);

  List<Book> search(User user, String bookName);

  Book getBook(User user, Integer bookId);
}

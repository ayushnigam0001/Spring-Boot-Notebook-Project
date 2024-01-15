package com.notebook.notebook.Service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.User;
import com.notebook.notebook.Service.BookService;
import com.notebook.notebook.repository.BookRepository;
import com.notebook.notebook.repository.PageRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private PageRepository pageRepository;

  @Override
  public List<Book> getAllbook(User user, Book book) {
    return null;
  }

  @Override
  public Book updateBook(User user, Integer bookId) {
    Book book = bookRepository.findByUserAndBookId(user, bookId);
    Book bookSaved = bookRepository.save(book);
    return bookSaved;
  }

  @Override
  public void deleteBook(User user, Integer bookId) {
    Book book = bookRepository.findByUserAndBookId(user, bookId);
    bookRepository.delete(book);
  }

  @Override
  public Book createBook(Book book) {
    Book bookSaved = bookRepository.save(book);
    return bookSaved;
  }

  @Override
  public List<Page> getPageOfBook(User user, Book book) {
    return pageRepository.findByUserAndBook(user, book);
  }

  @Override
  public List<Book> search(User user, String bookName) {
    List<Book> books = bookRepository.findByUserAndBookNameContaining(user, bookName);
    return books;
  }

  @Override
  public Book getBook(User user, Integer bookId) {
    Book book = bookRepository.findByUserAndBookId(user, bookId);
    return book;
  }

}

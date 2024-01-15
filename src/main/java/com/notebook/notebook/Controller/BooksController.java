package com.notebook.notebook.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.User;
import com.notebook.notebook.Service.serviceImpl.BookServiceImpl;
import com.notebook.notebook.helper.CurrentSession;
import com.notebook.notebook.payload.RequestDto.BookRequestDto;
import com.notebook.notebook.payload.ResponseDto.BookResponseDto;

@RestController
@RequestMapping("/book")
public class BooksController {

  @Autowired
  private BookServiceImpl bookServiceImpl;

  @PostMapping("/create")
  public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
    Book book = bookRequestDto.buildBook(bookRequestDto);
    User user = (User) CurrentSession.getLoggedInUser();
    book.setUser(user);
    Book bookRes = bookServiceImpl.createBook(book);
    return BookResponseDto.buildDto(bookRes);
  }

  @GetMapping("/search")
  public List<BookResponseDto> searchBook(@RequestParam(name = "book") String bookName) {
    User user = (User) CurrentSession.getLoggedInUser();
    List<Book> books = bookServiceImpl.search(user, bookName);
    List<BookResponseDto> bookrResponseDtos = books.stream().map((book) -> BookResponseDto.buildDto(book))
        .collect(Collectors.toList());
    return bookrResponseDtos;
  }

  @DeleteMapping("/remove")
  public void deleteBook(@RequestParam("id") Integer bookId) {
    User user = (User) CurrentSession.getLoggedInUser();
    this.bookServiceImpl.deleteBook(user, bookId);
  }

  @PutMapping("/change")
  public BookResponseDto updateBook(@RequestParam("id") Integer bookId) {
    User user = (User) CurrentSession.getLoggedInUser();
    Book book = bookServiceImpl.updateBook(user, bookId);
    BookResponseDto bookResponseDto = BookResponseDto.buildDto(book);
    return bookResponseDto;
  }

  @GetMapping
  public BookResponseDto getBook(@RequestParam("id") Integer bookId) {
    User user = (User) CurrentSession.getLoggedInUser();
    Book book = bookServiceImpl.getBook(user, bookId);
    BookResponseDto bookResponseDto = BookResponseDto.buildDto(book);
    return bookResponseDto;
  }
}

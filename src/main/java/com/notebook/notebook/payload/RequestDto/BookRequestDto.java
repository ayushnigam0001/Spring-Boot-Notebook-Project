package com.notebook.notebook.payload.RequestDto;

import com.notebook.notebook.Model.Book;

import lombok.Data;

@Data
public class BookRequestDto {
  private int bookId;

  private String bookName;

  private String bookDescription;

  private String imageUrl;

  public Book buildBook(BookRequestDto bookRequestDto) {
    Book book = new Book();
    book.setBookId(bookRequestDto.getBookId());
    book.setBookName(bookRequestDto.getBookName());
    book.setBookDescription(bookRequestDto.getBookDescription());
    book.setImageUrl(bookRequestDto.getImageUrl());
    return book;
  }
}

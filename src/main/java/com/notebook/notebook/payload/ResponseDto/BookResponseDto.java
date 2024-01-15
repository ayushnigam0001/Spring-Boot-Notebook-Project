package com.notebook.notebook.payload.ResponseDto;

import com.notebook.notebook.Model.Book;

import lombok.Data;

@Data
public class BookResponseDto {
  private int bookId;

  private String bookName;

  private String bookDescription;

  private String imageUrl;

  public static BookResponseDto buildDto(Book book) {
    BookResponseDto bookResponseDto = new BookResponseDto();
    bookResponseDto.setBookId(book.getBookId());
    bookResponseDto.setBookName(book.getBookName());
    bookResponseDto.setBookDescription(book.getBookDescription());
    bookResponseDto.setImageUrl(book.getImageUrl());
    return bookResponseDto;
  }
}

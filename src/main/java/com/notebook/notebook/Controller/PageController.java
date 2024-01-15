package com.notebook.notebook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.User;
import com.notebook.notebook.Service.serviceImpl.PageServiceImpl;
import com.notebook.notebook.helper.CurrentSession;
import com.notebook.notebook.payload.RequestDto.PageRequestDto;
import com.notebook.notebook.payload.ResponseDto.PageResponseDto;

@RestController("/page")
public class PageController {

  @Autowired
  private PageServiceImpl pageServiceImpl;

  @PostMapping("/create")
  public PageResponseDto createPage(@RequestBody PageRequestDto pageRequestDto, @RequestParam("user") String username,
      @RequestParam("bookid") Integer bookId) {
    User user = (User) CurrentSession.getLoggedInUser();
    Page page = PageRequestDto.buildPage(pageRequestDto);
    Page pageRes = pageServiceImpl.createPage(page, user, bookId);
    return PageResponseDto.buildPageResponseDto(pageRes);
  }

  @GetMapping
  public PageResponseDto getPage(@RequestParam("bookid") Integer bookId, @RequestParam("pageid") Integer pageid) {
    Page page = new Page();
    Book book = new Book();
    User user = (User) CurrentSession.getLoggedInUser();
    book.setBookId(bookId);
    page.setId(pageid);
    page.setBook(book);
    page.setUser(user);
    Page pageRes = pageServiceImpl.getPageOfBook(page);
    return PageResponseDto.buildPageResponseDto(pageRes);
  }

}

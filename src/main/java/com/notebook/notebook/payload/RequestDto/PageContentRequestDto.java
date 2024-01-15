package com.notebook.notebook.payload.RequestDto;

import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.PageContent;
import com.notebook.notebook.Model.User;

import lombok.Data;

@Data
public class PageContentRequestDto {
  private int id;

  private Page page;

  private String content;

  private User user;

  public PageContent buildPageContent(PageContentRequestDto pageContentRequestDto) {
    PageContent pageContent = new PageContent();
    pageContent.setId(pageContentRequestDto.getId());
    pageContent.setPage(pageContentRequestDto.getPage());
    pageContent.setContent(pageContentRequestDto.getContent());
    pageContent.setUser(pageContentRequestDto.getUser()); // set user by userdetails
    return pageContent;
  }
}

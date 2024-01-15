package com.notebook.notebook.payload.RequestDto;

import com.notebook.notebook.Model.Page;

import lombok.Data;

@Data
public class PageRequestDto {
  private int id;

  private int pageNo;

  private String pageTitle;

  public static Page buildPage(PageRequestDto pageRequestDto) {
    Page page = new Page();
    page.setId(pageRequestDto.getId());
    page.setPageNo(pageRequestDto.getPageNo());
    page.setPageTitle(pageRequestDto.getPageTitle());
    return page;
  }
}

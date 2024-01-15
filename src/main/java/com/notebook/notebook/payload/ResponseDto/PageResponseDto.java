package com.notebook.notebook.payload.ResponseDto;

import com.notebook.notebook.Model.Page;

import lombok.Data;

@Data
public class PageResponseDto {
  private int id;

  private int pageNo;

  private String pageTitle;

  public static PageResponseDto buildPageResponseDto(Page page) {
    PageResponseDto pageResponseDto = new PageResponseDto();
    pageResponseDto.setId(page.getId());
    pageResponseDto.setPageNo(page.getPageNo());
    pageResponseDto.setPageTitle(page.getPageTitle());
    return pageResponseDto;
  }
}

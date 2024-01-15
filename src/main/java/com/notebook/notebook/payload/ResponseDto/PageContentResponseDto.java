package com.notebook.notebook.payload.ResponseDto;

import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.PageContent;

import lombok.Data;

@Data
public class PageContentResponseDto {
  private int id;

  private Page page;

  private String content;

  public PageContentResponseDto pageContentResponseDto(PageContent pageContent) {
    PageContentResponseDto pageContentResponseDto = new PageContentResponseDto();
    pageContentResponseDto.setId(pageContent.getId());
    pageContentResponseDto.setPage(pageContent.getPage());
    pageContentResponseDto.setContent(pageContent.getContent());
    return pageContentResponseDto;
  }

}

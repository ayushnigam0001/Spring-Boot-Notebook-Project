package com.notebook.notebook.Service;

import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.User;

public interface PageService {
  public Page createPage(Page page, User user, Integer bookId);

  public void deletePage(User user, Integer pageId);

  public void updatePage(User user, Page page);

  public Page getPageOfBook(Page page);

  public String getPageContent(Page page);
}

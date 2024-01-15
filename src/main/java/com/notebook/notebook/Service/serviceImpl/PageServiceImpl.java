package com.notebook.notebook.Service.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.notebook.Model.Book;
import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.PageContent;
import com.notebook.notebook.Model.User;
import com.notebook.notebook.Service.PageService;
import com.notebook.notebook.repository.BookRepository;
import com.notebook.notebook.repository.PageContentRepository;
import com.notebook.notebook.repository.PageRepository;

@Service
@Transactional
public class PageServiceImpl implements PageService {

  @Autowired
  private PageRepository pageRepository;

  @Autowired
  private PageContentRepository pageContentRepository;

  @Autowired
  private BookRepository bookRepository;

  @Override
  public Page createPage(Page page, User user, Integer bookId) {
    Book book = bookRepository.findByUserAndBookId(user, bookId);
    page.setBook(book);
    page.setUser(user);
    return pageRepository.save(page);
  }

  @Override
  public void deletePage(User user, Integer pageId) {
    Page page = pageRepository.findByUserAndPageNo(user, pageId);
    pageRepository.delete(page);
  }

  @Override
  public void updatePage(User user, Page page) {
    Page pageRes = pageRepository.findByUserAndPageNo(user, page.getId());
    pageRepository.save(pageRes); // user update api se page save kr sakata hai abhi
  }

  @Override
  public Page getPageOfBook(Page page) {
    Page resPage = pageRepository.findByIdAndUserAndBook(page.getId(), page.getUser(), page.getBook());
    // return id, pageTitle, pageNo
    return resPage;
  }

  @Override
  public String getPageContent(Page page) {
    PageContent pageContent = pageContentRepository.findByPageAndUser(page, page.getUser());
    return pageContent.getContent();
  }
}

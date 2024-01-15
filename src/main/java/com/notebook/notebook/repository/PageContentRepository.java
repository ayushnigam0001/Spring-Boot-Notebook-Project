package com.notebook.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.notebook.Model.Page;
import com.notebook.notebook.Model.PageContent;
import com.notebook.notebook.Model.User;

public interface PageContentRepository extends JpaRepository<PageContent, Integer> {
  PageContent findByPageAndUser(Page page, User user);
}

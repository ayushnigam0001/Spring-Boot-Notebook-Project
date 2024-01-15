package com.notebook.notebook.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Page {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "page_no")
  private int pageNo;

  @Column(name = "page_title", nullable = false)
  private String pageTitle;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "page")
  @JoinColumn(name = "page_content")
  private PageContent pageContent;

  @ManyToOne
  @JoinColumn(name = "book", nullable = false)
  @JsonIgnore
  private Book book;

  @ManyToOne
  @JoinColumn(name = "user", nullable = false)
  @JsonIgnore
  private User user;

  @Override
  public String toString() {
    return "Page [pageContent=" + pageContent + ", Id=" + id + ", pageNo=" + pageNo + ", pageTitle=" + pageTitle
        + "]";
  }

}

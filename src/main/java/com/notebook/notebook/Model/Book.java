package com.notebook.notebook.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int bookId;

  @Column(name = "book_name")
  private String bookName;

  @Column(name = "book_description")
  private String bookDescription;

  @Column(name = "book_image_url")
  private String imageUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user", nullable = false)
  @JsonIgnore
  private User user;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
  List<Page> pages;
}

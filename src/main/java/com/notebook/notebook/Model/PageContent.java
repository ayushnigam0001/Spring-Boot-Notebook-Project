package com.notebook.notebook.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class PageContent {

  @Id
  private int id;

  @OneToOne
  @JsonIgnore
  @JoinColumn(name = "page")
  private Page page;

  @Column(name = "content")
  private String content;

  @ManyToOne
  @JoinColumn(name = "user", nullable = false)
  @JsonIgnore
  private User user;
}

package com.notebook.notebook.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class SharedBook {

  @Id
  @Column(name = "share_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int shareId;

  @ManyToOne
  @JoinColumn(name = "user")
  private User user;

  @ManyToOne
  @JoinColumn(name = "book")
  private Book book;

  @Column(name = "has_edit_access")
  private boolean hasEditAccess;
}

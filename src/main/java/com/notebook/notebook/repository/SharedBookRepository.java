package com.notebook.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notebook.notebook.Model.SharedBook;

public interface SharedBookRepository extends JpaRepository<SharedBook, Integer> {

}

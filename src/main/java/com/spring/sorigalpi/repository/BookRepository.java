package com.spring.sorigalpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.sorigalpi.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
}

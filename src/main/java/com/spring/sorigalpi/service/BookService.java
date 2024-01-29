package com.spring.sorigalpi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sorigalpi.dto.BookDTO;
import com.spring.sorigalpi.entity.Book;
import com.spring.sorigalpi.repository.BookRepository;


@Service("bookService")
public class BookService {
	//@Autowired
	//private BookDTO bookDTO;
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBook(){ //동화책 테이블 모든 정보 가져오기
		return bookRepository.findAll();
	}
	
	public String createBook(BookDTO bookDTO) {
		bookDTO.setBookId(createRandomUuId());
		
		System.out.println(bookDTO.getBookId());
		
		return bookRepository.save(bookDTO.toEntity()).getBookId();
	}
	

	public String createRandomUuId() {	//UUID 생성
		
		String resultUuid = UUID.randomUUID().toString();
		
		System.out.println("uuid : "+resultUuid);
		
		return resultUuid;
	}
}

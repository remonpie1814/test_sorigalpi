package com.spring.sorigalpi.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sorigalpi.dto.BookDTO;
import com.spring.sorigalpi.entity.Book;
import com.spring.sorigalpi.repository.BookRepository;


@Service("bookService")
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBook(){ //동화책 테이블 모든 정보 가져오기
		return bookRepository.findAll();
	}
	
	public void createBook(BookDTO bookDTO) {
		bookRepository.save(bookDTO.toEntity());
	}
	
	
	public void createRandomStrusingUtilsRand() {
		
		String randomStr = RandomStringUtils.randomAlphanumeric(20);
		BookDTO book = new BookDTO();
		book.setBookId(RandomStringUtils.randomAlphanumeric(20));
		
		System.out.println("랜덤 문자열 : "+book.getBookId());
		
		
	}
}

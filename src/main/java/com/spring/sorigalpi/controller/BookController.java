package com.spring.sorigalpi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sorigalpi.dto.BookDTO;
import com.spring.sorigalpi.entity.Book;
import com.spring.sorigalpi.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Api(tags = "book")
@RestController("bookController")
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@ApiOperation(
			value = "동화책 테이블의 모든 정보 조회",
			notes = "동화책 테이블의 모든 정보를 불러오는 API") 
	@ApiResponse(code = 200, message = "성공")
	@GetMapping("/getAllBook") //동화책 테이블의 모든 정보 가져오기
	public ResponseEntity<BasicResponse> allBookList(){
			 
		List<Book> bookList = bookService.getAllBook();
		
		BasicResponse basicResponse =  BasicResponse.builder()
												.code(HttpStatus.OK.value())
												.httpStatus(HttpStatus.OK)
												.message("전체 사용자 조회 성공")
												.result(new ArrayList<>(bookList))
												.count(bookList.size()).build();
	
		return new ResponseEntity<>(basicResponse, HttpStatus.OK);
	}
	
	
	@PostMapping("/createBook")
	public void createBook(@RequestBody BookDTO bookDTO){
		bookService.createBook(bookDTO);
	
	}
	
	@GetMapping("/getRandom")
	public void test() {
		bookService.createRandomStrusingUtilsRand();
	}
	
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@ApiModel(value = "응답용")
	static class BasicResponse{ // response로 사용할 class
		
		private Integer code;
		private HttpStatus httpStatus;
		private String message;
		private Integer count;
		private List<Object> result;
		
	}
}

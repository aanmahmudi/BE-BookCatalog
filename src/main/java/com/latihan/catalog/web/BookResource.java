package com.latihan.catalog.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.catalog.dto.BookCreateDTO;
import com.latihan.catalog.dto.BookDetailDTO;
import com.latihan.catalog.dto.BookUpdateRequestDTO;
import com.latihan.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {
	
	private final BookService bookService;
	
	@GetMapping("/book/{bookId}")
	public BookDetailDTO findBookDetail(@PathVariable("bookId")Long id) {
		StopWatch stopWatch = new StopWatch();
		log.info("start findBookDetail "+ id);
		stopWatch.start();
		BookDetailDTO result = bookService.findBookDetailById(id);
		log.info("finish findBookDetailDTO. execution time = {}", stopWatch.getTotalTimeMillis());
		return result;
	}
	
	//POST
	@PostMapping("/book")
	public ResponseEntity<Void> createNewBook(@RequestBody BookCreateDTO dto){
		bookService.createNewBook(dto);
		return ResponseEntity.created(URI.create("/book")).build();
	}
	
	//GET
	@GetMapping("/book")
	public ResponseEntity<List<BookDetailDTO>> findBookList(){
		return ResponseEntity.ok().body(bookService.findBookListDetail());
	}
	
	//PUT
	@PutMapping("/book/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId,
			@RequestBody BookUpdateRequestDTO dto){
		bookService.updateBook(bookId, dto);
		return ResponseEntity.ok().build();
	}
	
	//DELETE
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId){
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();
	}
	

}

package com.latihan.catalog.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.latihan.catalog.domain.Author;
import com.latihan.catalog.domain.Book;
import com.latihan.catalog.repository.BookRepository;
import com.latihan.catalog.repository.impl.BookRepositoryImpl;


@Configuration
public class AppConfig {
	
	@Bean
	public Author author() {
		return new Author(1L, "Aan Mahmudi",null);
	}
	
	@Bean
	public Book book1(Author author) {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("Manusia Serakah");
		book.setDescription("Manusia serakah adalah sebuah karya novel dari Aan Mahmudi");
		book.setAuthor(author);
		return book;
	}
	
	@Bean
	public Book book2(Author author) {
		Book book = new Book();
		book.setId(2L);
		book.setTitle("Tobat Sambel");
		book.setDescription("Tobat Sambel adalah sebuah karya novel dari Aan Mahmudi");
		book.setAuthor(author);
		return book;
	}
	
	@Bean
	public BookRepository bookRepository(@Qualifier("book1") Book book1,@Qualifier("book2") Book book2) {
		Map<Long, Book> bookMap = new HashMap<Long, Book>();
		bookMap.put(1L, book1);
		bookMap.put(2L, book2);
		
		BookRepositoryImpl bookRepository = new BookRepositoryImpl();
		bookRepository.setBookMap(bookMap);
		
		return bookRepository;
	}
	
	
	
	

}

package com.latihan.catalog.repository;

import java.util.List;

import com.latihan.catalog.domain.Book;

public interface BookRepository {
	public Book findBookById(Long id);
	
	public List<Book> findAll();
	
	public void save(Book book);
	
	public void update(Book book);
	
	public void delete(Long bookId);

}

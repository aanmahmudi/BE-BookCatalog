package com.latihan.catalog.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.latihan.catalog.domain.Book;
import com.latihan.catalog.repository.BookRepository;

import lombok.Data;
@Data

public class BookRepositoryImpl implements BookRepository {
	private Map<Long, Book> bookMap;

	@Override
	public Book findBookById(Long id) {
		Book book = bookMap.get(id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>(bookMap.values());
		return bookList;
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		int size = bookMap.size();
		book.setId((long)size+1);
		bookMap.put(book.getId(), book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookMap.put(book.getId(), book);
		
	}

	@Override
	public void delete(Long bookId) {
		// TODO Auto-generated method stub
		bookMap.remove(bookId);
		
	}

}

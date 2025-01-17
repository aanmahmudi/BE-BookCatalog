package com.latihan.catalog.service;

import java.util.List;

import com.latihan.catalog.dto.BookCreateDTO;
import com.latihan.catalog.dto.BookDetailDTO;
import com.latihan.catalog.dto.BookUpdateRequestDTO;

public interface BookService {
	
	public BookDetailDTO findBookDetailById(Long bookId);
	
	public List<BookDetailDTO> findBookListDetail();
	
	public void createNewBook(BookCreateDTO dto);
	
	public void updateBook(Long bookId, BookUpdateRequestDTO dto);
	
	public void deleteBook(Long bookId);
}

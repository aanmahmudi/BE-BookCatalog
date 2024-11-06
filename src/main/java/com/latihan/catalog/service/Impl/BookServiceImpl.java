package com.latihan.catalog.service.Impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.latihan.catalog.domain.Author;
import com.latihan.catalog.domain.Book;
import com.latihan.catalog.dto.BookCreateDTO;
import com.latihan.catalog.dto.BookDetailDTO;
import com.latihan.catalog.dto.BookUpdateRequestDTO;
import com.latihan.catalog.repository.BookRepository;
import com.latihan.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Override
	public BookDetailDTO findBookDetailById(Long bookId) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findBookById(bookId);
		BookDetailDTO dto = new BookDetailDTO();
		dto.setBookId(book.getId());
		dto.setAuthorName(book.getAuthor().getName());
		dto.setBookTitle(book.getTitle());
		dto.setDescription(book.getDescription());
		return dto;
		
	}

	@Override
	public List<BookDetailDTO> findBookListDetail() {
		// TODO Auto-generated method stub
		List<Book> books = bookRepository.findAll();
		return books.stream().map((b)->{
			BookDetailDTO dto = new BookDetailDTO();
			dto.setAuthorName(b.getAuthor().getName());
			dto.setDescription(b.getDescription());
			dto.setBookId(b.getId());
			dto.setBookTitle(b.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void createNewBook(BookCreateDTO dto) {
		// TODO Auto-generated method stub
		Author author = new Author();
		author.setName(dto.getAuthorName());
		
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Long bookId, BookUpdateRequestDTO dto) {
		// TODO Auto-generated method stub
		//get book form repository
		Book book = bookRepository.findBookById(bookId);
		//update
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());
		//save
		bookRepository.update(book);
		
	}

	@Override
	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		bookRepository.delete(bookId);
	}


//	public BookRepository getBookRepository() {
//		return bookRepository;
//	}
//
//	public void setBookRepository(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}
	

}

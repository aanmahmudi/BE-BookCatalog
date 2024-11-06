package com.latihan.catalog.service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.latihan.catalog.domain.Author;
import com.latihan.catalog.dto.AuthorCreateRequestDTO;
import com.latihan.catalog.dto.AuthorResponseDTO;
import com.latihan.catalog.dto.AuthorUpdateRequestDTO;
import com.latihan.catalog.repository.AuthorRepository;
import com.latihan.catalog.service.AuthorService;
import com.subrutin.catalog.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	@Override
	public AuthorResponseDTO findAuthorById(Long id) {
		// TODO Auto-generated method stub
		// 1. fetch data from database
		Author author = authorRepository.findById(id).orElseThrow(() -> new BadRequestException("Invalid.authorId"));
		// 2. author -> authorRepository
		AuthorResponseDTO dto = new AuthorResponseDTO();
		dto.setAuthorName(author.getName());
		dto.setBirthDate(author.getBirthDate().toEpochDay());
		return dto;
	}

	@Override
	public void createNewAuthor(List<AuthorCreateRequestDTO> dtos) {
		// TODO Auto-generated method stub

		List<Author> authors = dtos.stream().map((dto) -> {
			Author author = new Author();
			author.setName(dto.getAuthorName());
			author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
			return author;
		}).collect(Collectors.toList());

		authorRepository.saveAll(authors);
	}

	@Override
	public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto) {
		// TODO Auto-generated method stub
		Author author = authorRepository.findById(authorId)
				.orElseThrow(() -> new BadRequestException("Invalid.authorId"));
		author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
		author.setBirthDate(
				dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));

		authorRepository.save(author);
	}

}

package com.latihan.catalog.service;

import java.util.List;

import com.latihan.catalog.dto.AuthorCreateRequestDTO;
import com.latihan.catalog.dto.AuthorResponseDTO;
import com.latihan.catalog.dto.AuthorUpdateRequestDTO;


public interface AuthorService {
	
	public AuthorResponseDTO findAuthorById(Long id);
	
	public void createNewAuthor(List<AuthorCreateRequestDTO> dtos);
	
	public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto);

}

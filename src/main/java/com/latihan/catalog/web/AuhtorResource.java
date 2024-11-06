package com.latihan.catalog.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.catalog.dto.AuthorCreateRequestDTO;
import com.latihan.catalog.dto.AuthorResponseDTO;
import com.latihan.catalog.dto.AuthorUpdateRequestDTO;
import com.latihan.catalog.service.AuthorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AuhtorResource {

	private final AuthorService authorService;

	// authorDetail
	@GetMapping("/author/{id}/detail")
	public ResponseEntity<AuthorResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(authorService.findAuthorById(id));
	}

	@PostMapping("/author")
	public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dto) {
		authorService.createNewAuthor(dto);
		return ResponseEntity.created(URI.create("/author")).build();
	}
	
	@PutMapping("/author/{authorId}")
	public ResponseEntity<Void> updateAuthor (@PathVariable Long authorId, 
			@RequestBody AuthorUpdateRequestDTO dto){
		authorService.updateAuthor(authorId, dto);
		return ResponseEntity.ok().build();
	}

}

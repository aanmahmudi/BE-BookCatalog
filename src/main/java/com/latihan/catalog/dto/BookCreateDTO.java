package com.latihan.catalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookCreateDTO {
	
	
	@NotBlank
	private String bookTitle;
	
	@NotBlank
	private String authorName;
	
	@JsonProperty("synopsis")
	private String description;

}

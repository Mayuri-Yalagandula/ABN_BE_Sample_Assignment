package com.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@Builder

public class Recipe {
	
	@Id
	private String id;
	private String name;
	private LocalDateTime created;
	private boolean vegan;
	private int servings;
	private List<String> ingredients;
	private String instructions;

}

package com.data;

 import com.model.Recipe;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
 
 public interface RecipeRepository extends ReactiveMongoRepository<Recipe, String>{

	Flux<Recipe> findAll();

	Mono<Recipe> findById(String id);

	Mono<Void> deleteById(String id);
	

	
	 
 }

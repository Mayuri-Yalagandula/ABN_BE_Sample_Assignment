package com.controller;

import lombok.RequiredArgsConstructor;
import com.model.Recipe;
import com.service.RecipeService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.pulblisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor

public class RecipeHandler {
	 
	private final RecipeService service = new RecipeService();
	
	public Mono<ServerResponse> getAll(ServerRequest request){
		Flux<Recipe> recipes= service.getAll();
		
		return ok().contentType(APPLICATION_JSON)
				.body(recipes, Recipe.class);
	}
	
	public Mono<ServerResponse> get(ServerRequest request){
		String id= request.pathVariable("id");
		Mono<Recipe> recipe= service.get(id);
		
		return ok().contentType(APPLICATION_JSON)
				.body(recipe, Recipe.class)
				.switchIfEmpty(notFound().build());
	}
	
	public Mono<ServerResponse> create(ServerRequest request){
		Mono<Recipe> recipe = service.create(request.bodyToMono(Recipe.class));
		
		return ok().contentType(APPLICATION_JSON)
				.body(recipe, Recipe.class);
	}
	
	public Mono<ServerResponse> update(ServerRequest request){
		Mono<Recipe> recipe = service.update(request.bodyToMono(Recipe.class));
		
		return ok().contentType(APPLICATION_JSON)
				.body(recipe, Recipe.class);
	}
	
	public Mono<ServerResponse> delete(ServerRequest request){
		String id = request.pathVariable("id");
		Mono<Void> result = service.delete(id);
		
		return ok().build(result);
	}

}

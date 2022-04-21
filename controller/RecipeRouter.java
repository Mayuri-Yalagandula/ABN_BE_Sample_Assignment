package com.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFUnction;
import org.springframework.web.reactive.function.server.RouterFUnctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATIO_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@Configuration
public class RecipeRouter {
	
	private static final String RECIPES_RESOURCE="/recipes";
	@Bean
	public RouterFunction<ServerResponse> route(RecipeHandler handler){
		return RouterFunctions.route()
				.nest(path(RECIPES_RESOURCE).and(accept(APPLICATION_JSON)), builder -> builder
						.GET("", handler::getAll)
						.GET("/{id}", handler::get)
						.POST("", handler::create)
						.PUT("", handler::update)
						.DELETE("/{id}", handler::delete)
						).build();
	}

}

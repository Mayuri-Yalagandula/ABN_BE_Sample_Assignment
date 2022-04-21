package com.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.model.Recipe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j

public class RecipeDataInit implements CommandLineRunner{
	
	private final RecipeRepository repository;
	
	@Override
	public void run(String... args) {
		List<String> ingredients = List.of(
				"1 onion",
				"1 carrot",
				"3 chestnut mushrooms",
				"1 lb minced beef",
				"2 cloves garlic",
				"1/2 cup red wine",
				"3 tbsp tomato puree",
				"1 beef stock cube",
				"1/2 tbs salt",
				"1/2 tbs black pepper",
				"10 1/2 dried spaghetti or fresh pasta"
				);
		
		String instructions = 
				"Heat the oil in a frying pan over a medium-high heat. Add the onion and cook for 5 minutes, stirring often, until the onion softens.\n"
				+ "Add the garlic and cook for a further minute.\n"
				+ "Add the carrot and mushroom and cook for a further 2-3 minutes.\n"
				+ "Add the minced beef and cook for 5-6 further minutes, until browned. Stir often, breaking up any large chunks of meat with a spatula.\n"
				+ "Add the wine. Bring to the boil and let it bubble for 2-3 minutes, until reduced by three quarters.\n"
				+ "Add the tomato puree, beef stock cube, tinned tomatoes, salt and pepper. Stir and bring to the boil. Turn down the heat and simmer for 15-20 minutes until thickened.\n"
				+ "Meanwhile, boiled a large pan of salted water. Add the spaghetti and cook for 10-12 minutes until al dente.\n"
				+ "Drain the spaghetti and divide between 6 bowls.\n"
				+ "Spoon the bolognese on top of the spaghetti.\n";
		
		Recipe recipe= Recipe.builder()
				.name("Spaghetti Bolognese")
				.created(LocalDateTime.now())
				.vegan(false)
				.serving(4)
				.ingredients(ingredients)
				.instructions(instructions)
				.build();
		
		repository.save(recipe)
		        .map(Recipe::toString)
		        .subscribe(log::info);
	}

}

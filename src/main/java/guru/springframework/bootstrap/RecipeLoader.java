package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMesureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Component
@Slf4j
public class RecipeLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMesureRepository unitOfMesureRepository;


    public RecipeLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMesureRepository unitOfMesureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("load recipes");
        loadRecipes();
    }

    void loadRecipes() {
        Set<Category> guacamoleCategories = new HashSet<>();
        Recipe guacamole = new Recipe();
        Note guacamoleNotes = new Note(guacamole);

        guacamoleCategories.add(categoryRepository.findByDescription("Dip").get());
        guacamoleCategories.add(categoryRepository.findByDescription("Mexican").get());
        guacamoleCategories.add(categoryRepository.findByDescription("Vegan").get());
        guacamoleCategories.add(categoryRepository.findByDescription("Avocado").get());

        guacamoleNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after \n" +
                "handling and do not touch your eyes or the area near your eyes with your hands for several hours.");

        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), unitOfMesureRepository.findByDescription("Each").get()));
        guacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(0.5), unitOfMesureRepository.findByDescription("Teaspoon").get()));
        guacamole.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), unitOfMesureRepository.findByDescription("Tablespoon").get()));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(0.25), unitOfMesureRepository.findByDescription("Cup").get()));
        guacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), unitOfMesureRepository.findByDescription("Each").get()));
        guacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), unitOfMesureRepository.findByDescription("Tablespoon").get()));
        guacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), unitOfMesureRepository.findByDescription("Dash").get()));
        guacamole.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), unitOfMesureRepository.findByDescription("Each").get()));


        guacamole.setDescription("Perfect Guacamole");
        guacamole.setCategories(guacamoleCategories);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setServings(4);
        guacamole.setNote(guacamoleNotes);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. \n" +
                "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. \n" +
                "(See How to Cut and Peel an Avocado.) Place in a bowl. \n\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.) \n\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. \n" +
                "The acid in the lime juice will provide some balance to the richness of the avocado \n" +
                "and will help delay the avocados from turning brown.\n\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary \n" +
                "individually in their hotness. So, start with a half of one chili pepper and add \n" +
                "to the guacamole to your desired degree of hotness.\n\n" +
                "Remember that much of this is done to taste because of the variability in the fresh \n" +
                "ingredients. Start with this recipe and adjust to your taste.\n\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the \n" +
                "guacamole cover it and to prevent air reaching it. (The oxygen in the air causes \n" +
                "oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n\n" +
                "Variations\n\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks \n" +
                "of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack \n" +
                "of availability of other ingredients stop you from making guacamole.\n\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your \n" +
                "guacamole dip. Purists may be horrified, but so what? It tastes great.");

        recipeRepository.save(guacamole);

        Set<Category> chickenTacosCategories = new HashSet<>();
        Recipe chickenTacos = new Recipe();
        Note chickenTacosNotes = new Note(chickenTacos);

        chickenTacosCategories.add(categoryRepository.findByDescription("Dinner").get());
        chickenTacosCategories.add(categoryRepository.findByDescription("Grill").get());
        chickenTacosCategories.add(categoryRepository.findByDescription("Quick And Easy").get());
        chickenTacosCategories.add(categoryRepository.findByDescription("Chicken").get());

        chickenTacosNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on Amazon. \n" +
                "(If you can't find ancho chili powder, you replace the ancho chili, the oregano, \n" +
                "and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor \n" +
                "won't be quite the same.)");

        chickenTacos.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), unitOfMesureRepository.findByDescription("Tablespoon").get()));
        chickenTacos.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), unitOfMesureRepository.findByDescription("Teaspoon").get()));
        chickenTacos.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), unitOfMesureRepository.findByDescription("Teaspoon").get()));
        chickenTacos.addIngredient(new Ingredient("sugar", new BigDecimal(1), unitOfMesureRepository.findByDescription("Teaspoon").get()));
        chickenTacos.addIngredient(new Ingredient("salt", new BigDecimal(0.5), unitOfMesureRepository.findByDescription("Teaspoon").get()));
        chickenTacos.addIngredient(new Ingredient("garlic clove, finely chopped", new BigDecimal(1), unitOfMesureRepository.findByDescription("Each").get()));
        chickenTacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), unitOfMesureRepository.findByDescription("Tablespoon").get()));
        chickenTacos.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), unitOfMesureRepository.findByDescription("Tablespoon").get()));
        chickenTacos.addIngredient(new Ingredient("olive oil", new BigDecimal(2), unitOfMesureRepository.findByDescription("Tablespoon").get()));
        chickenTacos.addIngredient(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(1.25), unitOfMesureRepository.findByDescription("Pound").get()));
        chickenTacos.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), unitOfMesureRepository.findByDescription("Each").get()));
        chickenTacos.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), unitOfMesureRepository.findByDescription("Cup").get()));
        chickenTacos.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), unitOfMesureRepository.findByDescription("Each").get()));
        chickenTacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), unitOfMesureRepository.findByDescription("Each").get()));
        chickenTacos.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(0.5), unitOfMesureRepository.findByDescription("Pint").get()));
        chickenTacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(0.25), unitOfMesureRepository.findByDescription("Each").get()));
        chickenTacos.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), unitOfMesureRepository.findByDescription("Cup").get()));
        chickenTacos.addIngredient(new Ingredient("sour cream", new BigDecimal(0.5), unitOfMesureRepository.findByDescription("Cup").get()));
        chickenTacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(1), unitOfMesureRepository.findByDescription("Each").get()));

        chickenTacos.setDescription("Spicy Grilled Chicken Tacos");
        chickenTacos.setCategories(chickenTacosCategories);
        chickenTacos.setDifficulty(Difficulty.EASY);
        chickenTacos.setPrepTime(20);
        chickenTacos.setCookTime(15);
        chickenTacos.setServings(6);
        chickenTacos.setNote(chickenTacosNotes);
        chickenTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together \n" +
                "the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in \n" +
                "the orange juice and olive oil to make a loose paste. Add the chicken to the \n" +
                "bowl and toss to coat all over.\n\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a \n" +
                "thermometer inserted into the thickest part of the meat registers 165F. \n" +
                "Transfer to a plate and rest for 5 minutes.\n\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet \n" +
                "over medium-high heat. As soon as you see pockets of the air start to puff \n" +
                "up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a \n" +
                "small handful of arugula. Top with chicken slices, sliced avocado, radishes, \n" +
                "tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime \n" +
                "edges");

        recipeRepository.save(chickenTacos);

    }

}

package guru.springframework.services;

import guru.springframework.model.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> getAllRecipes() {
        Set<Recipe> recipeList = new HashSet<>();

        recipeRepository.findAll().forEach(recipe -> recipeList.add(recipe));
        return recipeList;
    }

    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }
}

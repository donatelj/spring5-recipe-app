package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMesureRepository;
import guru.springframework.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMesureRepository unitOfMesureRepository;
    private RecipeServiceImpl recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMesureRepository unitOfMesureRepository, RecipeServiceImpl recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}

package YearUp.pluralsight.NorthwindTradersAPI.controllers;

import YearUp.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController
{
    private final List<Category> categories = new ArrayList<>();

    public CategoriesController()
    {
        categories.add(new Category(1, "Fruits"));
        categories.add(new Category(2, "Vegetables"));
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories()
    {
        return categories;
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId)
    {
        Optional<Category> category = categories.stream().filter(c -> c.getCategoryId() == categoryId).findFirst();
        return category.orElse(null);
    }
}
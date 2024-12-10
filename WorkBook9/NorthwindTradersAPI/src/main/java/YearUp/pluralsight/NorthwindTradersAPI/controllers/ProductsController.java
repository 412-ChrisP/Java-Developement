package YearUp.pluralsight.NorthwindTradersAPI.controllers;

import YearUp.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController
{

    // Temporary list of products
    private final List<Product> products = new ArrayList<>();

    public ProductsController()
    {
        products.add(new Product(1, "Apple", 1, 0.5));
        products.add(new Product(2, "Banana", 1, 0.3));
        products.add(new Product(3, "Carrot", 2, 0.7));
        products.add(new Product(4, "Broccoli", 2, 1.0));
        products.add(new Product(5, "Orange", 1, 0.6));
    }

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return products;
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId)
    {
        Optional<Product> product = products.stream().filter(p -> p.getProductId() == productId).findFirst();
        return product.orElse(null);
    }
}

package YearUp.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (!product.isOutOfStock()) {
            products.add(product);
            product.reduceStock(1);
            System.out.println(product.getName() + " added to cart. Remaining stock: " + product.getStock());
        } else {
            System.out.println("Sorry, " + product.getName() + " is out of stock.");
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " removed from cart.");
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void displayCart() {
        if (isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            for (Product product : products) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        }
    }
}


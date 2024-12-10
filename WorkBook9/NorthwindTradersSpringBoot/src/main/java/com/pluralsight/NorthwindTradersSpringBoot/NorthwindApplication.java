package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.DAO.Impl.SimpleProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.DAO.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner
{
    @Autowired
    private SimpleProductDAO productDao;

    @Override
    public void run(String... args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("    1. List Products");
            System.out.println("    2. Add Product");
            System.out.println("    3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void listProducts()
    {
        List<Product> products = productDao.getAll();
        System.out.println("\nList of Products:");
        for (Product product : products)
        {
            System.out.println("ID: " + product.getProductId() +
                    ", Name: " + product.getProductName() +
                    ", Category: " + product.getCategoryId() +
                    ", Price: $" + product.getUnitPrice());
        }
    }

    private void addProduct(Scanner scanner)
    {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product category: ");
        int category = scanner.nextInt();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        int productId = productDao.getAll().size() + 1;
        Product newProduct = new Product(productId, name, category, price);
        productDao.insert(newProduct);

        System.out.println("Product added with ID: " + productId);
    }
}
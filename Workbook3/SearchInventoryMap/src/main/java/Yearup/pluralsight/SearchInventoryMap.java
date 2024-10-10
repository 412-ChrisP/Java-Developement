package Yearup.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchInventoryMap
{
    public static void main(String[] args)
    {
        Map<String, Product> inventory = loadInventory();

        if (inventory.isEmpty())
        {
            System.out.println("No products found.");
            return;
        }

        Scanner input = new Scanner(System.in);
        boolean continueSearch = true;

        while (continueSearch)
        {
            System.out.println("What do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Lookup a product by name");
            System.out.println("6- Quit the application");
            System.out.print("Enter command: ");
            int command = input.nextInt();
            input.nextLine();

            switch (command)
            {
                case 1:
                    listAllProducts(inventory);
                    break;
                case 2:
                    lookupProductById(inventory, input);
                    break;
                case 3:
                    findProductsByPriceRange(inventory, input);
                    break;
                case 4:
                    addNewProduct(inventory, input);
                    break;
                case 5:
                    searchProductByName(inventory, input);
                    break;
                case 6:
                    continueSearch = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
        input.close();
    }

    private static Map<String, Product> loadInventory()
    {
        Map<String, Product> inventory = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2]);
                inventory.put(name.toLowerCase(), new Product(id, name, price));
            }
        } catch (Exception e)
        {
            System.out.println("Error reading inventory: " + e.getMessage());
        }
        return inventory;
    }

    private static void listAllProducts(Map<String, Product> inventory)
    {
        inventory.values().forEach(System.out::println);
    }

    private static void lookupProductById(Map<String, Product> inventory, Scanner input)
    {
        System.out.print("Enter product id: ");
        int id = input.nextInt();
        input.nextLine();
        boolean found = false;
        for (Product product : inventory.values())
        {
            if (product.getId() == id)
            {
                System.out.println(product);
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Product not found.");
        }
    }

    private static void findProductsByPriceRange(Map<String, Product> inventory, Scanner input)
    {
        System.out.print("Enter minimum price: ");
        double minPrice = input.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = input.nextDouble();
        input.nextLine();
        inventory.values().stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .forEach(System.out::println);
    }

    private static void addNewProduct(Map<String, Product> inventory, Scanner input)
    {
        System.out.print("Enter product id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter product name: ");
        String name = input.nextLine();
        System.out.print("Enter product price: ");
        double price = input.nextDouble();
        input.nextLine();
        inventory.put(name.toLowerCase(), new Product(id, name, price));
        System.out.println("Product added.");
    }

    private static void searchProductByName(Map<String, Product> inventory, Scanner input)
    {
        System.out.print("Enter product name to search: ");
        String searchName = input.nextLine().toLowerCase();
        Product product = inventory.get(searchName);
        if (product != null)
        {
            System.out.println("Found: " + product);
        } else
        {
            System.out.println("Product not found with name: " + searchName);
        }
    }
}

package YearUp.pluralsight;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Store
{
    private static final HashMap<String, Double> discountCodes = new HashMap<>();
    private static final HashMap<String, User> users = new HashMap<>();
    private static User currentUser;
    private static final ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args)
    {
        initializeStore();

        Scanner scanner = new Scanner(System.in);
        boolean authenticated = false;

        while (!authenticated)
        {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Check if the user already exists
            if (users.containsKey(username))
            {
                currentUser = users.get(username);
                // Validate password
                if (currentUser.validatePassword(password))
                {
                    System.out.println("Welcome back, " + username + "!");
                    authenticated = true;
                } else
                {
                    System.out.println("Incorrect password. Please try again.");
                }
            } else
            {
                // Create a new user account if the username doesn't exist
                currentUser = new User(username, password);
                users.put(username, currentUser);
                System.out.println("New account created for " + username);
                authenticated = true;
            }
        }

        ShoppingCart cart = currentUser.getCart();
        boolean shopping = true;

        while (shopping)
        {
            System.out.println("\n1. Browse Products by Category");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. View Order History");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Filter by: 1. Electronics  2. Clothing");
                    int categoryChoice = scanner.nextInt();
                    switch (categoryChoice)
                    {
                        case 1:
                            System.out.println("Electronics:");
                            displayProductsByCategory("Electronics");
                            break;
                        case 2:
                            System.out.println("Clothing:");
                            displayProductsByCategory("Clothing");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }

                    System.out.print("Select the product index to add to cart or enter -1 to cancel: ");
                    int productIndex = scanner.nextInt();

                    // Option to exit the product selection
                    if (productIndex == -1)
                    {
                        System.out.println("Exiting product selection...");
                        break;
                    }

                    if (productIndex >= 0 && productIndex < products.size())
                    {
                        Product selectedProduct = products.get(productIndex);
                        cart.addProduct(selectedProduct);
                    } else
                    {
                        System.out.println("Invalid product selection.");
                    }

                    break;

                case 2:
                    cart.displayCart();
                    break;

                case 3:
                    System.out.print("Enter discount code (or press enter to skip): ");
                    scanner.nextLine();
                    String discountCode = scanner.nextLine();
                    double discount = getDiscount(discountCode);
                    try
                    {
                        checkout(cart, discount);
                        currentUser.addOrder("Order placed for total: $" + cart.getTotalPrice());
                        shopping = false;
                    } catch (CheckoutException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    currentUser.displayOrderHistory();
                    break;

                case 5:
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Thank you for shopping with us!");
        scanner.close();
    }

    private static void initializeStore()
    {
        // Initialize discount codes
        discountCodes.put("SAVE10", 0.10);
        discountCodes.put("BLACKFRIDAY", 0.20);
        discountCodes.put("FREESHIP", 0.05);

        // Sample products
        products.add(new Electronics("Laptop", 999.99, 5, 2));
        products.add(new Clothing("T-Shirt", 19.99, 10, "L"));
        products.add(new Electronics("Smartphone", 699.99, 3, 1));
        products.add(new Clothing("Jeans", 49.99, 7, "M"));
    }

    public static double getDiscount(String code)
    {
        if (discountCodes.containsKey(code))
        {
            System.out.println("Discount code applied: " + (discountCodes.get(code) * 100) + "% off.");
            return discountCodes.get(code);
        } else if (code.isEmpty())
        {
            return 0;
        } else
        {
            System.out.println("Invalid discount code.");
            return 0;
        }
    }

    public static void checkout(ShoppingCart cart, double discount) throws CheckoutException
    {
        if (cart.isEmpty())
        {
            throw new CheckoutException("Cannot proceed with checkout: The cart is empty.");
        }
        double totalPrice = cart.getTotalPrice();
        totalPrice -= totalPrice * discount; // Apply discount
        System.out.println("\nTotal price after discount: $" + totalPrice);
        System.out.println("Proceeding to checkout...");
    }

    public static void displayProductsByCategory(String category)
    {
        int index = 0;
        for (Product product : products)
        {
            if (product.getProductCategory().equalsIgnoreCase(category))
            {
                System.out.println(index + ". " + product.getName() + " - $" + product.getPrice());
            }
            index++;
        }
    }
}
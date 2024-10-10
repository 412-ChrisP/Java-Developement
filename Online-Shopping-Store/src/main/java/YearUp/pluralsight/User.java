package YearUp.pluralsight;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;  // Added password attribute
    private ShoppingCart cart;
    private ArrayList<String> orderHistory;

    // Updated constructor to include password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void addOrder(String orderDetails) {
        orderHistory.add(orderDetails);
    }

    public void displayOrderHistory() {
        System.out.println("\nOrder History for " + username + ":");
        if (orderHistory.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (String order : orderHistory) {
                System.out.println(order);
            }
        }
    }

    // Method to validate the user's password
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}

package YearUp.pluralsight;

public abstract class Product {
    protected String name;
    protected double price;
    protected int stock; // Stock management

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            System.out.println("Not enough stock available for " + name);
        }
    }

    public boolean isOutOfStock() {
        return stock <= 0;
    }

    public abstract String getProductCategory();
}

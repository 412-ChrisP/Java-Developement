package YearUp.pluralsight;

public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, int stock, String size) {
        super(name, price, stock);
        this.size = size;
    }

    @Override
    public String getProductCategory() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }
}

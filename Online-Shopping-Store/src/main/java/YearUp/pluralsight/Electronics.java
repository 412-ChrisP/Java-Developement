package YearUp.pluralsight;

public class Electronics extends Product {
    private int warrantyInYears;

    public Electronics(String name, double price, int stock, int warrantyInYears) {
        super(name, price, stock);
        this.warrantyInYears = warrantyInYears;
    }

    @Override
    public String getProductCategory() {
        return "Electronics";
    }

    public int getWarrantyInYears() {
        return warrantyInYears;
    }
}

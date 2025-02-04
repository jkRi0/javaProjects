package finalsWeek16_polymorphism;

public class Electronics extends Product {
    private String warrantyInfo;

    public Electronics(int productId, String productName, double price, String warrantyInfo) {
        super(productId, productName, price);
        this.warrantyInfo = warrantyInfo;
    }

    // Getter for warrantyInfo
    public String getWarrantyInfo() {
        return warrantyInfo;
    }

}

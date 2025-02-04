package finalsWeek16_polymorphism;

// Clothing class - Subclass of Product
class Clothing extends Product {
    private String size;

    public Clothing(int productId, String productName, double price, String size) {
        super(productId, productName, price);
        this.size = size;
    }

    // Getter for size
    public String getSize() {
        return size;
    }
}

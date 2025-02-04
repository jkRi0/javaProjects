package finalsWeek16_polymorphism;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        setCartItems(new ArrayList<>());
    }

    public void AddToCart(Product product) {
        getCartItems().add(product);
        System.out.println(product.getProductName() + " added to cart.");
    }

    public void RemoveFromCart(Product product) {
        if (getCartItems().contains(product)) {
            getCartItems().remove(product);
            System.out.println(product.getProductName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public void DisplayCart() {
        if (getCartItems().isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Products in Cart:");
            for (Product product : getCartItems()) {
                System.out.println("ID: " + product.getProductId() +
                        ", Name: " + product.getProductName() +
                        ", Price: $" + product.getPrice());
                if (product instanceof Electronics) {
                    System.out.println("Warranty: " + 
                    ((Electronics) product).getWarrantyInfo());
                } else if (product instanceof Clothing) {
                    System.out.println("Size: " + ((Clothing) product).getSize());
                }
            }
            System.out.println("Total Price: $" + CalculateTotal());
        }
    }

    public double CalculateTotal() {
        double total = 0;
        for (Product product : getCartItems()) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }
}
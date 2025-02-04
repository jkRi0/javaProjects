package finalsWeek16_polymorphism;

import java.util.Scanner;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		while (!exit) {
			System.out.println("\n=========================");
			System.out.println("  Online Shopping Menu   ");
			System.out.println("=========================");
			System.out.println("1. Add to cart");
			System.out.println("2. Remove from cart");
			System.out.println("3. View cart");
			System.out.println("4. Checkout");
			System.out.println("5. Exit");
			System.out.println("=========================");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					addToCartOperation(cart);
					break;
				case 2:
					addToCartOperation(cart);
					break;
				case 3:
					cart.DisplayCart();
					break;
				case 4:
					System.out.println("\nCheckout");
					cart.DisplayCart();
					cart = new ShoppingCart(); // Clear cart after checkout
					break;
				case 5:
					exit = true;
					System.out.println("\nExiting the program...");
					break;
				default:
					System.out.println("\nInvalid choice. Please enter a valid option.");
			}
		}

		scanner.close();
	}

	private static void addToCartOperation(ShoppingCart cart) {
		// Simulating adding products to the cart
		Product product;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter product type (1 for Electronics, 2 for Clothing):");
		int type = scanner.nextInt();

		System.out.println("Enter product ID:");
		int productId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.println("Enter product name:");
		String productName = scanner.nextLine();

		System.out.println("Enter product price:");
		double price = scanner.nextDouble();
		scanner.nextLine(); // Consume newline

		if (type == 1) {
			System.out.println("Enter warranty information:");
			String warranty = scanner.nextLine();
			product = new Electronics(productId, productName, price, warranty);
		} else if (type == 2) {
			System.out.println("Enter size information:");
			String size = scanner.nextLine();
			product = new Clothing(productId, productName, price, size);
		} else {
			System.out.println("Invalid product type.");
			return;
		}

		cart.AddToCart(product);
	}

	private static void removeFromCartOperation(ShoppingCart cart) {
		// Simulating removing products from the cart
		if (cart.CalculateTotal() == 0) {
			System.out.println("Cart is empty.");
			return;
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product ID to remove:");
		int productId = scanner.nextInt();

		// Search for the product in the cart and remove it
		boolean found = false;
		for (Product product : cart.getCartItems()) {
			if (product.getProductId() == productId) {
				cart.RemoveFromCart(product);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Product not found in cart.");
		}
	}
}
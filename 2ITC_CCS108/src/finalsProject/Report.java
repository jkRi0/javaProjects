package finalsProject;

import java.util.ArrayList;
import java.util.List;
public class Report {
	//CLASSFIELDS
    private InventoryManagement inventory;
    private SalesManagement sales;
    
    //SETTERS
	public void setInventory(InventoryManagement inventory) {
		this.inventory = inventory;
	}

	public void setSales(SalesManagement sales) {
		this.sales = sales;
	}

	public void ProductSoldReport() {
    	List<Integer>bestSellingProducts = new ArrayList<Integer>();
    	List<Integer>worstSellingProducts = new ArrayList<Integer>();
    	int totalQuantity=0, highestQuantity=0, lowestQuantity=Integer.MAX_VALUE;
    	for(Product obj1 : this.inventory.getProductList()) {
    		totalQuantity = 0;
    		//SUMMATION OF SOLD ITEM QUANTITY
    		for(Transaction obj2 : this.sales.getTransactionList()) {
        		if(obj1.getProductId() == obj2.getTheProductId()) 
        			totalQuantity += obj2.getQuantity();
    		}
    		//LISTING PRODUCT ID's OF THE BEST SELLING PRODUCT
    		if(totalQuantity > highestQuantity) {
    			highestQuantity = totalQuantity;
    			//CLEAR AND UPDATE THE LIST IF THERE WAS HIGHER QUANTITY SOLD
    			bestSellingProducts.clear();	
    			bestSellingProducts.add(obj1.getProductId());
    		}else if(totalQuantity == highestQuantity) {
    			//ADD THE PRODUCT SOLD THAT HAS THE SAME TOTAL QUANTITIES
    			bestSellingProducts.add(obj1.getProductId());
    		}
    		
    		//LISTING PRODUCT ID's OF THE WORST SELLING PRODUCT
    		if(totalQuantity < lowestQuantity) {
    			lowestQuantity = totalQuantity;
    			worstSellingProducts.clear();
    			worstSellingProducts.add(obj1.getProductId());
    		}else if(totalQuantity == lowestQuantity) {
    			worstSellingProducts.add(obj1.getProductId());
    		}
    	}
    	
    	//DISPLAY THE BEST SELLING PRODUCTS
    	System.out.println("\nBest Selling Product:");
    	for(int theId : bestSellingProducts)
    		for(Product product : this.inventory.getProductList())
    			if(theId == product.getProductId())
    				System.out.println(product.GetProductDetails());
    	//DISPLAY THE WORST SELLING PRODUCTS
    	System.out.println("\nWorst Selling Product:");
    	for(int theId : worstSellingProducts)
    		for(Product product : this.inventory.getProductList())
    			if(theId == product.getProductId())
    				System.out.println(product.GetProductDetails());
    	//DISPLAY THE SOLD PRODUCTS
    	System.out.println("\nSold Products:");
    	for(Product obj1 : inventory.getProductList())
    		for(Transaction obj2 : sales.getTransactionList()) 
        		if(obj1.getProductId() == obj2.getTheProductId())
        			System.out.println(obj1.GetProductDetails());
    }
}

package finalsProject;

public class Product {
	//CLASSFIELDS
    private int productId;
    private String productName;
    private double price;
    private int stocks;
    private InventoryManagement inventoryManagement;
    
    //CONSTRUCTOR
    public Product(int id, String name, double price, int stocks) {
        this.productId = id;
    	this.productName = name;
        this.price = price;
        this.stocks = stocks;
    }

    //GETTERS AND SETTERS
    public InventoryManagement getInventoryManagement(){
        return this.inventoryManagement;
    }

    public void setInventoryManagement(InventoryManagement inventoryManagement){
        this.inventoryManagement = inventoryManagement;
    }

    public String getProductName(){
        return this.productName;
    }
    
    public int getProductId() {
    	return this.productId;
    }
    
    public double getPrice() {
		return this.price;
	}
    
	public int getStocks() {
		return this.stocks;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	//METHOD FOR DISPLAYING DETAILS
	public String GetProductDetails() {
        return "\nPRODUCT ID: " + this.productId + 
                "\nPRODUCT NAME: " + this.productName + 
                "\nPRICE: " + this.price + 
                "\nSTOCKS: " + this.stocks;
    }
}

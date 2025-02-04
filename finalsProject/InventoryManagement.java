package finalsProject;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement extends ManagementSystem{
	//CLASSFIELDS
	private Scanner scan=new Scanner(System.in);
    private List<Product> productList = new ArrayList<Product>();

    //GETTERS AND SETTERS
    public List<Product> getProductList() {
		return productList;
	}
    
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	//METHODS
	public void AddToList() {/*CREATION MUST BE OUTSIDE THE WHOLE*/}
    public void AddToList(Product product){
        this.productList.add(product);
        System.out.println("Product was successfully added");
    }
    
    //To view the list of products that has been saved.
    public void ViewTheList(){
    	if(this.productList.size()!=0) {
    		for(Product product:this.productList)
    			System.out.println(product.GetProductDetails());
    		System.out.println();
    	}else
    		System.out.println("List is empty");
    }
    
    //Use to edit product details of the selected product id. 
    public void UpdateOnTheList() {
    	System.out.print("Product ID: ");
    	int id=(int)super.ValidateInputNumber(this.scan);
    	this.scan.nextLine();
    	boolean isOnTheList = false;
    	for(Product product:this.productList) {
    		if(product.getProductId()==id) {
    			isOnTheList = true;
    			while(true) {
    				//Choices for editing product details.
    				System.out.println("\n[1] Edit name   [2] Edit price");
    				System.out.println("[3] Edit stock  [4] Back");
    				System.out.print("Enter option: ");
    				String input=scan.nextLine();
    				//If the user wants to change the name of the selected product.
    				if(input.equals("1")) {
    					System.out.print("New Name: ");
    					String newName=this.scan.nextLine();
    					product.setProductName(newName);
    					System.out.println("Value has been changed");
    				//If the user wants to change the price of the selected product
    				}else if(input.equals("2")) {
    					System.out.print("New Price: ");
    					double newPrice=super.ValidateInputNumber(this.scan); this.scan.nextLine();
    					product.setPrice(newPrice);
    					System.out.println("Value has been changed");
    				//If the user wants to change the product stocks.
    				}else if(input.equals("3")) {
    					System.out.print("New Stock: ");
    					int newStock=(int)super.ValidateInputNumber(this.scan); this.scan.nextLine();
    					product.setStocks(newStock);
    					System.out.println("Value has been changed");
    				//Return to the menu.
    				}else if(input.equals("4")) {
    					return;
    				}else
    					System.out.println("Invalid input, please try again.");
    			}
    		}
    	}
    	if(!isOnTheList)
    		System.out.println("The entered product ID was not on the list");
    }
    
    //Responsible for removing a product on the list using the product id.
    public void RemoveFromTheList() {
    	System.out.print("Product ID: ");
    	int id=(int)super.ValidateInputNumber(this.scan);
    	this.scan.nextLine();
    	boolean isOnTheList = false;
    	//TRAVERSING THROUGH THE LIST
    	for(Product product:this.productList) {
    		//IF THE ENTERED ID WAS ON THE LIST
    		if(product.getProductId()==id) {
    			isOnTheList = true;
    			this.productList.remove(product);
    			System.out.println("The product was successfully removed");
    			return;
    		}
    	}
    	if(!isOnTheList)
    		System.out.println("The entered product ID was not on the list");
    }
}

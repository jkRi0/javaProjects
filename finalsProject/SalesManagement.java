package finalsProject;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class SalesManagement extends ManagementSystem{
	//CLASSFIELDS
	private Scanner scan=new Scanner(System.in);
    private List<Transaction> transactionList = new ArrayList<Transaction>();
    private InventoryManagement inventoryManagement;
    private int transactionCounter = 100;

    //GETTERS AND SETTERS
    public List<Transaction> getTransactionList(){
    	return this.transactionList;
    }
    
    public InventoryManagement getInventoryManagement(){
        return this.inventoryManagement;
    }
    
    public void setInventoryManagement(InventoryManagement inventoryManagement){
        this.inventoryManagement = inventoryManagement;
    }

    //FOR CREATING A NEW TRANSACTION
    public void AddToList() {
    	Date date = new Date();
    	Product temporaryObj = null;
    	String []paymentMethod = {"Cash","Card"};
    	String paymentOption = "";
    	int theProductId = 0, quantity = 0;
    	double amountPaid, totalAmount = 0;
    	boolean hasId = false;
    	boolean correctQuantity = false;
    	boolean hasPaymentMethod = false;
    	
    	//CHECK THE LIST OF PRODUCT IF ITS EMPTY
    	if(this.inventoryManagement.getProductList().size()!=0) {
    		System.out.println("\nPRODUCTS:");
    		//PREVIEW THE PRODUCTS
    		this.inventoryManagement.ViewTheList();
    		System.out.print("\nProduct ID to be sold: ");
    		theProductId = (int)super.ValidateInputNumber(this.scan);
    		//ONLY USED FOR INPUT VALIDATION
    		if(theProductId == 0) {
    			System.out.println("Input must be integer");
    			this.scan.nextLine();
    			return;
    		}
    	}else {
    		System.out.println("There is no product/s to be sold");
    		return;
    	}
    	
    	//LOGIC FOR THE QUANTITY OF PRODUCT AND TRANSACTION
    	for(Product product : this.inventoryManagement.getProductList()) {
    		//IF THE ENTERED PRODUCT IF WAS ON THE LIST
    		if(product.getProductId() == theProductId) {
    			hasId = true;	
    			//ENTERING THE QUANTITY OF PRODUCT TO BE SOLD
    			System.out.print("Quantity: ");
    			quantity = (int)super.ValidateInputNumber(this.scan);
    			//VALIDATION OF INPUT
    			if(quantity == 0) {	
    				//ONLY USED FOR INPUT VALIDATION
    				System.out.println("Input must be integer");
    				this.scan.nextLine(); this.scan.nextLine();
        			return;
        		}else if(quantity<=product.getStocks()) {
        			//IF THE ENTERED QUANTITY IS LESS THAN THE PRODUCT STOCKS
        			correctQuantity = true;	  //LABELED AS MET THE REQUIRMENT AND PROCEED TO THE NEXT STEP
        			temporaryObj = product;	  //STORE THE OBJECT IN TEMPORARY VARIABLE FOR NEXT PROCEDURE
        			
        			//COMPUTE THE TOTAL COST
        			totalAmount = temporaryObj.getPrice() * quantity;
        			System.out.println("Total cost: "+totalAmount);
        			this.scan.nextLine();
        			break;
        		}else {
        			//IF THE STOCK WAS EMPTY, OR THE ENTERED QUANTITY IS GREATER THAN THE PRODUCT STOCKS
        			if(product.getStocks()==0) 
        				System.out.println("Product: "+product.getProductName()+" is out of stock");
        			else
        				System.out.println("Product: "+product.getProductName()+
        					" has "+product.getStocks()+" stocks left.");
        			this.scan.nextLine();
        		}
    		}
    	}
    	//IF THE ENTERED ID WAS NOT ON THE LIST
    	if(!hasId) {
    		System.out.println("The entered product ID was not on the list");
    	}
    	
    	//NEXT PROCEDURE AFTER THE VERIFICATION IN QUANTITY
    	//ENTERING OF PAYMENT PROCEDURE
    	if(correctQuantity) {
    		while(true) {
    			System.out.print("Payment; [1]Cash, [2]card: ");
    			paymentOption = this.scan.nextLine();
    			//REPLACING THE ENTERED OPTION WITH THE SPECIFIC PAYMENT METHOD, for variable reusability
    			if(paymentOption.equals("1")) {
    				paymentOption = paymentMethod[0];
    				hasPaymentMethod = true;
    				break;
    			}else if(paymentOption.equals("2")) {
    				paymentOption = paymentMethod[1];
    				hasPaymentMethod = true;
    				break;
    			}else
    				System.out.println("Invalid input, please try again");
    		}
    	}
    	
    	//LAST PROCEDURE IN CREATING THE TRANSACTION
    	if(hasPaymentMethod) {
    		while(true) {
    			System.out.println("Enter '0' to cancel");
    			System.out.print("Amount paid: ");
    			amountPaid = super.ValidateInputNumber(this.scan);
    			this.scan.nextLine();
    			//DISPLAYING THE COMPUTED CHANGE
    			System.out.println("change: "+(amountPaid-totalAmount));
    			
    			//IF THE AMOUNT PAID IS GREATER THAN OR EQUAL TO THE TOTAL AMOUNT COST
    			if(amountPaid >= totalAmount || amountPaid == totalAmount) {
    				//TRANSACTION OBJECT INSTANTIATION
    				Transaction objTransaction = new Transaction(this.transactionCounter, date.toString(), 
    					quantity, totalAmount, theProductId, temporaryObj.getProductName(), paymentOption);
    				//ADDING THE OBJECT TO THE LIST OF TRANSACTION
    				this.transactionList.add(objTransaction);
    				//TO GET AWARE OF ITS WHOLE
    				objTransaction.setSalesManagement(this);
    				this.transactionCounter++;
    				System.out.println("New transaction was successfully added");
    				//REDUCTION OF STOCK
    				temporaryObj.setStocks(temporaryObj.getStocks()-quantity);
    				return;
    			}else if(amountPaid == 0)
    				return;	//ZERO MEANS CANCEL
    			else
    				System.out.println("Insufficient Amount paid!\n");
    		}
    	}
    }
    
    //DISPLAYING THE ELEMENTS ON THE LIST
    public void ViewTheList(){
    	if(this.transactionList.size()!=0) {
    		for(Transaction transaction:this.transactionList)
            	System.out.println(transaction.GetTransactionDetails());
            System.out.println();
    	}else
    		System.out.println("List is empty");
    }
    
    //UPDATE ON THE LIST IS NOT AVAILABLE
    //HOWEVER, THE TRANSACTION CAN BE DELETED
    public void UpdateOnTheList() {
    	System.out.println("Update on the list is not available");
    }
    
    //REMOVING A TRANSACTION
    public void RemoveFromTheList() {
    	System.out.print("Transaction ID: ");
    	int id=(int)super.ValidateInputNumber(this.scan);
    	this.scan.nextLine();
    	boolean isOnTheList = false;
    	//TRAVERSING THROUGH THE LIST
    	for(Transaction transaction:this.transactionList) {
    		//IF THE ENTERED ID WAS ON THE LIST
    		if(transaction.getTransactionId()==id) {
    			isOnTheList = true;
    			this.transactionList.remove(transaction);
    			System.out.println("The transaction was successfully removed");
    			return;
    		}
    	}
    	if(!isOnTheList)
    		System.out.println("The entered transaction ID was not on the list");
    }
}

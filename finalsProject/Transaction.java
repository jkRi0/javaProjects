package finalsProject;

public class Transaction {
	//CLASSFIELDS
    private int transactionId;
    private String date;
    private int quantity;
    private double totalCost;
    private int theProductId;
    private String theProductName;
    private String paymentMethod;
    private SalesManagement salesManagement;
    
    //CONSTRUCTOR
    public Transaction(int id, String date, int quantity, double totalCost, 
    					int theProductId, String theProductName, String paymentMethod){
        this.transactionId = id;
        this.date = date;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.theProductId = theProductId;
        this.theProductName = theProductName;
        this.paymentMethod = paymentMethod;
    }

    //GETTERS AND SETTERS
    public SalesManagement getSalesManagement(){
        return this.salesManagement;
    }

    public int getTransactionId() {
		return this.transactionId;
	}
    
    public int getTheProductId() {
    	return this.theProductId;
    }
    
    public int getQuantity() {
		return this.quantity;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setSalesManagement(SalesManagement salesManagement){
        this.salesManagement = salesManagement;
    }
	
	//METHODS
    public String GetTransactionDetails(){
        return "\nTRANSACTION ID: " + this.transactionId +
               "\nTRANSACTION DATE: " + this.date + 
               "\nTRANSACTION TOTAL: " + this.totalCost+
               "\nPAYMENT METHOD: "+this.paymentMethod+
               "\nPRODUCT SOLD: "+this.theProductName;
    }
}

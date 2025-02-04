package finals_CaseStudy;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;

//PROPS
class User{
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

class Product{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}



class InventoryManagement extends Application{
	private List<Product> productList=new ArrayList<Product>();
	public void AddData(Object obj) {}
	public void RemoveData(Object obj) {}
	public String DisplayInformation() {return "";}
	public List<Product> getProductList() {
		return productList;
	}
}

class SupplierManagement extends Application{
	public void AddData(Object obj) {}
	public void RemoveData(Object obj) {}
	public String DisplayInformation() {return "";}
}

class SystemMaintenance extends Application{
	public void AddData(Object obj) {}
	public void RemoveData(Object obj) {}
	public String DisplayInformation() {return "";}
}

//SCOPE IN DESIGN SPECIFICATION
class Login{
	private List<User> loggedUsers = new ArrayList<User>();
	
	public void EnterDetails() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter username: ");
		String username=scan.nextLine();
		System.out.print("Enter password: ");
		String password=scan.nextLine();
		
		if(this.VerifyAccount(0, username, true)==this.VerifyAccount(0, password, false)) 
			this.DisplayConfirmation(1);
		else 
			this.DisplayConfirmation(0);
	}
	
	public boolean VerifyAccount(int count, String detail, boolean byName) {
		boolean isEqual = false;
		if(count<this.loggedUsers.size()) {
			if(!byName==false? true:false) {
				for(int count1=0;count1<detail.length();count1++) {
					if(this.loggedUsers.get(count).getUsername().charAt(count1)==detail.charAt(count1)) {
						isEqual=true;
					}else {
						isEqual=false;
						break;
					}
				}
			}else if(!byName){
				for(int count1=0;count1<detail.length();count1++) {
					if(this.loggedUsers.get(count).getPassword().charAt(count1)==detail.charAt(count1)) {
						isEqual=true;
					}else {
						isEqual=false;
						break;
					}
				}
			}
			this.VerifyAccount(count+1, detail, byName);
		}
		if(isEqual)
			return true;
		else
			return false;
	}
	
	public String DisplayConfirmation(int sentinel) {
		String remark="";
		String temp="";
		remark=sentinel==0?"Invalid":"";
		temp=!remark.equals("")?remark:"";
		remark=sentinel==1?"Valid":"";
		remark=!temp.equals("")?temp:remark;
		return remark;
	}
}

//SCOPE IN DESIGN SPECIFICATION
public abstract class Application {
	private String layoutPath;
	private InventoryManagement inventory;
	private SupplierManagement supplies;
	private SystemMaintenance maintenance;
	
	public InventoryManagement getInventory() {
		return inventory;
	}

	public SupplierManagement getSupplies() {
		return supplies;
	}

	public SystemMaintenance getMaintenance() {
		return maintenance;
	}
	
	public void UploadStoreLayout(String filePath) {
		this.layoutPath = filePath;
	}
	
	public void LocateItem(int id) {
		Image image = new ImageIcon(this.layoutPath).getImage();
		int width = image.getWidth(null);
		int length = image.getHeight(null);
		int Y[] = new int[width];
		int X[] = new int[length];
		boolean hasId = false;
		int prodPosition[]=new int[2]; //X,Y
		for(int count=0; id>=100? true:false; count++) {
			if(count<=this.inventory.getProductList().size()) {
				if(this.inventory.getProductList().get(count).getId() == id) {
					hasId = true;
				}else
					System.out.println("ID not match on the list");
			}
		}
		if(hasId) {
			for(int count=0; count<Y.length; count++) {
				for(int count1=0; count1<X.length; count1++) {
					if(X[count1]==prodPosition[0]&&Y[count]==prodPosition[1]) {
						System.out.println(this.DisplayItemLocation());
						//OTHER LOGIC
					}
				}
			}
		}
	}
	
	public String DisplayItemLocation() {
		return "";
	}
	
	public abstract void AddData(Object obj);
	public abstract void RemoveData(Object obj);
	public abstract String DisplayInformation();
}

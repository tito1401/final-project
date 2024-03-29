import java.io.Serializable;

public class Customer implements Serializable {
	protected String name;
	protected int customerID;
	
	public Customer(String name, int customerID) {
		this.name = name;
		this.customerID = customerID;
	}
	
		//setters
		public void setCustomer (String name, int customerID) {
			this.name = name;
			this.customerID = customerID;
		}
		
		public void setName (String name) {
			this.name = name;
		}
		
		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}
		
		//getters
		public String getName() {
			return name;
		}
		public int getCustomerID() {
			return customerID;
		}
		public String toString() {
			String output = "Customer name: " + this.name;
			output += "\nCustomer ID: " + this.customerID + "\n";
			
			return output;
		}
	}

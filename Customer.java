public class Customer {
	protected String name;
	protected int customerID;
	protected Customer customer;
	
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
			String output = "Customer name: " + name;
			output += "\nCustomer ID: " + customerID;
			
			return output;
		}
	}

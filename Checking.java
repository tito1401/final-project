import java.io.Serializable;

public class Checking extends Account implements Serializable {
	
		
		public Checking (Customer customer, int accountNumber, float balance, int transaction) {
			super (customer, accountNumber, balance, transaction);
	}

		public void setMonthlyEnd (float monthlyEnd) {
			this.monthlyEnd = monthlyEnd;
		}
		
		public float getMonthlyEnd() {
			if (this.transaction <= 2) {
				return balance;
			}
			else {
			return balance - (3 * (transaction - 2 ));
		}
	}
		//to string method for Account class
	    public String toString() {
	    	String output = this.customer.toString();
	    	output += "Account Number: " + this.accountNumber;
	    	output += "\nBalance: " + this.balance + "\n";
	    	output += "\nTransactions this month: " + this.transaction + "\n";
	    	
	    	return output;
	}
}
		

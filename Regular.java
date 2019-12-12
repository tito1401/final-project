import java.io.Serializable;

public class Regular extends Account implements Serializable {

	
	public Regular (Customer customer, int accountNumber, float balance, int transaction, String accountType) {
		super (customer, accountNumber, balance, transaction, accountType);
}

	public void setMonthlyEnd(float monthlyEnd) {
		this.monthlyEnd = monthlyEnd;
}
	
	public float getMonthlyEnd() {
		return (balance * 1.06f) - 10;
	}
	
	//to string method for Account class
    public String toString() {
    	String output = this.customer.toString();
    	output += "Account Number: " + this.accountNumber;
    	output += "\nBalance: " + this.balance;
    	output += "Account Type: " + this.accountType + "\n";
    	
    	return output;
    }
}
	
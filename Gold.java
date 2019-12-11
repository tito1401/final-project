import java.io.Serializable;

public class Gold extends Account implements Serializable {

	
	public Gold (Customer customer, int accountNumber, float balance, int transaction) {
		super (customer, accountNumber, balance, transaction);
}

	public void setMonthlyEnd(float monthlyEnd) {
		this.monthlyEnd = monthlyEnd;
	}
	
	public float getMonthlyEnd() {
		return (balance * 1.05f);
	}
	
	//to string method for Account class
    public String toString() {
    	String output = this.customer.toString();
    	output += "Account Number: " + this.accountNumber;
    	output += "\nBalance: " + this.balance + "\n";
    	
    	return output;
    }
}
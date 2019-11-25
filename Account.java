//class to set account info
public class Account {
    protected Customer customer;
    protected int accountNumber;
    protected float balance;
    protected int transaction;
    protected float monthlyEnd;

    //getter so account info can be referenced elsewhere
    public Account(Customer customer, int accountNumber, float balance, int transaction) {
        super();
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transaction = transaction;
    }

    //setters for attributes
    public void setAccount ( int accountNumber ) {
    	this.accountNumber = accountNumber;
    }
    public void setBalance ( float balance ) {
    	this.balance = balance;
    }
    public void setTransaction ( int transaction ) {
    	this.transaction = transaction;
    }
    public void setMonthlyEnd ( float monthlyEnd ) {
    	this.monthlyEnd = monthlyEnd;
    }
    
    //getters for attributes
    public int getAccountNumber() {
    	return accountNumber;
    }
    public float getBalance() {
    	return balance;
    }
    public int getTransaction() {
    	return transaction;
    }
    public float getMonthlyEnd() {
    	return balance;
    }
    
    //to string method for Account class
    public String toString() {
    	String output = this.customer.toString();
    	output += "Account Number: " + this.accountNumber;
    	output += "\n Balance: " + this.balance + "\n";
    	
    	return output;
    }
}
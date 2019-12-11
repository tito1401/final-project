import java.io.Serializable;

//class to set account info
public class Account implements Serializable {
    protected Customer customer;
    protected int accountNumber;
    protected float balance;
    protected int transaction;
    protected float monthlyEnd;

    //getter so account info can be referenced elsewhere
    public Account(Customer customer, int accountNumber, float balance, int transaction) {
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
    public void setCustomer ( Customer customer ) {
    	this.customer = customer;
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
    public Customer getCustomer() {
    	return customer;
    }
    
}
import java.io.Serializable;

//class to set account info
public class Account implements Serializable {
    protected Customer customer;
    protected int accountNumber;
    protected float balance;
    protected int transaction;
    protected float monthlyEnd;
    protected String accountType;

    //getter so account info can be referenced elsewhere
    public Account(Customer customer, int accountNumber, float balance, int transaction, String accountType) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transaction = transaction;
        this.accountType = accountType;
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
    public void setAccountType ( String accountType) {
    	this.accountType = accountType;
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
    public String getAccountType() {
    	return accountType;
    }
    
}
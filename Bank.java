import java.util.ArrayList;
import java.util.Scanner;


//latest file for final project
//uploaded to github 11/24
//BankSystem class
public class Bank {
    public Scanner input = new Scanner(System.in);
    
    public ArrayList<Account> arrayList = new ArrayList<>();
    
  //method to create checking account
    public Checking createChecking() {
            Customer customer = null;
            int accountNumber = 0;
            float balance = 0;
            int transaction = 0;
            
            getCustomer();      
                        
            Checking checking = new Checking(customer, accountNumber, balance, transaction);
            
            System.out.println("Please input the account number: ");
            accountNumber = input.nextInt();
            
            return checking;         
    }
    
  //method to create gold account
    public Gold createGold() {
            Customer customer = null;
            int accountNumber = 0;
            float balance = 0;
            int transaction = 0;
            
            getCustomer();
                                    
            Gold gold = new Gold(customer, accountNumber, balance, transaction);
            
            System.out.println("Please input the account number: ");
            accountNumber = input.nextInt();
            
            return gold;
    }
    
  //method to create regular account
    public Regular createRegular() {
    		Customer customer = null;
            int accountNumber;
            float balance = 0;
            int transaction = 0;
            
            getCustomer();
                        
            System.out.println("Please input the account number: ");
            accountNumber = input.nextInt();
            
            Regular regular = new Regular (customer, accountNumber, balance, transaction);

            
            return regular;
    } 
           
    //method to request information about a customer and return customer
    public Customer getCustomer() {
        //declare string types needed to construct customer object
        String name = "";
        int customerID = 0;
        
        Scanner input = new Scanner(System.in);

        //prompt user for Customer info
        System.out.print("What is the name of the customer? ");
        name = input.nextLine();
        System.out.print("\nWhat is the customer's ID? ");
        customerID = input.nextInt();

        //create new customer from provided data
        Customer customer= new Customer(name, customerID);

        //return new Customer object
        return customer;
    }
    
    //show banking statistics for a given account
    void displayBankStatistics() {
        //declare variables
        float averageBalance = 0;
        int emptyAccount = 0;
        String largestBalance = "";
        int j = 0;

        System.out.println("Total sum of all accounts: " + arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).balance == 0) {
                emptyAccount++;
            }
        }
        System.out.println("Number of zero-balance accounts: " + emptyAccount);


        for (int i = 0; i < arrayList.size(); i++) {
            averageBalance += arrayList.get(i).balance;
        }
        averageBalance /= arrayList.size();
        System.out.println("Average balance of accounts: " + averageBalance);


        //move largest account holder to top of array
        for (int i = 0; i < arrayList.size(); i++) {

            for (j = i + 1; j < arrayList.size(); j++) {

                if (arrayList.get(i).balance > arrayList.get(j).balance) {
                    Account k = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, k);
                }
            }
        }

        //display largest account holder
        //largestBalance = arrayList.get(arrayList.size() - 1).customerName;
        //System.out.println("The account with largest balance: " + largestBalance);

    }


    //method to find accounts based on account number
    public Account find(int accountNO) {
       for (Account acc:arrayList) {
    	   if (acc.getAccountNumber() == (accountNO))
            return acc;
        }
       {
    	   return null;
       }
       }
    
    //method to add deposit
    void addDeposit() {
    	Account acc;
    	int accountNO = searchAccount();
    	acc = find(accountNO);
    		if (acc == null) {
    			System.out.println("Account number not found."); }
    		else {
    			System.out.println("Enter amount to deposit: ");
    				float deposit = input.nextFloat();
    	    		acc.balance += deposit;	
    	    	System.out.println("Account updated.");
    	    	}
    		}
    //method to withdraw
    void subWithdraw() {
    	Account acc;
    	int accountNO = searchAccount();
    	acc = find(accountNO);
    		if (acc == null) {
    			System.out.println("Account number not found. "); }
    		else {
    			System.out.println("Enter amount to withdraw: ");
    			float withdraw = input.nextFloat();
    			acc.balance += withdraw;
    		System.out.println("Account updated. ");
    		}
    }
    
   //method to input customer account number for searching purposes 
    public int searchAccount() {
    	System.out.println("Enter customer account number: ");
    	int accountNO = input.nextInt();
    	
    	return accountNO;
    }
    
    //method to display account info
    public void displayInfo(int accountNO){

        //match accountNO from input to Account it belongs to
        for (Account acc:arrayList) {
            if (acc.getAccountNumber() == (accountNO)) {
                System.out.println(acc);
            }
        }
    }
    public static void main(String[] args) {
        Bank bankOperator = new Bank();
        int choice;

        do {
            System.out.println("     BANK MENU\n"
                    + "=========================\n"
                    + "1.Create a Checking account\n"
                    + "2.Create a Gold account\n"
                    + "3.Create a Regular account\n"
                    + "4.Deposit\n"
                    + "5.Withdraw\n"
                    + "6.Display account info.\n"
                    + "7.Remove an account\n"
                    + "8.Apply end of month <Interest/Fees>\n"
                    + "9.Display Bank statistics\n"
                    + "10.Exit\n"
                    + "Please input your choice <1-10>: ");

            choice = bankOperator.input.nextInt();
            switch (choice) {

                //create checking account
                case 1:
                    Checking check = bankOperator.createChecking();
                    bankOperator.arrayList.add(check);
                    	break;

                //create gold account
                case 2:
                    Gold g = bankOperator.createGold();
                    bankOperator.arrayList.add(g);
                    	break;

                //create regular account
                case 3:
                    Regular reg = bankOperator.createRegular();
                    bankOperator.arrayList.add(reg);
                    	break;

                //deposit
                case 4:
                    bankOperator.addDeposit();
                    	break;
                    	
                //withdraw
                case 5:
                    bankOperator.subWithdraw();
                    	break;
                    
                //display account info    
        		case 6:
        			int accountNO = 0;
        			Account acc;
        			
        			accountNO = bankOperator.searchAccount();
        			acc = bankOperator.find(accountNO);
        			if (acc == null) {
            			System.out.println("Account number not found. "); }
            		else { 
            			bankOperator.displayInfo(accountNO);
            		}
                     
                    break;
                    
                //remove an account
                case 7:
                    //System.out.println("Please input the account number: ");
                    //accountNO = bankOperator.input.nextInt();
                    //acc = bankOperator.find(accountNO);
                	//if (acc == null) {	
                	//	System.out.println("\nAccount number not found"); }
                	//else {
                	//	bankOperator.arrayList.remove(acc);
                      //      System.out.println("Bank account removed");

                    break;

                //Apply end of the month interest/fees
                case 8:
                	bankOperator.arrayList.forEach((account)-> {
                    	account.balance = account.getMonthlyEnd();

                        //reset transaction counter once end of the month interest and fees are applied
                        account.transaction = 0;
                    });

                    System.out.println("All accounts updated successfully");

                    break;

                //Display bank statistics
                case 9:
                    bankOperator.displayBankStatistics();
                    break;
            }
        } while (choice != 10);


    }


}
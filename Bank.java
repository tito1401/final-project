import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

//latest file for final project
//uploaded to github 12/8
//BankSystem class
public class Bank implements Serializable {
    public Scanner input = new Scanner(System.in);
    
    //create arraylist 
    public ArrayList<Account> arrayList = new ArrayList<>();
    
    //method to create checking account
    public Checking createChecking() {
            Customer customer = null;
            int accountNumber = 0;
            float balance = 0;
            int transaction = 0;
            
            customer = getCustomer();      
                                   
            System.out.println("\nPlease input the account number: ");
            accountNumber = input.nextInt();
            while (accountCheck((accountNumber))) {
            	System.out.println("\nThis account number is already taken.");
       			System.out.println("\nEnter a different account number: ");
       			accountNumber = input.nextInt();
            }

            Checking checking = new Checking(customer, accountNumber, balance, transaction);
            return checking;
            }
    
    //method to create gold account
    public Gold createGold() {
            Customer customer = null;
            int accountNumber = 0;
            float balance = 0;
            int transaction = 0;
            
            customer = getCustomer();
                                                
            System.out.println("\nPlease input the account number: ");
            accountNumber = input.nextInt();
            while (accountCheck((accountNumber))) {
            	System.out.println("\nThis account number is already taken.");
       			System.out.println("\nEnter a different account number: ");
       			accountNumber = input.nextInt();
            }
            
            Gold gold = new Gold(customer, accountNumber, balance, transaction);

            return gold;
    }
    
    //method to create regular account
    public Regular createRegular() {
    		Customer customer = null;
            int accountNumber;
            float balance = 0;
            int transaction = 0;
            
            customer = getCustomer();
                        
            System.out.println("\nPlease input the account number: ");
            accountNumber = input.nextInt();
            while (accountCheck((accountNumber))) {
            	System.out.println("\nThis account number is already taken.");
       			System.out.println("\nEnter a different account number: ");
       			accountNumber = input.nextInt();
            }
            
            Regular regular = new Regular (customer, accountNumber, balance, transaction);

            
            return regular;
    } 
           
    //method to request information about a customer and return customer
    public static Customer getCustomer() {
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
    
    //show banking statistics for all accounts
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
        //largestBalance = arrayList.get(arrayList.size() - 1).Customer.name;
        //System.out.println("The account with largest balance: " + largestBalance);

    }


    //method to find accounts based on account number
    public Account find(int accountNO) {
       for (Account acc:this.arrayList) {
    	   if (acc.getAccountNumber() == (accountNO))
            return acc;
        }
       {
    	   return null;
       }
       }
    
  //method to check for unique account
    public boolean accountCheck(int accountNumber) {
    	       for (Account acc:this.arrayList) {
    	    	   if (acc.getAccountNumber()==(accountNumber)) {
    	    		   return true;
    	    	   }
    	       }
			return false;
    }
    
    //method to add deposit
    void addDeposit() {
    	Account acc;
    	int accountNO = searchAccount();
    	acc = find(accountNO);
    		if (acc == null) {
    			System.out.println("Account number not found."); }
    		else {
    			System.out.println("Enter amount to deposit: $");
    				float deposit = input.nextFloat();
    	    		acc.balance += deposit;	
    	    		acc.transaction += 1;
    	    	System.out.println("Account updated.");
    	    	}
    		}
    
    //method to withdraw 
    void subWithdraw() {
    	Account acc;
    	int accountNO = searchAccount();
    	acc = find(accountNO);
    		if (acc == null) {
    			System.out.println("Account number not found. "); 
    			}
    		if (acc instanceof Gold) {
    			System.out.println("Enter amount to withdraw: $");
    			float withdraw = input.nextFloat();
    			acc.balance -= withdraw;
    			}
    		else {
    			System.out.println("Enter amount to withdraw: $");
    			float withdraw = input.nextFloat();
    			if (withdraw <= acc.balance) { 
    				acc.balance -= withdraw;
    				}
    			else {
    				System.out.println("You were only able to withdraw: $" + acc.balance);
    				acc.balance = 0;
    				}
    			}
    		acc.transaction += 1;	
    		System.out.println("Account updated. ");
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
    
    //enter main
    public static void main(String[] args) {
        Bank bankOperator = new Bank();
        int choice;
        
        //file system 
        final String FILENAME = "bank.dat";
        File f = new File(FILENAME);
        
        		//try to load existing data
        		if (f.exists()) {
     			   try {
     				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
     				//Read the objects from the file back to the array list
     				bankOperator.arrayList = (ArrayList<Account>) in.readObject();
     				in.close();

     			   } catch (Exception e) {

     			 		 System.out.println( e.getMessage() );
     			 		 e.printStackTrace();
     			 		 System.exit(0);
     			 	}
        		}

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
                    + "8.Apply end of month Interest/Fees\n"
                    + "9.Display Bank statistics\n"
                    + "10.Exit\n"
                    + "\nPlease input your choice <1-10>: ");

            choice = bankOperator.input.nextInt();
            switch (choice) {

                //create checking account
                case 1:
                    Checking check = bankOperator.createChecking();
                    bankOperator.arrayList.add(check);
                    System.out.println("\nNew account created.");
                    	break;

                //create gold account
                case 2:
                    Gold g = bankOperator.createGold();
                    bankOperator.arrayList.add(g);
                    System.out.println("\nNew account created.");
                    	break;

                //create regular account
                case 3:
                    Regular reg = bankOperator.createRegular();
                    bankOperator.arrayList.add(reg);
                    System.out.println("\nNew account created.");
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
            			System.out.println("Account number not found."); }
            		else { 
            			bankOperator.displayInfo(accountNO);
            		}
                     
                    break;
                    
                //remove an account
                case 7:
                    
                    accountNO = bankOperator.searchAccount();
                    acc = bankOperator.find(accountNO);
                	if (acc == null) {	
                		System.out.println("/nAccount number not found"); }
                	else {
                		bankOperator.arrayList.remove(acc);
                        System.out.println("Bank account removed");
                	}
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
      //save arraylist to file
		try {
			//Create the file then save all employee records into it
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(bankOperator.arrayList);
			out.close();
		}
		catch (Exception e) {
			System.out.println("Unable to bank information");
			System.out.println( e.getMessage() );
			e.printStackTrace();
			System.exit(0);
		}
    }


}
INFO-C210 Fall 2019
Team Green
Project Phase 2 - Read Me file

Information in this file is updated as of 12:15 p.m. Monday 12/16/2009

When we turned in Phase 1 of this project, we hadn't completed the assignment 100%. So the first task was to catch up by
coding the remaining functionality of the Phase 1 specificataions. This was made easier by following the professor's 
instructions as provided in the comments to our phase 1 submission. Specifically: 1) Remove the customer information from the Account class and make a Customer class that has an aggregattion relattionship with Account class. 2) moved functionality from making accounts to Bank class (originally was in Account class). 3) declared variables inside the Account class as protected. 4) renamed Reg class to Regular. 5) renamed AccountInfo class to Account.

Objects in our system:
1) Bank - this is created by the main method and it contains the functionality of the bank system.
2) Customer - this is associated with an account.
3) Checking, Gold, and Regular - the 3 different types of accounts, are all extensions/children of Account

Challenges encountered:
1) originally the Bank class had the create accounts methodss in the wrong order so that it was creawting account objects without actually registering the attributes.
2) JavaFX. This has been a huge issue. No one in our group has been able to get JavaFX to work in Eclipse. Two of us have been able to get it to work in IntelliJ, one of us has gotten it to work in NetBeans, and the other two have still not been able to get it to work.

Known bugs/issues:
1) When running the text-only version of the program in the console, if you enter 10 at the main menu to exit the program, it displays the message "Invalid entry. Please ensure that your selection is an integer from 1 to 10" although it then does exit the program.
2) When running the text-only version of the program, when you try to withdraw and give it an account number that doesn't exist it does give you an "Account number not found." message, but then it goes on to prompt you "Enter amount to withdraw: $" and no matter what you input there it crashes the program and throws a null pointer exception, presumably for obvious reasons. It does not do this if you try to make a deposit but give an account number that doesn't exist.
3) in the GUI/JavaFX version of the program, when displaying bank statistics, it does not display the total bank balance, but instead shows the total number of existing accounts.
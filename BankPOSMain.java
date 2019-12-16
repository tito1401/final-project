import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class BankPOSMain extends Application {
    static Bank bank = new Bank();
    Button createChecking;
    Button createGold;
    Button regularAccount;
    Button deposit;
    Button withdraw;
    Button displayAccountInfo;
    Button removeAnAccount;
    Button endOfMonth;
    Button displayBankStatics;
    Button exit;

    public static void main(String[] args) {
        // file system
        final String FILENAME = "bank.dat";
        File f = new File(FILENAME);
        // try to load existing data
        if (f.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new
                        FileInputStream(f));
                // Read objects from the file back to the array list
                bank.arrayList = (ArrayList<Account>) in.readObject();
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.exit(0);
            }
            try {
                // Create the file then save all employee records to it
                ObjectOutputStream out = new ObjectOutputStream(new
                        FileOutputStream(f));
                out.writeObject(bank.arrayList);
                out.close();
            } catch (Exception e) {
                System.out.println("Unable to save bank information");
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.exit(0);
            }
        }
        launch(args); //start application as javafx app
    }

    @Override
    public void start(Stage primaryStage) {


        mainWindow(primaryStage);


    }


    public void mainWindow(Stage primaryStage) {
        primaryStage.setTitle("Bank System"); //set stage title
        createChecking = new Button("Create Checking account");
        createGold = new Button("Create Gold Account");
        regularAccount = new Button("Create Regular Account");
        deposit = new Button("Deposit");
        withdraw = new Button("Withdraw");
        displayAccountInfo = new Button("Display Account Info");
        removeAnAccount = new Button("Remove An Account");
        endOfMonth = new Button("Apply end ef month <Interest/Fees>");
        displayBankStatics = new Button("Display Bank Statistics");
        exit = new Button("Exit");


        //create a layout pane
        VBox layout = new VBox();
        layout.getChildren().add(createChecking);
        layout.getChildren().add(createGold);
        layout.getChildren().add(regularAccount);
        layout.getChildren().add(deposit);
        layout.getChildren().add(withdraw);
        layout.getChildren().add(displayAccountInfo);
        layout.getChildren().add(removeAnAccount);
        layout.getChildren().add(endOfMonth);
        layout.getChildren().add(displayBankStatics);
        layout.getChildren().add(exit);
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        //create initial scene, pull in that layout and set properties
        Scene scene = new Scene(layout, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        createChecking.setOnAction(e -> {
            createCheckingAccount(primaryStage);
        });

        createGold.setOnAction(e -> {
            createGoldAccount(primaryStage);
        });

        regularAccount.setOnAction(e -> {
            createRegularAccount(primaryStage);
        });

        deposit.setOnAction(e -> {
            deposit(primaryStage);
        });

        withdraw.setOnAction(e -> {
            withdraw(primaryStage);
        });

        displayAccountInfo.setOnAction(e -> {
            displayAccountInfo(primaryStage);
        });

        removeAnAccount.setOnAction(e -> {
            removeAnAccount(primaryStage);
        });

        endOfMonth.setOnAction(e -> {
            applyEndOfMonth(primaryStage);
        });

        displayBankStatics.setOnAction(e -> {
            bankStatistics(primaryStage);
        });

        exit.setOnAction(e -> {
            primaryStage.close();
        });
    }

    public void createCheckingAccount(Stage primaryStage) {


        //create label
        Text text1 = new Text("Customer Name: ");

        //create label
        Text text2 = new Text("Customer ID: ");

        Text text3 = new Text("Account Number: ");


        //Create text field for customer name
        TextField textField1 = new TextField();

        //Create text field for customer id
        TextField textField2 = new TextField();


        TextField textField3 = new TextField();

        //Create buttons
        Button button1 = new Button("Create Account");
        Button button2 = new Button("Back");

        //Create a Grid Pane
        GridPane gridPane = new GridPane();

        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(button1, 1, 3);
        gridPane.add(button2, 2, 3);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        button1.setOnAction(e -> {
            Customer customer = new Customer(textField1.getText(), Integer.parseInt(textField2.getText()));

            Checking checking = bank.createChecking(customer, Integer.parseInt(textField3.getText()));
            bank.getArrayList().add(checking);
            if (checking != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account Created Successfully");
                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");

            } else {
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Information dialogue");
                alert1.setHeaderText("This account number is already taken.");
                alert1.setContentText("Enter a different account number!");

                alert1.showAndWait();
                textField1.setText("");
                textField2.setText("");
            }
        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void createGoldAccount(Stage primaryStage) {
        //create label
        Text text1 = new Text("Customer Name: ");

        //create label
        Text text2 = new Text("Customer ID: ");

        Text text3 = new Text("Account Number: ");


        //Create text field for customer name
        TextField textField1 = new TextField();

        //Create text field for customer id
        TextField textField2 = new TextField();

        //Create text field for Account Number
        TextField textField3 = new TextField();

        //Creating Buttons
        Button button1 = new Button("Create Account");
        Button button2 = new Button("Back");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();


        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        button1.setOnAction(e -> {
            Customer customer = new Customer(textField1.getText(), Integer.parseInt(textField2.getText()));

            Gold gold = bank.createGold(customer, Integer.parseInt(textField3.getText()));
            bank.getArrayList().add(gold);
            if (gold != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account Created Successfully");

                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            } else {
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Information dialogue");
                alert1.setHeaderText("This account number is already taken.");
                alert1.setContentText("Enter a different account number!");

                alert1.showAndWait();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void createRegularAccount(Stage primaryStage) {
        //creating label
        Text text1 = new Text("Customer Name: ");

        //creating label
        Text text2 = new Text("Customer ID: ");

        Text text3 = new Text("Account Number: ");


        //Creating text field for customer name
        TextField textField1 = new TextField();

        //Creating text field for customer id
        TextField textField2 = new TextField();

        //Creating text field for Account Number
        TextField textField3 = new TextField();

        //Create buttons
        Button button1 = new Button("Create Account");
        Button button2 = new Button("Back");

        //Create a Grid Pane
        GridPane gridPane = new GridPane();


        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        button1.setOnAction(e -> {
            Customer customer = new Customer(textField1.getText(), Integer.parseInt(textField2.getText()));

            Regular regular = bank.createRegular(customer, Integer.parseInt(textField3.getText()));
            bank.getArrayList().add(regular);
            if (regular != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account Created Successfully");

                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            } else {
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Information dialogue");
                alert1.setHeaderText("This account number is already taken.");
                alert1.setContentText("Enter a different account number!");

                alert1.showAndWait();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void deposit(Stage primaryStage) {

        //create label
        Text text1 = new Text("Customer Account Number: ");

        //create label
        Text text2 = new Text("Deposit Amount: $");


        //Create Text field for Customer Account Number
        TextField textField1 = new TextField();

        //Creating Text field for Deposit Amount
        TextField textField2 = new TextField();


        //Create Buttons
        Button button12 = new Button("Deposit");
        Button button2 = new Button("Back");

        //Create a Grid Pane
        GridPane gridPane = new GridPane();

        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(button12, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        button12.setOnAction(e -> {
            int accountNumber = Integer.parseInt(textField1.getText());
            float deposit = Float.parseFloat(textField2.getText());
            //Boolean flag = bank.addDeposit(accountNumber, deposit);
            //System.out.println(flag);
            if (bank.addDeposit(accountNumber, deposit)) {
                System.out.println("true");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account updated successfully!");
                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");

            } else {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Account Number");
                alert.setContentText("Account number not found!");
                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");
            }

        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void withdraw(Stage primaryStage) {
        //create label
        Text text1 = new Text("Customer Account Number :");

        //create label
        Text text2 = new Text("Withdraw Amount: $");


        //Create Text field for Customer Account Number
        TextField textField1 = new TextField();

        //Create Text field for Withdraw  Amount
        TextField textField2 = new TextField();


        //Create Buttons
        Button button1 = new Button("Widthdraw");
        Button button2 = new Button("Back");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();


        button1.setOnAction(e -> {
            int accountNumber = Integer.parseInt(textField1.getText());
            float widthdraw = Float.parseFloat(textField2.getText());
            Boolean flag = bank.subWithdraw(accountNumber, widthdraw);
            if (flag == true) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account updated successfully!");
                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Account Number");
                alert.setContentText("Account number not found!");
                alert.showAndWait();
                textField1.setText("");
                textField2.setText("");
            }

        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void displayAccountInfo(Stage primaryStage) {
        //create label
        Text text1 = new Text("Account Number :");


        Text txt = new Text("");

        //Create text field for  account number
        TextField textField1 = new TextField();

        TableView<Account> table = new TableView<Account>();

        Text label = new Text("Account Info");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        TableColumn Customer = new TableColumn("Customer");
        Customer.setMinWidth(100);
        Customer.setCellValueFactory(
                new PropertyValueFactory<Account, Customer>("customer"));

        TableColumn AccountNumber = new TableColumn("Account Number");
        AccountNumber.setMinWidth(100);
        AccountNumber.setCellValueFactory(
                new PropertyValueFactory<Account, Integer>("accountNumber"));

        TableColumn Balance = new TableColumn("Balance");
        Balance.setMinWidth(200);
        Balance.setCellValueFactory(
                new PropertyValueFactory<Account, Float>("balance"));

        TableColumn transaction = new TableColumn("Transaction");
        transaction.setMinWidth(200);
        transaction.setCellValueFactory(
                new PropertyValueFactory<Account, Integer>("transaction"));

        TableColumn accountType = new TableColumn("AccountType");
        accountType.setMinWidth(200);
        accountType.setCellValueFactory(
                new PropertyValueFactory<Account, Float>("accountType"));

        table.getColumns().addAll(Customer, AccountNumber, Balance, transaction, accountType);
        //Create Buttons
        Button button1 = new Button("Display Information");
        Button button2 = new Button("Back");

        //Create a Grid Pane
        GridPane gridPane = new GridPane();

        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.add(txt, 2, 4);
        gridPane.add(label, 3, 4);
        gridPane.add(table, 4, 5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();


        button1.setOnAction(e -> {
            int accountNumber = Integer.parseInt(textField1.getText());
            Account acc;
            acc = bank.find(accountNumber);
            if (acc == null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account number not found!");
                alert.showAndWait();
                textField1.setText("");

            } else {

                Account ac;
                ac = bank.displayInfo(accountNumber);
                if (ac != null) {
                    ObservableList<Account> data =
                            FXCollections.observableArrayList(
                                    new Account(ac.getCustomer(), ac.getAccountNumber(), ac.getBalance(), ac.getTransaction(), ac.getAccountType())
                            );
                    table.setItems(data);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information dialogue");
                    alert.setHeaderText(null);
                    alert.setContentText("Account number not found");
                    alert.showAndWait();
                    textField1.setText("");
                }

            }
        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void removeAnAccount(Stage primaryStage) {
        //create label
        Text text1 = new Text("Account Number :");


        //Create Text field for account number
        TextField textField1 = new TextField();


        //Create buttons
        Button button1 = new Button("Remove Account");
        Button button2 = new Button("Back");

        //Create a Grid Pane
        GridPane gridPane = new GridPane();

        //Arrange all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();


        button1.setOnAction(e -> {
            int accountNumber = Integer.parseInt(textField1.getText());
            Account acc;
            acc = bank.find(accountNumber);
            if (acc == null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account number not found");
                alert.showAndWait();
                textField1.setText("");
            } else {

                bank.getArrayList().remove(acc);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information dialogue");
                alert.setHeaderText(null);
                alert.setContentText("Account removed Successfully");
                alert.showAndWait();
                textField1.setText("");

            }

        });

        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }

    public void applyEndOfMonth(Stage primaryStage) {


        //creating label
        Text text1 = new Text("Apply End Of Month:");
        Text txt = new Text("");
        //Creating Buttons 

        Button button2 = new Button("Back");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(txt, 0, 2);
        gridPane.add(button2, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        bank.getArrayList().forEach((account) -> {
            account.balance = account.getMonthlyEnd();
            // reset transaction counter once end of the month interest

            account.transaction = 0;

        });

        txt.setText("All accounts updated successfully!");
        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });


    }

    public void bankStatistics(Stage primaryStage) {
        ArrayList<String> list = new ArrayList<String>();
        Text label = new Text("Bank Statistics");
        label.setFont(new Font("Arial", 20));

        Text text1 = new Text("Total Bank Balance: ");
        Text text2 = new Text("Average Balance: ");
        Text text3 = new Text("Empty Accounts: ");
        Text text4 = new Text("Big Account: ");

        Text totalAccount = new Text("");
        Text averageBalance = new Text("");
        Text emptyAccount = new Text("");
        Text bigAccount = new Text("");

        Button button2 = new Button("Back");

        //Create a Grid Pane
        GridPane gridPane = new GridPane();

        //Arrange all the nodes in the grid
        gridPane.add(label, 0, 0);
        gridPane.add(text1, 0, 1);
        gridPane.add(totalAccount, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(emptyAccount, 1, 2);
        gridPane.add(text2, 0, 3);
        gridPane.add(averageBalance, 1, 3);
        gridPane.add(text4, 0, 4);
        gridPane.add(bigAccount, 1, 4);
        gridPane.add(button2, 0, 5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();


        list = bank.displayBankStatistics();
        totalAccount.setText(list.get(0));
        emptyAccount.setText(list.get(1));
        averageBalance.setText(list.get(2));
        bigAccount.setText(list.get(3));
        System.out.println(list.get(0));
        System.out.println(list.toString());


        button2.setOnAction(e -> {
            mainWindow(primaryStage);
        });
    }


}

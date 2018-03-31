/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea addressArea;
    @FXML
    private TextField balanceField;
    private ObservableList<BankAccount> bankAccountList;
    @FXML
    private ListView<BankAccount> accountListView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bankAccountList = FXCollections.observableArrayList();
        accountListView.setItems(bankAccountList);
        
        try {
            RandomAccessFile input = new RandomAccessFile("accounts.txt", "r");

            int accountNumber = 0;
            String accountName = "";
            String address = "";
            double balance = 0.0;
            int countData = 0;

            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }

                String tokens[] = line.split(":");

                switch (tokens[0]) {
                    case "accountNumber":
                        accountNumber = Integer.parseInt(tokens[1]);
                        countData++;
                        break;
                    case "accountName":
                        accountName = tokens[1];
                        countData++;
                        break;
                    case "address":
                        address = tokens[1];
                        countData++;
                        break;
                    case "balance":
                        balance = Double.parseDouble(tokens[1]);
                        countData++;
                        break;
                    default:
                        System.err.println("Incorrect entry");
                        break;
                }
                /*
                if (tokens[0].equals("accountNumber")) {
                    accountNumber = Integer.parseInt(tokens[1]);
                    countData++;
                } else if (tokens[0].equals("accountName")) {
                    accountName = tokens[1];
                    countData++;
                } else if (tokens[0].equals("address")) {
                    address = tokens[1];
                    countData++;
                } else if (tokens[0].equals("balance")) {
                    balance = Double.parseDouble(tokens[1]);
                    countData++;
                }
                */

                if (countData % 4 == 0) {
                    BankAccount account = new BankAccount(accountNumber, accountName, address, balance);
                    bankAccountList.add(account);
                }
                /*
                int indexOfColon = line.indexOf(':');
                String label = line.substring(0, indexOfColon);
                String data = line.substring(indexOfColon + 1);
                System.out.println(label+"="+data);
                 */ /*
                String accountNumberText = input.readLine();
                if (accountNumberText == null)
                    break;
                
                // Homework: try to separate out the label from each line
                int accountNumber = Integer.parseInt(accountNumberText);
                String accountName = input.readLine();
                String address = input.readLine();
                double balance = Double.parseDouble(input.readLine());
                
                BankAccount account = new BankAccount(accountNumber, accountName, address, balance);
                
                bankAccountList.add(account);
                 */ {

                }
            }

            for (int i = 0; i < bankAccountList.size(); i++) {
                System.out.println(bankAccountList.get(i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleCreateAction(ActionEvent event) {
        String accountName = nameField.getText();
        String address = addressArea.getText();
        double balance = Double.parseDouble(balanceField.getText());

        BankAccount account = new BankAccount(accountName, address, balance);

        try {
            RandomAccessFile output = new RandomAccessFile("accounts.txt", "rw");
            output.seek(output.length());

            output.writeBytes(account.getAllData() + "\n");

            output.close();

            clearForm();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearForm() {
        numberField.clear();
        nameField.clear();
        addressArea.clear();
        balanceField.clear();
    }

    private void displayData(BankAccount account) {
        numberField.setText(account.getAccountNumber() + "");
        nameField.setText(account.getAccountName());
        addressArea.setText(account.getAddress().replaceAll(";", "\n"));
        balanceField.setText(account.getBalance() + "");
    }
    
    @FXML
    private void handleListClickAction(MouseEvent event) {
        BankAccount selectedAccount = accountListView.getSelectionModel().getSelectedItem();
        displayData(selectedAccount);
    }
}

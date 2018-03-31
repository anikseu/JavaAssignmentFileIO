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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private ListView<?> accountList;
    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea addressArea;
    @FXML
    private TextField balanceField;
    private ArrayList<BankAccount> bankAccountList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bankAccountList = new ArrayList<>();
        
        try {
            RandomAccessFile input = new RandomAccessFile("accounts.txt", "r");
            
            while (true) {
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

            output.writeBytes(account.toString() + "\n");

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
}

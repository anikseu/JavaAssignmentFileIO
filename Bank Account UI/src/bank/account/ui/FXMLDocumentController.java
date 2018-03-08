/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField balanceTextField;
    @FXML
    private TextArea addressTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    // Homework: write a method to clear the form
    // You can call this method from both create and reset
    
    @FXML
    private void handleResetAction(ActionEvent event) {
        // Homework: implement this one
    }

    @FXML
    private void handleCreateAccountAction(ActionEvent event) {
        long accountId = Long.parseLong(idTextField.getText());
        String accountName = nameTextField.getText();
        String address = addressTextArea.getText();
        double balance = Double.parseDouble(balanceTextField.getText());
        
        BankAccount bankAccount = new BankAccount(accountId, accountName, address, balance);
        
        System.out.println(bankAccount);
        
        try {
            RandomAccessFile output = new RandomAccessFile("accounts.txt", "rw");
            long length = output.length();
            output.seek(length);
            output.writeBytes(bankAccount + "\n");
            
            // Homework: make sure that the form is cleared after a user account
            // is created. Add a label and show relevant messages (success/failure).
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

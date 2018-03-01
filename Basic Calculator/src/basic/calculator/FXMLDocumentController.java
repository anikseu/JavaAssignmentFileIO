/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    int num1;
    int num2;
    String operation;
    
    @FXML
    private TextField displayTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int x = 2+3*5/2+1-2+3;
        int y = 2;
        double z = x / y;
        System.out.println(x);
    }

    @FXML
    private void handleOneAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "1";
        else newValue = oldValue + "1";
        displayTextField.setText(newValue);
    }

    @FXML
    private void handleTwoAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "2";
        else newValue = oldValue + "2";
        displayTextField.setText(newValue);
    }

    @FXML
    private void handleZeroAction(ActionEvent event) {
        // Homework: add appropriate logic (if/else)
        // to check if there are any leading zeros
        // Hint: use startsWith method from the String class
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "0";
        else newValue = oldValue + "0";
        displayTextField.setText(newValue);        
    }

    @FXML
    private void handleThreeAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "3";
        else newValue = oldValue + "3";
        displayTextField.setText(newValue);        
    }

    @FXML
    private void handleAdditionAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num1 = Integer.parseInt(oldValue);
        displayTextField.clear();
        operation = "ADDITION";
        // Homework: write a method for yourself that converts
        // a string into an integer
        // for example: "126" -> 126
        // public int convertToInt(String input)
        // hint: use charAt method, subtract ASCII '0'
        
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num2 = Integer.parseInt(oldValue);        

        int result = 0;
        
        //if (operation == "ADDITION") // THIS IS WRONG
        if (operation.equals("ADDITION"))
            result = num1 + num2;
        
        // HOMEWORK: add the other operators
        // write code for them
        
        displayTextField.setText("" + result);
    }

}

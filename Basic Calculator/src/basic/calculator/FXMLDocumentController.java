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

    @FXML
    private TextField displayTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOneAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        String newValue = oldValue.concat("1");
//        String newValue = oldValue + "1";
        displayTextField.setText(newValue);
    }

    @FXML
    private void handleTwoAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        String newValue = oldValue + "2";
        displayTextField.setText(newValue);
    }

    @FXML
    private void handleZeroAction(ActionEvent event) {
        // Homework: add appropriate logic (if/else)
        // to check if there are any leading zeros
        // Hint: use startsWith method from the String class
        String oldValue = displayTextField.getText();
        String newValue = oldValue + "0";
        displayTextField.setText(newValue);        
    }

}

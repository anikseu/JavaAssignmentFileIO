/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField firstTextField;
    @FXML
    private TextField secondTextField;
    @FXML
    private Button copyButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleCopyAction(ActionEvent event) {
        String text = firstTextField.getText();
        text = text.toUpperCase();
        text = text.trim();
        // homework: Hava look at the methods of the String class
        secondTextField.setText(text);
        firstTextField.clear();
    }
    
}

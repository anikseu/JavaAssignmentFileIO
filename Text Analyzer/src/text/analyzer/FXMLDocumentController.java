/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.analyzer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String text = "Hello\nWorld\n";
        textArea.setText(text);
        textArea.appendText("Here goes another line");
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.analyzer;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea textArea;
    @FXML
    private TextField filenameTextField;
    @FXML
    private Button fileOpenButton;
    @FXML
    private TextField wordsTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String text = "Hello\nWorld\n";
        textArea.setText(text);
        textArea.appendText("Here goes another line");
        wordsTextField.setText("1");
    }    

    @FXML
    private void handleFileOpenAction(ActionEvent event) {
        // Homework: try to use FileChooser
        String filename = filenameTextField.getText();
        
        textArea.clear();
        
        try {
            RandomAccessFile input = new RandomAccessFile(filename, "r");
            
            String line;
            String filecontent = "";
            while (true) {
                line = input.readLine();
                if (line == null)
                    break;
                // The following line is ugly!
                // We should use StringBuilder instead
                filecontent = filecontent + " " + line;
                textArea.appendText(line + "\n");
            }
            
            int words = countWords(filecontent);
            wordsTextField.setText("" + words);
        } catch (FileNotFoundException ex) {
            System.err.println("File does not exist");
        } catch (IOException ex) {
            System.err.println("Some I/O exception occured");
        }
    }

    private int countWords(String filecontent) {
        // For future:
        // Once you've completed CSE3025, revisit this problem
        // You need to know what Regular Expressions are
        int count = 0;
        
        while (filecontent.contains("  "))
            filecontent = filecontent.replaceAll("  ", " ");
        filecontent = filecontent.trim();
        
        for (int i = 0; i < filecontent.length(); i++)
            if (filecontent.charAt(i) == ' ' || filecontent.charAt(i) == ',')
                count++;
        
        if (filecontent.length() != 0)
            return count + 1;
        else return 0;
    }
    
}

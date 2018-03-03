/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.RandomAccessFile;

/**
 *
 * @author kmhasan
 */
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //readFromFile();
        writeToFile();
    }

    private static void readFromFile() {
        try {
            RandomAccessFile input = new RandomAccessFile("input.txt", "r");
            String line;

            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            
            input.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find input.txt!");
        } catch (IOException ioe) {
            System.err.println("Some IOException occured");
        }
    }

    private static void writeToFile() {
        String text = "This is some new text";
        try {
            RandomAccessFile output = new RandomAccessFile("output.txt", "rw");
            //output.setLength(0); // to erase everything
            long length = output.length();
            output.seek(length);
            output.writeBytes(text + "\n");
            
            output.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find input.txt!");
        } catch (IOException ioe) {
            System.err.println("Some IOException occured");
        }
    }
    
    // Homework: write a program that copies from one file and writes to another

}

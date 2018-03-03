/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttointeger;

/**
 *
 * @author kmhasan
 */
public class TextToInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = "1276.3552";
        int number = convertToInteger(text);
        number++;
        System.out.println(number);
    }

    // Homework:
    // modify this code to make it work for both positive
    // and negative integers
    // write another method that works for floating point
    // numbers
    
    // Reference: study Horner's rule for evaluating polynomials
    // P(x) = 2x^2 - 5x + 20
    private static int convertToInteger(String text) {
        int number = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int digit = ch - '0';
            number = number * 10 + digit;
        }
        return number;
    }
    
}

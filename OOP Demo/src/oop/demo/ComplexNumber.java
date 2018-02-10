/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo;

/**
 *
 * @author kmhasan
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public void print() {
        System.out.printf("%.3f + %.3fi\n", real, imaginary);
    }
    
    public ComplexNumber add(ComplexNumber b) {
        ComplexNumber a = this;
        
        double r = a.real + b.real;
        double i = a.imaginary + b.imaginary;
        
        ComplexNumber c = new ComplexNumber(r, i);
        
        return c;
    }
}

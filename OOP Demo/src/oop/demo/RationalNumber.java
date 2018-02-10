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
public class RationalNumber {
    private long numerator;
    private long denominator;

    public RationalNumber(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public RationalNumber add(RationalNumber b) {
        RationalNumber a = this;
        
        long n = a.numerator * b.denominator + a.denominator * b.numerator;
        long d = a.denominator * b.denominator;
        
        RationalNumber c = new RationalNumber(n, d);
        
        return c;
    }
    
    public RationalNumber subtract(RationalNumber b) {
        RationalNumber a = this;
        
        long n = a.numerator * b.denominator - a.denominator * b.numerator;
        long d = a.denominator * b.denominator;
        
        RationalNumber c = new RationalNumber(n, d);
        
        return c;
    }

    public void print() {
        System.out.printf("%d/%d\n", numerator, denominator);
    }
}

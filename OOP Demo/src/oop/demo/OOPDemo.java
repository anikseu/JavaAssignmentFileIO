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
public class OOPDemo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("Hello World\n");
        
        /*
        Dynamic Memory Allocation
        
        in C++:
        Student *s1 = new Student();
        delete s1;
        
        in C:
        Student *s1 = (Student*) malloc(sizeof(Student));
        free(s1);
        */
        Student s1 = new Student(113, "Hasan Tareque", "Shantinagar", 4.33);
        Student s2;
        
        s1.setAddress("Notun Bazar");
        System.out.printf("ID: %d, Name: %s, Address: %s, HSC GPA: %.2f\n", s1.getStudentId(),
                s1.getStudentName(), s1.getAddress(), s1.getHscGpa());
        
        
        RationalNumber a = new RationalNumber(10, 6);
        RationalNumber b = new RationalNumber(2, 3);
        RationalNumber c = a.add(b);
        
        a.print();
        b.print();
        c.print();
        
        ComplexNumber x = new ComplexNumber(2, 5);
        ComplexNumber y = new ComplexNumber(4, -2);
        ComplexNumber z = x.add(y);
        
        x.print();
        y.print();
        z.print();
    }
    
}

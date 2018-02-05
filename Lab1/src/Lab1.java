import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmhasan
 */
public class Lab1 {

    // Task 1: read two numbers from the user
    // add them up and print the result
    public static void task1() {
        /*
        in C to read two numbers and to show the result
        of addition we do the following:
        
        int x, y, result;
        printf("Enter two numbers\n");
        scanf("%d", &x);
        scanf("%d", &y);
        result = x + y;
        printf("The result of addition: %d\n", result);
        */

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter two numbers\n");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int result = x + y;
        System.out.printf("The result of addition: %d\n", result);
    }
    
    //Task 2: Read two integers a and b from the user
    //print the result of summation of all numbers in the
    //range [a, b]
    //Do not use the formula even if you know that already
    //I want to see the use of a loop
    //Example: 2 6
    //Answer: 2 + 3 + 4 + 5 + 6 = 20
    private static void task2() {
        // ADD YOUR CODE HERE
    }
    
    //Task 3: Read a number n from the user then read
    //n more numbers. Find out the average of all these
    //n numbers.
    private static void task3() {
        // ADD YOUR CODE HERE
    }
    
    //Task 4: Read a number n from the user then read
    //n more numbers. Find out the largest distance between
    //any pair of numbers.
    //Hint: find the min and the max and print max - min.
    //Example: 5 3 7 1 6 4
    private static void task4() {
        // ADD YOUR CODE HERE
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        task1();
        task2();
//        task3();
//        task4();
        
    }
    
}

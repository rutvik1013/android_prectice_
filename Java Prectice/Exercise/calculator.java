// Write a program to make addition, Subtraction, Multiplication and Division of
//Two Numbers.

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        int a,b;
        Scanner calc=new Scanner(System.in);
        
        System.out.println("Enter 1st Number: ");
        a=calc.nextInt();

        System.out.println("Enter 2nd Number: ");
        b=calc.nextInt();


        int addition=a+b;
        System.out.println("Addition: "+addition);

        int substraction=a-b;
        System.out.println("Substration: "+substraction);

        long multiplication=a*b;
        System.out.println("Multiplication: "+multiplication);

        double division=a/b;
        System.out.println("Division: "+division);

        
    }
    
}

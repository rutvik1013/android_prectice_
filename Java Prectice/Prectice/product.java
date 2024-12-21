import java.util.Scanner;

public class product {
    public static void main(String[] args) {
        float num1,num2,product;

        Scanner scr=new Scanner(System.in);

        System.out.print("Enter 1st Floating-point Number: ");
        num1=scr.nextFloat();

        System.out.print("Enter 2nd Floating-point Number: ");
        num2=scr.nextFloat();

        product=num1*num2;

        System.out.println("The Product of "+num1 + "and" +num2 + " is: " +product);

    }
    
}

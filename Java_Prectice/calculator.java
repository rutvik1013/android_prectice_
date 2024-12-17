import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        int a,b;

      Scanner sc=new Scanner(System.in);

        System.out.print("Enter 1st Number: ");
        a=sc.nextInt();

        System.out.print("Enter 2nd Number: ");
        b=sc.nextInt();

        // Perform addition

        int addition=a+b;
        System.out.println("Addition: "+addition);

        int substraction=a-b;
        System.out.println("Substraction: "+substraction);

        long multiplication=a*b;
        System.out.println("Multiplication: "+multiplication);

        double division=a/b;
        System.out.println("Division: "+division);
    }
    
}

import java.util.Scanner;

public class swapnumber {
    public static void main(String[] args) {
        int a,b;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the 1st Number: ");
        a=sc.nextInt();

        System.out.println("Enter the 2nd Number: ");
        b=sc.nextInt();

        System.out.println("Before Swipping: ");
        System.out.println("First Number: "+a);
        System.out.println("Second Number: "+b);

         // Swap numbers without a third variable
         a=a+b;
         b=a-b;
         a=a-b;

         System.out.println("After swapping:");
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
    }
    
}

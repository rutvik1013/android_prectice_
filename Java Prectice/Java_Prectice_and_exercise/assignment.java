import java.util.Scanner;

public class assignment {
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the 1st Number: ");
        a=sc.nextInt();

        System.out.println("Enter the 2nd Number: ");
        b=sc.nextInt();

        System.out.println("Before Swipping: ");
        System.out.println("First Number: "+a);
        System.out.println("Second Number: "+b);

         // Swap numbers using third variables
        c=a;
        a=b;
        b=c;

         System.out.println("After swapping:");
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
    }
    
}

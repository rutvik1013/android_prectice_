import java.util.Scanner;

public class addtwonumbers {
    public static void main(String[] args) {
        Scanner str=new Scanner(System.in);

        int a,b,sum;

        System.out.print("Enter 1St Number:" );
        a=str.nextInt();

        System.out.println("Enter 2nd Number: ");
        b=str.nextInt();

        sum=a+b;

        System.out.println("The Sum of Two Number is: "+sum);

        
    }
    
}

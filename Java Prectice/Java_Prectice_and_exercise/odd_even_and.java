import java.util.Scanner;

public class odd_even_and {
    public static void main(String[] args) {
        int number;
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter Number: ");
        number=scanner.nextInt();

        if ((number&1)==1) {
            System.out.println("Odd Number");
            
        }
        else
        {
            System.out.println("Even Number");
        }
    }
    
}

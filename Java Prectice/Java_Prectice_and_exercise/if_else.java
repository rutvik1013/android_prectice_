import java.util.Scanner;

public class if_else {
    public static void main(String[] args) {
        int age;

        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to Licence Portal\n\n");

        System.out.println("Enter Your Age:");
        age=sc.nextInt();

        if (age>=18) {
            System.out.println("You are Eligible for Licence");
        }
        else
        {
            System.out.println("You Are Not eligibe");
        }
    }
}

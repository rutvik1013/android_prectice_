import java.util.Scanner;

public class bitwise_operator {
    public static void main(String[] args) {
        // bitwise AND

    int num1,num2;
    Scanner scanner=new Scanner(System.in);

        System.out.print("Enter  number: ");
        num1=scanner.nextInt();

        // System.out.print("Enter 2nd number:");
        // num2=scanner.nextInt();

        //int result=num1&num2;

        // Bitwase OR

        // int result=num1|num2;

        // Bitwise XOR
        // int result=num1^num2;

        // Bitwise Compliment
        // int result=~num1;
        

        // Left Shift Operator 
        // int result=num1<<5;      

        // Righ Shift Operator
        int result=num1>>5;
        System.out.println("Result: "+result);


    }
    
}

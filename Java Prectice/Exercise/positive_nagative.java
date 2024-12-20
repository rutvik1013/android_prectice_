import java.util.Scanner;

public class positive_nagative {
    public static void main(String[] args) {
        int number;
        Scanner str=new Scanner(System.in);

        System.out.println("Enter Number: ");
        number=str.nextInt();

        if (number>0) {
            System.out.println(number+ " is a Positive Number");
            
        }
        else if (number<0) {
            System.out.println(number+ "is a Nagative Number");
            
        }
        else
        {
            System.out.println(number+ "Number is Zero");
        }
    }
    
}

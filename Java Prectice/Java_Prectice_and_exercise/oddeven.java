import java.util.Scanner;

public class oddeven {
    public static void main(String[] args) {
        int number;

        Scanner strc=new Scanner(System.in);

        System.out.print("Enter Number: ");
        number=strc.nextInt();

        if (number%2==0) {
            System.out.println(number+" is Even");
        }
        else{
            System.out.println(number+" is Odd");
        }
    }
    
}

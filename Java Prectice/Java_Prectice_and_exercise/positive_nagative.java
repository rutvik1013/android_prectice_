import java.util.Scanner;

public class positive_nagative {
    public static void main(String[] args) {
        int number;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number:");
        number=sc.nextInt();

        if (number>0) {
            System.out.println(number+" Positive Number\n");
            
        }
        else if (number<0) {
            System.out.println(number+" Nagative Number\n");
        }
        else{
            System.out.println(number+" Number is Zero");
        }
    }
    

    
}

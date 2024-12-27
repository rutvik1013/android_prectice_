import java.util.Scanner;

public class leapyear {
    public static void main(String[] args) {
        int year;

        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the Year: ");
        year=scanner.nextInt();

        // if (year%400==0||(year%4==0&&year%100!=0)) {
        //     System.out.println(year+" Leap Year");
        // }
        // else{
        //     System.out.println(year+" Year is not Leap Year");
        //  }

        if (year%400==0) {
            System.out.println(year+" Leap Year");
        }
        else if (year%100==0) {
            System.out.println(year+" Year is not Leap Year");
        }
        else if (year%4==0) {
            System.out.println(year+" Leap Year");
        }
        else
        {
            System.out.println("Year is not Leap Year");
        }



    }
    
}

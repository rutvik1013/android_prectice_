import java.util.Scanner;

public class grade {
    public static void main(String[] args) {
        int C,Java,Kotlin,Ai,ML,total;
        float percentage;

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the Marks of C Programming: ");
        C=sc.nextInt();

        System.out.print("Enter the Marks of Java: ");
        Java=sc.nextInt();

        System.out.print("Enter the Marks of Kotlin: ");
        Kotlin=sc.nextInt();

        System.out.print("Enter the Marks of Artificial intelligence: ");
        Ai=sc.nextInt();

        System.out.print("Enter the Marks of Machiene Learning: ");
        ML=sc.nextInt();

        total=C+Java+Kotlin+Ai+ML;
        System.out.println("Total: "+total);

        percentage=total/5;
        System.out.println("Percentage: "+percentage);

        if (percentage>90) {
            System.out.println(" Grade:A");
        }
        else if (percentage>=75) {
            System.out.println(" Grade:B");
        }
        else if (percentage>=60) {
            System.out.println(" Grade:C");
        }
        else if (percentage>=30) {
            System.out.println(" Grade:D");
        }
        else
        {
            System.out.println("Fail");
        }
    }
    
}

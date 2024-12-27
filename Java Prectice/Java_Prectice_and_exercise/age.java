import java.util.Scanner;

public class age {
    public static void main(String[] args) {
        int age;
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter Your Age: ");
        age=scanner.nextInt();

        if (age>=13) {
            System.out.println("Child");
        }
        else if (age>=20) {
            System.out.println("Teenage");
        }
        else if (age>=60) {
            System.out.println("Adult");
        }
        else if (age>=60) {
            System.out.println("Senior");
        }
    }
    
}

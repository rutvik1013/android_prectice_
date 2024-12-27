import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        // Initialize the maximum variable
        int max;

        // Use nested if to find the maximum
        if (num1 > num2) {
            if (num1 > num3) {
                max = num1;
            } else {
                max = num3;
            }
        } else {
            if (num2 > num3) {
                max = num2;
            } else {
                max = num3;
            }
        }

        // Display the maximum number
        System.out.println("The maximum number is: " + max);
    }
}

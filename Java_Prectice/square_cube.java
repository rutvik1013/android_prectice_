import java.util.Scanner;

public class square_cube {
    public static void main(String[] args) {
        int square,cube,number;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number: ");
        number=sc.nextInt();

        square=number*number;
        cube=number*number*number;

        System.out.println("Square: "+square);
        System.out.println("Cube: "+cube);

    }
}

import java.util.Scanner;

public class squareandcube {
    public static void main(String[] args) {
        int n,square,cube;

        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter Number: ");
        n=sc.nextInt();

        square=n*n;
        cube=n*n*n;

        System.out.println("Square: "+square);
        System.out.println("Cube: "+cube);

        
    }
    
}

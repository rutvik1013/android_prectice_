import java.util.Scanner;

public class rectangle {
    public static void main(String[] args) {
        int length,width;
        double perimeter;

        Scanner scrt=new Scanner(System.in);


        System.out.print("Enter the Length of the Rectangle: ");
        length=scrt.nextInt();

        System.out.println("Enter the breadth of the Rectangle: ");
        width=scrt.nextInt();

        perimeter=2*(length+width);

        System.out.println("The Perimeter of Rectangle is: "+perimeter);

        
    }


    
}

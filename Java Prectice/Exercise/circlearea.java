import java.util.Scanner;

// Write a program to find the Area of Circle

public class circlearea {
    public static void main(String[] args) {
        double radius,area;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Radius of the circle: ");
        radius=sc.nextDouble();

        area=Math.PI*radius*radius;

        System.out.println("The Area of the circle is: "+area);

    }
    
}

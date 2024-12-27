import java.util.Scanner;

public class circle {
    public static void main(String[] args) {
        double radius,area;

        Scanner str=new Scanner(System.in);
        System.out.println("Enter thwe radius of circle: ");
        radius=str.nextDouble();
        area=Math.PI*radius*radius;

        System.out.println("Area of circle is: "+area);
        
    }
    
}

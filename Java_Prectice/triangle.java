import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        float base,height,Area;
        Scanner area=new Scanner(System.in);

        System.out.println("Enter the base of Triangle: ");
        base=area.nextFloat();

        System.out.println("Enter the height of Triangle: ");
        height=area.nextFloat();

        Area=(base*height)/2;

        System.out.println("The area of tringle is: "+Area);

    }
    
}

// Write a program to find the Area of Triangle

import java.util.Scanner;

public class triangle {
        public static void main(String[] args) {
            int base,height,area;
            Scanner str=new Scanner(System.in);

            System.out.println("Enter the base of triangle: ");
            base=str.nextInt();

            System.out.println("Enter the height of the triangle: ");
            height=str.nextInt();

            area=(base*height)/2;

            System.out.println("The area of Triangle is: "+area);
            


        }    
}

import java.util.Scanner;

public class celcius {
    public static void main(String[] args) {
        double celcius,fehrenheit;

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the temperature of the celcius:");
        celcius=sc.nextDouble();

        fehrenheit=(celcius*9/5)+32;
        System.out.println("Fahrenheit: "+fehrenheit);32
        
    }
    
}

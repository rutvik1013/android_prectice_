import java.util.Scanner;

public class temperature {
    public static void main(String[] args) {
        int celcius,fahrenheit;

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter temparature in fahrenheit:");
        fahrenheit=sc.nextInt();

        celcius=(fahrenheit-32)*5/9;

        System.out.println("Temperature: "+celcius +"°C");
    }
    
}

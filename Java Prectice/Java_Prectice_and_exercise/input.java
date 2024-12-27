import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Your Name: ");
        String name=sc.nextLine();
        System.out.println("Keep it Up!" +name);
        System.out.println(name+ "Also You have to Enter your Age: ");
        int Age=sc.nextInt();
        System.out.println("Your Age is: "+Age);



    }
    
}

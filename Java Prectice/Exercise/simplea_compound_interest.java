import java.util.Scanner;
// Write a program to find the simple Interest and compound interest.
public class simplea_compound_interest {
    public static void main(String[] args) {
        double principles,rate,time;
        double simple_interest,compound_interest;

        Scanner amt=new Scanner(System.in);

        System.out.println("Enter the Principle Amount: ");
        principles=amt.nextDouble();

        System.out.println("Enter the Rate of Amount: ");
        rate=amt.nextDouble();

        System.out.println("Enter the Duration of Amount: ");
        time=amt.nextDouble();

        simple_interest=(principles*rate*time)/100;

        compound_interest=principles*Math.pow((1+rate/100),time)-principles;

        System.out.println("Simple interest: "+simple_interest);
        System.out.println("Compound interest: "+compound_interest);

        


    }
    
}

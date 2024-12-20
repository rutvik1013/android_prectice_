import java.util.Scanner;

public class strudent {
    public static void main(String[] args) {
        int C,Java,Kotlin,Ai,ML,total;
        float per;

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the marks of C Programming: ");
        C=sc.nextInt();

        System.out.println("Enter the Marks of Java Language: ");
        Java=sc.nextInt();

        System.out.println("Enter the Marks of Kotlin: ");
        Kotlin=sc.nextInt();

        System.out.println("Enter the Marks of Artificial intelligence: ");
        Ai=sc.nextInt();

        System.out.println("Enter thev Marks of Machiene Learning: ");
        ML=sc.nextInt();

        total=C+Java+Kotlin+Ai+ML;
        per=total/5;

        System.out.println("ToTAL: "+total);
        System.out.println("Percentage:"+per);
        
        if (per>75) {
            System.out.println("Distiction");
            
        }
        else if (per>60&&per<=75) {
                System.out.println("First Class");            
        }
        else if (per>50&&per<=60) {
            System.out.println("Second Class");
            
        }
        else if (per>35&&per<=50) {
            System.out.println("Pass Class");
            
        }
        else{
            System.out.println("Fail");
        }
    }
    
}

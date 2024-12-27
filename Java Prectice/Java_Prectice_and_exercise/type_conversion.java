public class type_conversion {
    public static void main(String[] args) {
        // double d=100.04;
        // Explicit type casting by forcefully getting
        // data from long datatype to integer type
        // long l=(long)d;
        // int i=(int)l;

        // System.out.println("Double Value: "+d);
        // // While printing we will see that
        // // fractional part lost
        // System.out.println("Long Value: "+l);
        // System.out.println("Int Value: "+i);


        // Java Program to Illustrate Conversion of
// Integer and Double to Byte
        byte b;
        int i=250;
        double d=345.78;

        System.out.println("Conversion of int to byte");
        b=(byte)i;

        System.out.println("i= " + i +"b= " +b);
        System.out.println("\n Conversion of double to byte");
        b=(byte)d;

        System.out.println("d = " + d + " b= " + b);

    }
    
}

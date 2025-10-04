import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // System.setOut(new PrintStream("D:\\MCA-1st-Year\\demo.txt"));
        // System.out.println("today is sat and time is 12:30");

        // PrintStream out = new PrintStream("D:\\MCA-1st-Year\\demo.txt");
        // out.println("this statement uses no system class");

 
        new PrintStream("D:\\MCA-1st-Year\\demo.txt").println("this statement uses no system class");
    }
}

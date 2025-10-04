import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {

        // to take int as an input we use
        // objet_name.nextInt();

        // to take String as an input we have
        // 1. object_name.next();
        // 2. object_name.nextLine();

        // to take double as an input we have
        // object_name.nextDouble();

        // to take float as an input we have
        // objet_name.nextFloat();

        // we are creating an object of Scanner class using new keyword
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your phone");
        int phone = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter your name");
        String name = sc.nextLine();
        System.out.println("Please enter your house no");
        int add = sc.nextInt();

        System.out.println("Your name is :" + name);
        System.out.println("Your phone is :" + phone);
        System.out.println("Your add is :" + add);

    }
}

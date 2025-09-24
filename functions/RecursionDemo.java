package functions;

public class RecursionDemo {
    public static void main(String[] args) {
        RecursionDemo rd = new RecursionDemo(); // object
        rd.printData2(5);
    }

    void printData2(int count) {
        // this is the base case, where recursion ends
        if (count <= 0) {
            return;
        }
        // function recall (recursive call)
        printData2(count - 1);
        // Business Logic or Logic
        System.out.println(count);

    }

}

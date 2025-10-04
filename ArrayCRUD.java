import java.util.Scanner;

public class ArrayCRUD {

    // CRUD  - Create, Read, Update, Delete
    static int[] arr;

    static void createArray(Scanner sc) {
        System.out.println("Please enter the size of the array");
        int size = sc.nextInt();
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Please enter the " + (i + 1) + " value");
            arr[i] = sc.nextInt();
        }
    }

    static void readArray() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    static void updateArray(Scanner sc) {
        System.out.println("Please enter the index u want to update");
        int index = sc.nextInt();
        System.out.println("Please enter the new value");
        int value = sc.nextInt();
        arr[index] = value;
    }

    static void deleteArray(Scanner sc) {
        System.out.println("Please enter the index value u wish to delete");
        int deleteIndex = sc.nextInt();
        for (int i = deleteIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter 1 to create array");
            System.out.println("Please enter 2 to read array");
            System.out.println("Please enter 3 to update array");
            System.out.println("Please enter 4 to delete array");
            int choice = sc.nextInt();

            if (choice == 1) {
                createArray(sc);
            } else if (choice == 2) {
                readArray();
            } else if (choice == 3) {
                updateArray(sc);
            } else if (choice == 4) {
                deleteArray(sc);
            } else {
                System.out.println("The choice is invalid");
            }
        }
    }
}
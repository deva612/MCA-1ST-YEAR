public class NestedClasses {
    //this is non-static type of fn, if u need to call this type of fn u need to create an object
    void printData() {
        System.out.println("NestedClasses");
    }

    // this is the first type of inner class or nested class
    static public class Class1 {
        void printData() {
            System.out.println("Class1");
        }
    }

    // this is the second type of inner class or nested class
    public class Class2 {
        void printData() {
            System.out.println("Class2");
        }
    }

    // this is the third type of inner class or nested class
    static void createClass() {
        class Class3 {
            void printData() {
                System.out.println("Class3");
            }
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        NestedClasses nc = new NestedClasses();
        nc.printData();

        NestedClasses.Class1 c1 = new NestedClasses.Class1();

        c1.printData();

        NestedClasses.Class2 c2 = nc.new Class2();

        c2.printData();
    }
}

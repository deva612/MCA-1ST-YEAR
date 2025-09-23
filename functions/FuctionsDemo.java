package functions;

public class FuctionsDemo {
    //this is the first type of function having no return type (void) and has zero args
    void sum1(){

    }
    //this is the second type of function having no return type (void) but has 2 args
    void sum2(int a , int b){

    }
    //this is the third type of function having int return type and has zero args
    int sum3(){
        return 0;
    }
    //this is the fourth type of function having int return type and 2 args
    int sum4(int a, int b){
        return 0;
    }


    static void sum5(String name){

    }
    static void sum6(String... name){

    }
    
    // public static void main(String[] args) {    //1 (Array)
    // public static void main(String... args) {   //2 (var args)
    // public static void main(String[] args) { //3
     static public void main(String[] sadfghj) { //3

        //String []args is called command line args
        FuctionsDemo.sum5("Vansh");
        FuctionsDemo.sum6("Vansh", "Kumar", "mca");
    }
}

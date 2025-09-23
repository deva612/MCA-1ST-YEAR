public class Reverse {
    public static void main(String[] args) {
        int num = 8459; //845 //84 //8 //0
        int rev = 0; //9 //95 //954 //9548
        while (num != 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }

    }
}

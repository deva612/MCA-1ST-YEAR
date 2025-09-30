public class SumOfDigits {

    int findSum(int num) {
        if (num <= 0) {
            return 0;
        }
        return (num % 10) + findSum(num / 10);
    }



    public static void main(String[] args) {
        int num = 8459;
        int sum = 0;
        while (num != 0) {
            int last = num % 10;
            sum = sum + last;
            num = num / 10;
        }
    }
}

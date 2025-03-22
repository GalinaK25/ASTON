package Task6_junit;

public class Factorial {
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n! for n < 0 is impossible");
        }

        if (n > 20) {
            throw new IllegalArgumentException("n! calculation exceeds limits");
        }

        long factorial = 1;//if (n=0 || n=1) {n! = 1}
        for (int i = 2; i <= n; i++) {
            factorial = factorial * i;
        }
        System.out.printf("%d!= %d%n", n, factorial);
        return factorial;
    }

    public static void main(String[] args) {

    }
}
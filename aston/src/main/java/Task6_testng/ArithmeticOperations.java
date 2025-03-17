package Task6_testng;

public class ArithmeticOperations {
    public static int add(int a, int b) {
        System.out.printf("%d + %d = %d%n", a, b, a + b);
        return a + b;
    }

    public static int subtract(int a, int b) {
        System.out.printf("%d - %d = %d%n", a, b, a - b);
        return a - b;
    }

    public static int multiply(int a, int b) {
        System.out.printf("%d * %d = %d%n", a, b, a * b);
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("/0 is impossible");
        }
        System.out.printf("%d / %d = %.2f%n", a, b, (double) a / b);
        return (double) a / b;
    }

    public static void main(String[] args) {

    }

}
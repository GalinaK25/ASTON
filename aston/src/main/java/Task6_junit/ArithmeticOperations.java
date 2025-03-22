package Task6_junit;

public class ArithmeticOperations {
    public static int add(int a, int b) {
        if ((b > 0 && a > Integer.MAX_VALUE - b)
                || (b < 0 && a < Integer.MIN_VALUE - b)) {
            throw new ArithmeticException("Сложение больших чисел должно вызвать переполнение");
        }
        System.out.printf("%d + %d = %d%n", a, b, a + b);
        return a + b;
    }

    public static int subtract(int a, int b) {
        System.out.printf("%d - %d = %d%n", a, b, a - b);
        return a - b;
    }

    public static int multiply(int a, int b) {
        if ((a > 0 && b > 0 && a > Integer.MAX_VALUE / b)
                || (a < 0 && b < 0 && a < Integer.MAX_VALUE / b)
                || ((a < 0 && b > 0 && a < Integer.MIN_VALUE / b)
                || (a > 0 && b < 0 && b < Integer.MIN_VALUE / a))) {
            throw new ArithmeticException("Умножение больших чисел должно вызвать переполнение");
        }
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
        try {
            System.out.println(add(Integer.MAX_VALUE, 1));
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(multiply(Integer.MAX_VALUE, 2));
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

    }
}
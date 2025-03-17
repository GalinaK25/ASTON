package Task6_junit;

public class NumberComparison {
    public static String compareNumbers(int a, int b) {
        if (a > b) {
            System.out.printf("%d > %d%n", a, b);
            return String.format("%d > %d", a, b);
        } else if (a < b) {
            System.out.printf("%d < %d%n", a, b);
            return String.format("%d < %d", a, b);
        } else {
            System.out.printf("%d = %d%n", a, b);
            return String.format("%d = %d", a, b);
        }
    }

    public static void main(String[] args) {
        compareNumbers(5, 10);
        compareNumbers(10, 5);
        compareNumbers(5, 5);
    }
}
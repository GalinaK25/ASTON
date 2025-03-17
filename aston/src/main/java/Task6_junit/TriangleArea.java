package Task6_junit;

public class TriangleArea {
    public static double calculateTriangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height should be > 0");
        }
        System.out.printf("Triangle Area = %.2f%n", base * height / 2);
        return base * height / 2;
    }

    public static void main(String[] args) {

    }
}

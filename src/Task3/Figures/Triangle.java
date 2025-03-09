package Task3.Figures;

public class Triangle implements Figure {
    String colorFill = "red";
    String colorBorder = "black";
    private final double a;
    private final double b;
    private final double c;
    private final double h;

    public Triangle(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    public double calcPerimeter() {
        return a + b + c;
    }

    public double calcSquare() {
        return h * c / 2;
    }

    @Override
    public String toString() {
        return "Triangle: " + "perimeter = " + String.format("%.2f", calcPerimeter()) + "; square = " + String.format("%.2f", calcSquare())
                + "; colorFon = " + colorFill + "; colorBorder = " + colorBorder;
    }
    //with toString as you comment
    public void printTriangleInfo(Triangle triangle) {
        System.out.println(triangle);
    }

}

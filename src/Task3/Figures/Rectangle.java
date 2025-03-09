package Task3.Figures;

class Rectangle implements Figure {
    String colorFill = "green";
    String colorBorder = "black";
    private final double a;
    private final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calcPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public double calcSquare() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle: " + "perimeter = " + String.format("%.2f", calcPerimeter()) + "; square = " + String.format("%.2f", calcSquare())
                + "; colorFon = " + colorFill + "; colorBorder = " + colorBorder;
    }
    //with toString as you comment
    public void printRectangleInfo(Rectangle rectangle) {
        System.out.println(rectangle);
    }

}

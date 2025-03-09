package Task3.Figures;

class Circle implements Figure {
    String colorFill = "yellow";
    String colorBorder = "black";
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calcSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle: " + "perimeter = " + String.format("%.2f", calcPerimeter()) + "; square = " + String.format("%.2f", calcSquare())
                + "; colorFon = " + colorFill + "; colorBorder = " + colorBorder;
    }

    //with toString() as you comment
    public void printCircleInfo(Circle circle) {
        System.out.println(circle);
    }

}

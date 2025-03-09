package Task3.Figures;

public class FigureApp {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5.2,3.5,2.0, 5);
        triangle.printTriangleInfo(triangle);
        Circle circle = new Circle(5);
        circle.printCircleInfo(circle);
        Rectangle rectangle = new Rectangle(5.21,3.51);
        rectangle.printRectangleInfo(rectangle);
    }
}
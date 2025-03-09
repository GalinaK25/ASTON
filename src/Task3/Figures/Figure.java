package Task3.Figures;

interface Figure {
    default double calcPerimeter() {
        return 0;
    }

    default double calcSquare() {
        return 0;
    }
}



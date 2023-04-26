package Task8;

interface GeometricFigure {
    double getArea();
}

class Circle implements GeometricFigure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements GeometricFigure {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

class Square implements GeometricFigure {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }
    public static void main(String[] args) {
        GeometricFigure[] figures = {new Circle(5), new Triangle(3, 4), new Square(2)};
        double totalArea = 0;

        for (GeometricFigure figure : figures) {
            totalArea += figure.getArea();
        }

        System.out.println("Total area of all figures: " + totalArea);
    }
}

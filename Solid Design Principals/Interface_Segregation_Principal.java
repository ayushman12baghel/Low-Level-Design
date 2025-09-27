import java.util.*;

// ISP Violated ->

// Single interface for all shapes (Violates ISP)
interface Shape {
    double area();

    double volume(); // 2D shapes don't have volume!
}

// Square is a 2D shape but is forced to implement volume()
class Square implements Shape {
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Volume not applicable for Square"); // Unnecessary method
    }
}

// Rectangle is also a 2D shape but is forced to implement volume()
class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Volume not applicable for Rectangle"); // Unnecessary method
    }
}

// Cube is a 3D shape, so it actually has a volume
class Cube implements Shape {
    private double side;

    public Cube(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

// ISP Floowed ->

// Separate interface for 2D shapes
interface TwoDimensionalShape {
    double area();
}

// Separate interface for 3D shapes
interface ThreeDimensionalShape {
    double area();

    double volume();
}

// Square implements only the 2D interface
class Square implements TwoDimensionalShape {
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Rectangle implements only the 2D interface
class Rectangle implements TwoDimensionalShape {
    private double length, width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Cube implements the 3D interface
class Cube implements ThreeDimensionalShape {
    private double side;

    public Cube(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

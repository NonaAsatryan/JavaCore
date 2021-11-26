package chapter8;

public class RectangleAbstract extends FigureAbstract {

    RectangleAbstract(double a, double b) {
        super(a, b);
    }

    double area() {
        System.out.println("inside Area for Rectangle.");
        return dim1 * dim2;
    }
}

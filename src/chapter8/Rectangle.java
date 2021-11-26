package chapter8;

public class Rectangle extends Figure{

    Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    double area() {
        System.out.println("inside Area for Rectangle.");
        return dim1 * dim2;
    }
}

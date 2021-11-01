package classwork.calculator;

public class CalculatorTest {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int result = calculator.plus(22, 18);
        System.out.println(result);

        result = calculator.minus(22, 18);
        System.out.println(result);

        double d = calculator.divide(22, 18);
        System.out.println(d);

        long l = calculator.multiple(22, 18);
        System.out.println(l);

    }
}

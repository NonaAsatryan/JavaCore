package classwork.scannerExample;

import classwork.calculator.Calculator;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a");
        int a = scanner.nextInt();
        System.out.println("Please input b");
        int b = scanner.nextInt();
        System.out.println("Please input operation (+, -, *, /)");
        String operation = scanner.next();

        // ստեղծել Calculator կլասսի օբյեկտը
        // ստանալ operation-ը (+, -, *, /)
        // ստուգել, թե որ operation -ն է ներմուծված
        // կանչել calculator-ի համապատասխան օբյետկտը

        Calculator calculator = new Calculator();

        switch (operation) {
            case "+":
                System.out.println(calculator.plus(a,b));
                break;
            case "-":
                System.out.println(calculator.minus(a, b));
                break;
            case "*":
                System.out.println(calculator.multiple(a, b));
                break;
            case "/":
                System.out.println(calculator.divide(a, b));
                break;
            default:
                System.out.println("invalid operation");
        }
    }
}

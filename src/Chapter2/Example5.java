package Chapter2;

/*
  Demonstrate a block of code.
  Call this file "Example5.java"
 */

public class Example5 {
    public static void main(String[] args) {
        int x, y;
        y = 20;

        // the target of this loop is a block

        for(x = 0; x < 10; x++) {
            System.out.println("This is x: " + x);
            System.out.println("This is y: " + y);
            y = y - 2;
        }
        }
    }


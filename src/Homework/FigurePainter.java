package Homework;

public class FigurePainter {
    public static void main(String[] args) {
        /*
         * * * * *
         * * * *
         * * *
         * *
         *
         */
        for (int i = 0; i < 5; i++) {
            for (int j = i - 1; j < 4; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        /*
                 *
               * *
             * * *
           * * * *
         * * * * *
         */

        for (int i = 0; i < 5; i++) {

            for (int j = 2 * (5 - i); j >= 0; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        /*
                   *
                  * *
                 * * *
                * * * *
                 * * *
                  * *
                   *
         */
        for (int i = 1; i < 5; i++) {
            for (int j = 3; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k <= j; k++) {
                    System.out.print(" ");
                }
                for (int b = 1; b < 5 - j; b++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        System.out.println();
        System.out.println();

        /*
                * * * *
                  * * *
                    * *
                      *
         */

        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j> i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
            }
        }
        }


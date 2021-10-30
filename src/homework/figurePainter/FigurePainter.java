package homework.figurePainter;

public class FigurePainter {

    /*
         * * * * *
         * * * *
         * * *
         * *
         *
     */

    void figureOne(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j < 4; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /*
         *
         * *
         * * *
         * * * *
         * * * * *
     */

    void  figureTwo(int n, char b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    /*
                 *
               * *
             * * *
           * * * *
         * * * * *
     */

    void figureThree(int n, char a) {
        for (int i = 0; i < n; i++) {

            for (int j = 4; j > i; j--) {
                System.out.print("  ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    /*
            *
           * *
          * * *
         * * * *
          * * *
           * *
            *
     */

    void figureFour(int n, char d) {
        for (int i = 0; i < n; i++) {
            for (int j = 3; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
        for (int j = 1; j < n; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.print(" ");
            }
            for (int b = 1; b < 5 - j; b++) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    /*
          * * * *
            * * *
              * *
                *
     */

    void figureFive(int n, char y) {
        for (int i = n; i >= 1; i--) {
            for (int j = 4; j > i; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

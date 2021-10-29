package classwork;

public class SortArray {

    public static void main(String[] args) {

        int[] array = {3, 6, 9, 3, 1, 5, 8, 44, 63, 21};

        // սորտավորել հետևյալ մասիվը` փոքրից մեծ:

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            for (int i = 0; i < array.length; i++) {

                for (int j = 1; j < array.length - i; j++) {

                    if (array[j] < array[j - 1]) {
                        int tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }
                }
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");

            }
        }
    }



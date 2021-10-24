package Classwork;

public class ArrayExample2 {

    public static void main(String[] args) {

        int[] array = {3, 6, 9, 3, 1, 5, 8, 44, 63, 21};

        // սորտավորել հետևյալ մասիվը` փոքրից մեծ:

        int tmp = array[0];

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
    }
}



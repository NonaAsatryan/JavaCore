package Homework.ArrayUtil;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {4, 11, 8, 99, 85, 145, 27, 47, 55, 22};

        // Տպել մասիվի բոլոր էլեմենտները:

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println();

        // Տպել մասիվի ամենամեծ թիվը:

        int max = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("The maximum value: " + max);

        System.out.println();

        // Տպել մասիվի ամենափոքր թիվը:

        int min = array[0];

        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(" The minimum value: " + min);

        System.out.println();

        // Տպել մասիվի բոլոր զույգ էլեմենտները:

        System.out.println("Print all evens");

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println();
        System.out.println();

        // Տպել մասիվի բոլոր կենտ էլեմենտները:

        System.out.println("Print all odds");

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println();
        System.out.println();

        // Տպել մասիվի զույգ էլեմենտների քանակը:

            int evenCount = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    evenCount++;
                }
            }
            System.out.println("Number of even elements: " + evenCount);

            System.out.println();

        // Տպել մասիվի կենտ էլեմենտների քանակը:

        int oddCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddCount++;
            }
        }
        System.out.println("Number of odd elements: " + oddCount);

        System.out.println();

            // Տպել մասիվի բոլոր էլեմենտների միջին թվաբանականը:

            int sum1 = 0;

            for (int i = 0; i < array.length; i++) {
                sum1 = sum1 + array[i];
            }

            System.out.println("avg: " + sum1/ array.length);

            System.out.println();
            System.out.println();

            // Տպել մասիվի էլեմենտների գումարը:

            int sum = 0;

            for (int i = 0; i < array.length; i++) {

                sum = sum + array[i];
            }
            System.out.println("sum: " + sum);

        }

}




package Homework.ArrayUtil;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {4, 11, 8, 99, 85, 145, 27, 47, 55, 22};

        // Տպել մասիվի բոլոր էլեմենտները:

        for (int i = 0; i < 10; i++) {

            System.out.println(array[i]);
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
        System.out.println(" The maximum value: " + max);

        System.out.println();
        System.out.println();

        // Տպել մասիվի ամենափոքր թիվը:

        int min = array[1];

        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(" The minimum value: " + min);

        System.out.println();
        System.out.println();


        // Տպել մասիվի բոլոր զույգ և կենտ էլեմենտները:

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println("Even number: " + array[i]);
            } else
                System.out.println("Odd number: " + array[i]);
        }

        System.out.println();
        System.out.println();

        int even_count = 0;
        int odd_count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even_count++;
            }
            else
                odd_count++;
        }
        System.out.println("Number of even elements: " + even_count);
        System.out.println("Number of odd elements: " + odd_count);

        System.out.println();
        System.out.println();

        // Տպել մասիվի բոլոր էլեմենտների միջին թվաբանականը:

         int sum1 = 0;

        for (int i = 0; i < array.length; i++) {
            sum1 = sum1 + array[i];
        }
        double average = sum1 / array.length;
        System.out.println("The average is " + average);

        System.out.println();
        System.out.println();

        // Տպել մասիվի էլեմենտների գումարը:

        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            sum = sum + array [i];
        }
        System.out.println("The sum is " + sum);

    }

}





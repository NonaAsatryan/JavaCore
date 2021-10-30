package homework.arrayUtil1;

public class ArrayUtil1 {

    // Տպել մասիվի բոլոր էլեմենտները:

    void elements(int[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    // Տպել մասիվի ամենամեծ թիվը:

    void max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("The maximum value: " + max);
        System.out.println();
    }

    // Տպել մասիվի ամենափոքր թիվը:

    void min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(" The minimum value: " + min);
        System.out.println();
    }

    // Տպել մասիվի բոլոր զույգ էլեմենտները:

    void evens(int[] array) {

        System.out.println("Print all evens");

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // Տպել մասիվի բոլոր կենտ էլեմենտները:

    void odds(int[] array) {

        System.out.println("Print all odds");

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // Տպել մասիվի զույգ էլեմենտների քանակը:

    void evenCount(int[] array) {

        int evenCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println("Number of even elements: " + evenCount);
        System.out.println();
    }

    // Տպել մասիվի կենտ էլեմենտների քանակը:

    void oddCount(int[] array) {

        int oddCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddCount++;
            }
        }
        System.out.println("Number of odd elements: " + oddCount);
    }

    // Տպել մասիվի բոլոր էլեմենտների միջին թվաբանականը:

    double avg(int[] array) {

        double sum = 0;
        double avg = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
            avg = sum / array.length;
        }
        return avg;
    }

    // Տպել մասիվի էլեմենտների գումարը:

    void sum(int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            sum = sum + array[i];
        }
        System.out.println("sum: " + sum);
    }

}

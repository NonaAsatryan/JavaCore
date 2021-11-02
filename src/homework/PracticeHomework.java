package homework;

public class PracticeHomework {

    // Փոխակերպել տրված րոպեն վայրկյանի ու վերադարձնել:

    long convert (int minutes) {

        int seconds = minutes * 60;
        return seconds;
    }

    // Ընդունել տարին, վերադարձնել օրերի քանակը:

    int calcAge (int years) {

        int days = years * 365;
        return days;
    }

    // Վերադարձնել տրված թվի հաջորդ թիվը:

    int nextNumber(int number) {

         number += 1;
         return number;
    }

    // Վերադարձնել true, եթե տրված a և b թվերը իրար հավասար են,
    // եթե ոչ՝ false:

    boolean isSameNum(int a, int b) {
        if (a == b) {
            return true;
        } else
            return false;
    }

    //Վերադարձնել true, եթե թիվը փոքր կամ հավասար է 0-ի,
    //մնացած դեպքերում վերադարձնել false:

    boolean lessThanOrEqualToZero(int number) {
        if (number <= 0) {
            return true;
        } else
            return false;
    }

    // Վերադարձնել ընդունող boolean-ի ժխտված արժեքը:

    boolean reverseBool(boolean value) {
        return !value;
    }

    // Վերադարձնել երկու մասիվի ամենամեծ length-ը:

    int maxLength(int[] array1, int[] array2) {

        if (array1.length > array2.length) {
            return array1.length;
        } else
            return array2.length;
    }
}

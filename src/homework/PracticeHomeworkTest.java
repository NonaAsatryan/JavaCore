package homework;

public class PracticeHomeworkTest {

    public static void main(String[] args) {

        PracticeHomework practiceHomework = new PracticeHomework();

        // Փոխակերպել տրված րոպեն վայրկյանի ու վերադարձնել:

        long l = practiceHomework.convert(1);
        System.out.println("One minute is " + l + " seconds.");

        // Ընդունել տարին, վերադարձնել օրերի քանակը:

        int calcAge = practiceHomework.calcAge(1);
        System.out.println("One year has " + calcAge + " days.");

        // Վերադարձնել տրված թվի հաջորդ թիվը:

        int nextNumber = practiceHomework.nextNumber(8);
        System.out.println("The next number of 8 is " + nextNumber);

        // Վերադարձնել true, եթե տրված a և b թվերը իրար հավասար են,
        // եթե ոչ՝ false:

        boolean isSameNumber = practiceHomework.isSameNum(7, 7);
        System.out.println(isSameNumber);

        //Վերադարձնել true, եթե թիվը փոքր կամ հավասար է 0-ի,
        //մնացած դեպքերում վերադարձնել false:

        boolean lessThanOrEqualToZero = practiceHomework.lessThanOrEqualToZero(-5);
        System.out.println(lessThanOrEqualToZero);

        // Վերադարձնել ընդունող boolean-ի ժխտված արժեքը:

        boolean reverseBool = practiceHomework.reverseBool(true);
        System.out.println(reverseBool);

        // Վերադարձնել երկու մասիվի ամենամեծ length-ը:

        int[] array1 = {5, 76, 9, 48, 63, 1, 3, 8, 49, -7, 0, 2};
        int[] array2 = {55, 3, 8, 6, 7, 98, 654, 434, 86, 36, 60, 87, 55, 42,};
        int maxLength = practiceHomework.maxLength(array1, array2);
        System.out.println("The maximum length: " + maxLength);

    }
}

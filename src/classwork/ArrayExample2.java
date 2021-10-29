package classwork;

public class ArrayExample2 {

    public static void main(String[] args) {

        int[] array = {3, 6, 7, 9, 2, 6, 13, 4, 5, 3};

        // տպել, թե որ էլեմենտներն են կրկնվում


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                if (array[i] == array[j]) {
                    System.out.println(array[j] + "-ը կրկնվում է");
                    break;
                }
            }

        }

        System.out.println();

        // տպել true, եթե մասիվի բոլոր էլեմենտները զույգ են
        // եթե ոչ` false

        boolean result = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result = false;
                break;
            }
        }
        System.out.println(result);

    }
}

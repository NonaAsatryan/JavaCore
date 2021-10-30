package homework.arrayUtil1;

public class ArrayUtil1Demo {

    public static void main(String[] args) {

        ArrayUtil1 arrayUtil1 = new ArrayUtil1();

        int [] array = {4, 11, 8, 99, 85, 145, 27, 47, 55, 22};

        arrayUtil1.elements(array);

        arrayUtil1.max(array);

        arrayUtil1.min(array);

        arrayUtil1.evens(array);

        arrayUtil1.odds(array);

        arrayUtil1.evenCount(array);

        arrayUtil1.oddCount(array);

        arrayUtil1.avg(array);

        double avg = arrayUtil1.avg(array);
        System.out.println("avg: " + avg);

        arrayUtil1.sum(array);
    }
}

package homework.dynamicArray;

public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();

        System.out.println(da.isEmpty());

        for (int i = 0; i < 10; i++) {
            da.add(i + 1);
        }

        int byIndex = da.getByIndex(7);
        System.out.println(byIndex);

        System.out.println("Elements of the array: ");

        da.print();

        da.delete(5);

        da.add(5);

        System.out.println(da.isEmpty());

        int[] numbers = {33, 44, 55};

        da.add(numbers);

        da.print();

        da.add(66, 8);

        da.print();

        da.set(2,4);

        da.print();

        System.out.println(da.isExists(66));

    }
}

package homework.dynamicArray;

public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(5);
        da.add(76);
        da.add(44);
        da.add(82);
        da.add(2);
        da.add(7);
        da.add(4);
        da.add(6);
        da.add(654);
        da.add(76);
        da.add(8);
        da.add(9);

        int byIndex = da.getByIndex(7);
        System.out.println(byIndex);

        System.out.println("Elements of the array: ");

        da.print();
    }
}

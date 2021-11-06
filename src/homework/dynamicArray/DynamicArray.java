package homework.dynamicArray;

public class DynamicArray {

    // սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];

    // սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    // ստուգել, եթե մասիվի մեջ տեղ չկա, կանչել extend() մեթոդը և ավելացնել
    public void add(int value) {
        if (array.length == size) {
            extend();
        }
        array[size] = value;
        size++;
    }

    // ստեղծել հին մասիվից 10 էլեմենտով ավելի մեծ մասիվ,
    // քցել հին մասիվի էլեմենտները նորի մեջ
    // հին մասիվի հղումը կապել նոր մասիվի հղման հետ

    private void extend() {
        if (array.length == size) {
            int newArray[] = new int[size * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    // եթե տրված index-ը մեր ունեցած մասիվի index-ի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը, հակառակ դեպքում վերադարձնել -1

    public int getByIndex(int index) {
        if (index < size) {
            return array[index];
        } else
            return -1;
    }

    // տպել մասիվի ավելացված էլեմենտնեռը

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

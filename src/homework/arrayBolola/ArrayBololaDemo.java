package homework.arrayBolola;

public class ArrayBololaDemo {

    public static void main(String[] args) {

        char[] bolola = {'b', 'o', 'l', 'o', 'l', 'a'};

        char[] bolola1 = {'b', 'o', 'b', 'o', 'l', 'a'};

        char[] text = {' ', ' ', 'h', 'e', 'l', 'l', 'o', ' ', 'j', 'a', 'v', 'a', ' ', ' ', ' '};

        ArrayBolola arrayBolola = new ArrayBolola();

        arrayBolola.arrayBolola(bolola);

        arrayBolola.bolola(bolola);

        boolean b = arrayBolola.bolola1(bolola);
        System.out.println(b);

        boolean isBob = arrayBolola.bolola2(bolola1);
        System.out.println(isBob);

        char[] result = arrayBolola.trim(text);
         for (char c : result) {
             System.out.print(c);
         }
    }
}

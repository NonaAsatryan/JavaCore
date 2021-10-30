package homework.arrayBolola;

public class ArrayBolola {

    // Պետք է գրել լոգիկա, որը կհաշվի, թե քանի հատ կա
    // c փոփոխականից մեր մասիվի մեջ ու տպել այդ քանակը։

     void arrayBolola(char[] bolola) {

        int count = 0;
        char c = 'o';

        for (int i = 0; i < bolola.length; i++) {
            if (bolola[i] == c) {
                count++;
            }
        }
        System.out.println("count of '" + c + "' = " + count);

        System.out.println();
    }

    // Պետք է գրել կոդ, որը կտպի մեջտեղի 2 սիմվոլները։

    void bolola(char[] bolola) {

        System.out.print(bolola[bolola.length / 2 - 1] + "  ");
        System.out.println(bolola[bolola.length / 2]);

        System.out.println();
    }

    // Պետք է տպենք true, եթե մեր մասիվը վերջանում է ly-ով,
    // եթե ոչ՝ false:

    void bolola1(char[] bolola) {

        if (bolola[bolola.length - 2] == 'l' &&
                bolola[bolola.length - 1] == 'y') {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        System.out.println();
    }

    // Տպում ենք true, եթե տեքստը պարունակում է bob բառը, բայց o-ի տեղը
    // կարող է լինել ցանկացած սիմվոլ։
    // օր․ abcbob → true, b9b -> true, բայց ասենք bac-> false

    void bolola2(char[] bolola1) {

         boolean isBob = false;

        for (int i = 0; i < bolola1.length; i++) {

            if (bolola1[i] == 'b' && bolola1[i + 2] == 'b') {
                isBob = true;
            }
        }
        System.out.println(isBob);

        System.out.println();
    }

    // Տվյալ օրինակում կարող ենք կամայական քանակի պռաբելներ դնել թե սկզբից,
    // թե վերջից, չկենտրոնանաք, որ երկու հատ է դրված։ Պետք է գրել կոդ,
    // որը text մասիվից կստանա char[] result մասիվ, որը կլինի նույն տեքստը,
    // առանց պռաբելների (իրար կողք կտպի hello java)։

    void array(char[] text) {
        int startIndex = 0;
        int endIndex = text.length - 1;

        while (startIndex < endIndex && text[startIndex] == ' ') {
            startIndex++;

        }
        while (startIndex < endIndex && text[endIndex] == ' ') {
            endIndex--;
        }

        char[] result = new char[(endIndex - startIndex) + 1];

        int index = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            result[index++] = text[i];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

        }
    }

}

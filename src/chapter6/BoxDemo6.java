package chapter6;

public class BoxDemo6 {

    public static void main(String[] args) {

        Box mybox1 = new Box();
        Box mybox2 = new Box();

        double volume1;

        volume1 = mybox1.volume1();
        System.out.println("Volume is " + volume1);

        volume1 = mybox2.volume1();
        System.out.println("Volume is " + volume1);
    }
}

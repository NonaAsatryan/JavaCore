package chapter6;

public class BoxDemo7 {

    public static void main(String[] args) {

        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box(3, 6, 9);

        double volume1;

        volume1 = mybox1.volume1();
        System.out.println("Volume is " + volume1);

        volume1 = mybox2.volume1();
        System.out.println("Volume is " + volume1);
    }
}

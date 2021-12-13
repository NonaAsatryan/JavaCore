package chapter9;

public interface IntStack2 {
    void push (int item);
    int pop ();

    default void clear() {
        System.out.println("clear() not implemented.");
    }
}

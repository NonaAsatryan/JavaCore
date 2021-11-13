package chapter7;

public class Stack {

    /* Now, both stck and tos are private. This means that they
    cannot be accidentally or maliciously altered in a way that
    would be harmful to the stack.
     */
    private int stck[] = new int[10];
    private int tos;

    Stack() {
        tos = -1;
    }

    void push (int item) {
        if (tos == 9) {
            System.out.println("Stack is full.");
        } else
            stck[++tos] = item;
    }

    int pop () {
        if (tos < 0) {
            System.out.println("Stack underflow.");
            return 0;
        } else
            return stck[tos--];

    }

}

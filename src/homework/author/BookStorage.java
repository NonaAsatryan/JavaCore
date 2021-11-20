package homework.author;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size;

    public void add(Book book) {
        if (books.length == size) {
            extend();
        }
        books[size++] = book;
    }

    private void extend() {
        Book[] temp = new Book[books.length + 10];
        System.arraycopy(books, 0, temp, 0, books.length);
        books = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(books[i] + " ");
        }
        System.out.println();
    }

    public void searchByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            }
        }
    }
}

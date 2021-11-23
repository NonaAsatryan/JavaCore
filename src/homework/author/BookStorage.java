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
            System.out.print(books[i]);
        }
    }

    public void searchByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            }
        }
    }

    public void searchBooksByAuthor(String email) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().getEmail().equals(email)) {
                System.out.println(books[i]);
            }
        }
    }

    public void countBooksByAuthor(String email) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().getEmail().equals(email)){
                System.out.println(books[i].getCount());
            } else {
                System.out.println("There is no book yet");
            }
        }
    }
}

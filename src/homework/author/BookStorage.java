package homework.author;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size = 0;

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

    public Book getBySerialID(String serialID) {
        for (int i = 0; i < size; i++) {
            if (books[i].getSerialID().equals(serialID)) {
                return books[i];
            }
        }
        return null;
    }

    public void searchByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            }
        }
    }

    public void searchBooksByAuthor(Author author) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author)) {
                System.out.println(books[i]);
            }
        }
    }

    public void countBooksByAuthor(Author author) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author)) {
                count++;
            }
        }
        System.out.println("count of " + author.getEmail() + " author's book is " + count);
    }

    public void deleteByAuthor(Author author) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author)) {
                ArrayUtil.deleteByIndex(books, i, size);
            }
        }
    }

    public void delete(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].equals(book)) {
                ArrayUtil.deleteByIndex(books, i, size);
                break;
            }
        }
    }
}
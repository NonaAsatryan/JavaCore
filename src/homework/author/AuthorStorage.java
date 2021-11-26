package homework.author;

public class AuthorStorage {

    private Author[] authors = new Author[10];
    private int size;

    public Author add(Author author) {
        if (authors.length == size) {
            extend();
        }
        authors[size++] = author;
        return null;
    }

    private void extend() {
            Author[] temp = new Author[authors.length + 10];
            System.arraycopy(authors, 0, temp, 0, authors.length);
            authors = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(authors[i]);
        }
    }

    public void searchByName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getName().contains(keyword) ||
            authors[i].getSurname().contains(keyword)) {
                System.out.println(authors[i]);
            }
        }
    }

    public void searchByAge(int minAge, int maxAge) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getAge() >= minAge &&
                    authors[i].getAge() <= maxAge) {
                System.out.println(authors[i]);
            }
        }
    }

    public Author getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getEmail().equals(email)) {
                return  authors[i];
            }
        }
        return null;
    }

    public void deleteAuthor(String email) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (authors[i].getEmail().equals(email)) {
                System.out.println(authors[i]);
            }
        }
        for (int i = index + 1; i < size ; i++) {
            authors [i - 1] = authors[i];
            System.out.println(authors[i]);
        }
        size --;
    }
}

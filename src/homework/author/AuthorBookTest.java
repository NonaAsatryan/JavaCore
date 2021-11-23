package homework.author;

import java.util.Scanner;

public class AuthorBookTest {

    static Scanner scanner = new Scanner(System.in);
    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();

    private static final String EXIT = "0";
    private static final String ADD_AUTHOR = "1";
    private static final String SEARCH_AUTHORS = "2";
    private static final String SEARCH_AUTHORS_BY_AGE = "3";
    private static final String PRINT_AUTHORS = "4";
    private static final String ADD_BOOK = "5";
    private static final String SEARCH_BOOKS_BY_TITLE = "6";
    private static final String PRINT_BOOKS = "7";
    private static final String SEARCH_BOOKS_BY_AUTHOR = "8";
    private static final String COUNT_BOOKS_BY_AUTHOR = "9";
    private static final String CHANGE_AUTHOR = "10";
    private static final String CHANGE_BOOK_AUTHOR = "11";

    public static void main(String[] args) {

        authorStorage.add(new Author("poxos", "poxosyan", "poxos@mail.ru", 22, "male"));
        authorStorage.add(new Author("poxosuhi", "poxosyan", "poxosuhi@mail.ru", 23, "female"));
        authorStorage.add(new Author("petros", "petrosyan", "petros@mail.ru", 25, "male"));

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case SEARCH_AUTHORS:
                    searchByName();
                    break;
                case SEARCH_AUTHORS_BY_AGE:
                    searchByAge();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.print();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case SEARCH_BOOKS_BY_TITLE:
                    searchByTitle();
                    break;
                case PRINT_BOOKS:
                    bookStorage.print();
                    break;
                case SEARCH_BOOKS_BY_AUTHOR:
                    searchBooksByAuthor();
                    break;
                case COUNT_BOOKS_BY_AUTHOR:
                    countBooksByAuthor();
                    break;
                case CHANGE_AUTHOR:
                    changeAuthor();
                    break;
                case CHANGE_BOOK_AUTHOR:
                    changeBookAuthor();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void changeBookAuthor() {
        System.out.println("Please, input book's title");
        String title = scanner.nextLine();
        bookStorage.searchByTitle(title);
        System.out.println("Please, input author's email");
        String email = scanner.nextLine();
        authorStorage.getByEmail(email);

    }

    private static void changeAuthor() {
        System.out.println("Please, input author's email");
        String email = scanner.nextLine();
        if (authorStorage.getByEmail(email).getEmail().equals(email)) {
            System.out.println(authorStorage.getByEmail(email));
            System.out.println("please input author's name");
            String name = scanner.nextLine();
            authorStorage.changeName(name);
            System.out.println("please input author's surname");
            String surname = scanner.nextLine();
            authorStorage.changeSurname(surname);
            System.out.println("please input author's gender");
            String gender = scanner.nextLine();
            authorStorage.changeGender(gender);
            System.out.println("please input author's age");
            int age = Integer.parseInt(scanner.nextLine());
            authorStorage.changeAge(age);
            Author author = new Author(name,surname,email,age,gender);
            System.out.println(authorStorage.getByEmail(email));
        }
    }

    private static void countBooksByAuthor() {
        System.out.println("Please, input author's email");
        String email = scanner.nextLine();
        bookStorage.countBooksByAuthor(email);
    }

    private static void searchBooksByAuthor() {
        System.out.println("Please, input author's email");
        String email = scanner.nextLine();
        bookStorage.searchBooksByAuthor(email);
    }

    private static void searchByTitle() {
        System.out.println("Please, input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchByTitle(keyword);
    }

    private static void addBook() {
        System.out.println("Please, choose author's email");
        System.out.println("---------");
        authorStorage.print();
        System.out.println("---------");
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            System.out.println("please input book's title");
            String title = scanner.nextLine();
            System.out.println("please input book's description");
            String description = scanner.nextLine();
            System.out.println("please input book's price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("please input book's count");
            int count = Integer.parseInt(scanner.nextLine());

            Book book = new Book(title, description, price, count, author);
            bookStorage.add(book);
            System.out.println("Thank you, book was added");
        } else {
            System.out.println("Invalid email! Please, try again");
            addBook();
        }
    }

    private static void searchByAge() {
        System.out.println("Please, input minimum age");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Please, input maximum age");
        int maxAge = Integer.parseInt(scanner.nextLine());
        authorStorage.searchByAge(minAge, maxAge);
    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_AUTHOR + " for adding author");
        System.out.println("Please input " + SEARCH_AUTHORS + " for searching author by name");
        System.out.println("Please input " + SEARCH_AUTHORS_BY_AGE + " for searching author by age");
        System.out.println("Please input " + PRINT_AUTHORS + " for printing authors");
        System.out.println("Please input " + ADD_BOOK + " for adding books");
        System.out.println("Please input " + SEARCH_BOOKS_BY_TITLE + " for searching books by title");
        System.out.println("Please input " + PRINT_BOOKS + " for printing books");
        System.out.println("Please input " + SEARCH_BOOKS_BY_AUTHOR + " for searching books by author");
        System.out.println("Please input " + COUNT_BOOKS_BY_AUTHOR + " for counting books by author");
        System.out.println("Please input " + CHANGE_AUTHOR + " for changing author");
        System.out.println("Please input " + CHANGE_BOOK_AUTHOR + " for changing author");
    }

    private static void searchByName() {
        System.out.println("Please, input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchByName(keyword);
    }

    private static void addAuthor() {
            System.out.println("please input author's name");
            String name = scanner.nextLine();
            System.out.println("please input author's surname");
            String surname = scanner.nextLine();
            System.out.println("please input author's email");
            String email = scanner.nextLine();
            System.out.println("please input author's gender");
            String gender = scanner.nextLine();
            System.out.println("please input author's age");
            int age = Integer.parseInt(scanner.nextLine());

            Author author = new Author(name,surname,email,age,gender);
            if (authorStorage.getByEmail(author.getEmail()) != null) {
                System.err.println("Invalid email! Author with this email already exists.");
            } else {
                authorStorage.add(author);
                System.out.println("Thank you, author was added");
            }
    }
}

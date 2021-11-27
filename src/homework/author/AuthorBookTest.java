package homework.author;

import chapter8.A;

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
    private static final String DELETE_AUTHOR = "12";
    private static final String DELETE_BY_AUTHOR = "13";
    private static final String DELETE_BOOK = "14";

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
                case DELETE_AUTHOR:
                    deleteAuthor();
                    break;
                case DELETE_BY_AUTHOR:
                    deleteByAuthor();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void deleteBook() {
        System.out.println("Please, choose author's email");
        System.out.println("---------");
        bookStorage.print();
        System.out.println("---------");
        String serialID = scanner.nextLine();
        Book book = bookStorage.getBySerialID(serialID);
        if (book != null) {
            bookStorage.delete(book);
        } else {
            System.err.println("Book with serialID does not exist");
        }
    }

    private static void deleteByAuthor() {
        printAuthorList();
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            bookStorage.deleteByAuthor(author);
        } else {
            System.err.println("Book with serialID does not exist");
        }
    }

    private static void deleteAuthor() {
        printAuthorList();
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            authorStorage.delete(author);
        } else {
            System.err.println("Author does not exist");
        }
    }

    private static void printAuthorList() {
        System.out.println("Please, choose author's email");
        System.out.println("---------");
        authorStorage.print();
        System.out.println("---------");
    }

    private static void changeBookAuthor() {
        System.out.println("Please, choose book be serial ID");
        System.out.println("---------");
        bookStorage.print();
        System.out.println("---------");
        String serialID = scanner.nextLine();
        Book book = bookStorage.getBySerialID(serialID);
        if (book != null) {

            printAuthorList();
            String email = scanner.nextLine();
            Author author = authorStorage.getByEmail(email);
            if (author != null) {
                book.setAuthor(author);
            } else {
                System.err.println("Author does not exist");
            }
        } else {
            System.err.println("Book with serial ID does not exist");
        }
    }

    private static void changeAuthor() {
        printAuthorList();
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            System.out.println(author);
            System.out.println("Please, input author's name");
            String name = scanner.nextLine();
            author.setName(name);
            System.out.println("Please, input author's surname");
            String surname = scanner.nextLine();
            author.setSurname(surname);
            System.out.println("Please, input author's gender");
            String gender = scanner.nextLine();
            author.setGender(gender);
            System.out.println("Please input author's age");
            int age = Integer.parseInt(scanner.nextLine());
            author.setAge(age);
        } else {
            System.out.println("Author doesn't exist");
        }
    }

    private static void countBooksByAuthor() {
        printAuthorList();
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            bookStorage.countBooksByAuthor(author);
        } else {
            System.err.println("Author does not exist");
        }
    }

    private static void searchBooksByAuthor() {
        printAuthorList();
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            bookStorage.searchBooksByAuthor(author);
        } else {
            System.err.println("Author does not exist");
        }
    }

    private static void searchByTitle() {
        System.out.println("Please, input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchByTitle(keyword);
    }

    private static void addBook() {
        printAuthorList();
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            System.out.println("please input book's serialID");
            String serialID = scanner.nextLine();
            if (bookStorage.getBySerialID(serialID) == null) {
                System.out.println("Please, input book's title");
                String title = scanner.nextLine();
                System.out.println("please input book's description");
                String description = scanner.nextLine();
                System.out.println("please input book's price");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("please input book's count");
                int count = Integer.parseInt(scanner.nextLine());
                Book book = new Book(serialID, title, description, price, count, author);

                bookStorage.add(book);
                System.out.println("Thank you, book was added");
            } else {
                System.err.println("Book with SerialID: " + serialID + " exists");
            }
        } else {
            System.err.println("Invalid email! Please, try again");
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
        System.out.println("Please input " + DELETE_AUTHOR + " for deleting author");
        System.out.println("Please input " + DELETE_BY_AUTHOR + " for deleting by author");
        System.out.println("Please input " + DELETE_BOOK + " for deleting book");
    }

    private static void searchByName() {
        System.out.println("Please, input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchByName(keyword);
    }

    private static void addAuthor() {
            System.out.println("please input author's name,surname,email,gender,age");
            String authorDataStr = scanner.nextLine();
            String[] authorData = authorDataStr.split(",");
            if (authorData.length == 5) {
                int age = Integer.parseInt(scanner.nextLine());
                Author author = new Author(authorData[0], authorData[1], authorData[2], age, authorData[3]);
                if (authorStorage.getByEmail(author.getEmail()) != null) {
                    System.err.println("Invalid email. Author with this email already exists.");
                } else {
                    authorStorage.add(author);
                    System.out.println("Thank you, author was added.");
                }
            } else {
                System.err.println("invalid data");
            }
    }
}

package homework.author;

import homework.author.model.Author;
import homework.author.model.Book;
import homework.author.storage.AuthorStorage;
import homework.author.storage.BookStorage;
import homework.author.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class AuthorBookTest implements AuthorBookCommands {

    static Scanner scanner = new Scanner(System.in);
    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) throws ParseException {

        authorStorage.add(new Author("poxos", "poxosyan", "poxos@mail.ru", 22,
                                     "male", DateUtil.stringToDate("12/0d/1995")));
        authorStorage.add(new Author("poxosuhi", "poxosyan", "poxosuhi@mail.ru", 23,
                                     "female", DateUtil.stringToDate("12/o5/1997")));
        authorStorage.add(new Author("petros", "petrosyan", "petros@mail.ru", 25,
                                     "male", DateUtil.stringToDate("12/05/1999")));

        boolean isRun = true;
        while (isRun) {
            AuthorBookCommands.printCommands();
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

    private static void searchByName() {
        System.out.println("Please, input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchByName(keyword);
    }

    private static void addAuthor() throws ParseException {
            System.out.println("please input author's name,surname,email,gender,age,dateOfBirth[12/12/2021");
            String authorDataStr = scanner.nextLine();
            String[] authorData = authorDataStr.split(",");
            if (authorData.length == 6) {
                int age = Integer.parseInt(authorData[4]);
                Date date = DateUtil.stringToDate(authorData[5]);
                Author author = new Author(authorData[0], authorData[1], authorData[2], age, authorData[3], date);
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

package homework.author;

import homework.author.exception.BookNotFoundException;
import homework.author.model.Author;
import homework.author.model.Book;
import homework.author.model.User;
import homework.author.storage.AuthorStorage;
import homework.author.storage.BookStorage;
import homework.author.storage.UserStorage;
import homework.author.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


public class AuthorBookTest implements AuthorBookCommands {

    static Scanner scanner = new Scanner(System.in);
    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();
    static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) {
        initData();
        boolean isRun = true;

        while (isRun) {
            AuthorBookCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOG_IN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void login() {
        System.out.println("Please, input email");
        String email = scanner.nextLine();
        User byEmail = userStorage.getByEmail(email);
        if (byEmail != null) {
            System.out.println("Please, input password");
            String password = scanner.nextLine();
            if (byEmail.getPassword().equals(password)) {
                if (byEmail.getType().equalsIgnoreCase("ADMIN")) {
                    adminLogin();
                } else if (byEmail.getType().equalsIgnoreCase("USER")) {
                    userLogin();
                }
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.err.println("User with " + email + "doesn't exist");
        }
    }

    private static void userLogin() {
    boolean isRun = true;
        while (isRun) {
            AuthorBookCommands.printUserCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    System.exit(0);
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
                case LOG_OUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void register() {
        System.out.println("Please, input email");
        String email = scanner.nextLine();
        User byEmail = userStorage.getByEmail(email);
        if (byEmail == null) {
            System.out.println("Please, input name");
            String name = scanner.nextLine();

            System.out.println("Please, input surname");
            String surname = scanner.nextLine();

            System.out.println("Please, input password");
            String password = scanner.nextLine();

            System.out.println("Please, input type(ADMIN, USER)");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("admin") || type.equalsIgnoreCase("user")) {
                User user = new User();
                user.setEmail(email);
                user.setName(name);
                user.setSurname(surname);
                user.setPassword(password);
                user.setType(type.toUpperCase());
                userStorage.add(user);
                System.out.println("User was registered!");
            } else {
                System.out.println("Invalid type!");
            }
        } else {
            System.out.println("user with " + email + " already exists");
        }
    }

    private static void adminLogin () {
        boolean isRun = true;
        while (isRun) {
            AuthorBookCommands.printAdminCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    System.exit(0);
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
                case ADD_TAGS_TO_BOOK:
                    addTagsToBook();
                    break;
                case REMOVE_TAGS_FROM_BOOK:
                    removeTagsFromBook();
                    break;
                case LOG_OUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }
    private static void removeTagsFromBook() {
        System.out.println("Please, choose book by serialID");
        System.out.println("----------");
        bookStorage.print();
        System.out.println("----------");
        String serialID = scanner.nextLine();
        Book book = null;
        try {
            book = bookStorage.getBySerialID(serialID);
            System.out.println("Please, input tags separating with ,");
            String tagsStr = scanner.nextLine();
            String[] tagsToRemove = tagsStr.split(",");
            String[] bookTags = book.getTags();
            if (bookTags == null) {
                System.err.println("Book doesn't have any tags to remove!");
            } else {
                for (String tag : tagsToRemove) {
                    boolean isExist = false;
                    for (String bookTag : bookTags) {
                        if (bookTag.equals(tag)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        System.err.println(tag + " doesn't exist on book: " + book);
                        return;
                    }
                }
                String[] newTags = new String[bookTags.length-tagsToRemove.length];
                int index = 0;
                for (String bookTag : bookTags) {
                    boolean isExist = false;
                    for (String toRemove : tagsToRemove) {
                        if (bookTag.equals(toRemove)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        newTags[index++] = bookTag;
                    }
                }
                book.setTags(newTags);
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addTagsToBook() {
        System.out.println("Please, choose book by serialID");
        System.out.println("----------");
        bookStorage.print();
        System.out.println("----------");
        String serialID = scanner.nextLine();
        Book book = null;
        try {
            book = bookStorage.getBySerialID(serialID);
            System.out.println("Please, input tags separating with ,");
            String tagsStr = scanner.nextLine();
            String[] tags = tagsStr.split(",");
            String[] bookTags = book.getTags();
            if (bookTags == null) {
                System.out.println("Tags were added!");
            } else {
                for (String tag : tags) {
                    for (String bookTag : bookTags) {
                        if (tag.equals(bookTag)) {
                            System.err.println(tag + " is duplicate. Please, input new tags.");
                            return;
                        }
                    }
                }
                String[] newTags = new String[bookTags.length - tags.length];
                System.arraycopy(bookTags, 0, newTags, 0, bookTags.length);
                System.arraycopy(tags, 0, newTags, bookTags.length, tags.length);
                book.setTags(newTags);
                System.out.println("Tags were added!");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initData() {
        try {
            Author author = new Author("poxos", "poxosyan", "poxos@mail.ru", 22, "male", DateUtil.stringToDate("12/05/1999"));
            Author author1 = new Author("poxosuhi", "poxosyan", "poxosuhi@mail.ru", 25, "female", DateUtil.stringToDate("12/05/1989"));
            Author author2 = new Author("petros", "petrosyan", "petros@mail.ru", 28, "male", DateUtil.stringToDate("12/05/1990"));
            authorStorage.add(author);
            authorStorage.add(author1);
            authorStorage.add(author2);
            Author[] authors = {author1, author2};
            String[] tags = {"new", "popular", "detektiv"};
            bookStorage.add(new Book("AR5555", "girq1", "desc", 33, 1, authors, tags));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void deleteBook() {
        System.out.println("Please, choose author's email");
        System.out.println("---------");
        bookStorage.print();
        System.out.println("---------");
        String serialID = scanner.nextLine();
        Book book = null;
        try {
            book = bookStorage.getBySerialID(serialID);
            bookStorage.delete(book);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
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
        Book book = null;
        try {
            book = bookStorage.getBySerialID(serialID);
            printAuthorList();
            String emails = scanner.nextLine();
            String[] emailArray = emails.split(",");
            if (emailArray.length == 0) {
                System.err.println("Please, choose authors");
                return;
            }
            Author[] authors = new Author[emailArray.length];
            int index = 0;
            for (String email : emailArray) {
                Author author = authorStorage.getByEmail(email);
                if (author != null) {
                    authors[index++] = author;
                } else {
                    System.err.println("Please, input correct email!");
                    return;
                }
            }
            book.setAuthors(authors);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
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
        String emails = scanner.nextLine();
        String[] emailArray = emails.split(",");
        if (emailArray.length == 0) {
            System.err.println("Please, choose authors");
            return;
        }
        Author[] authors = new Author[emailArray.length];
        int index = 0;
        for (String email : emailArray) {
            Author author = authorStorage.getByEmail(email);
            if (author != null) {
                authors[index++] = author;
            } else {
                System.err.println("Please, input correct email");
                return;
            }
        }
        System.out.println("Please input book's serialID");
        String serialID = scanner.nextLine();

        try {
            bookStorage.getBySerialID(serialID);
            System.out.println("Book is duplicate");
        } catch (BookNotFoundException e) {
            System.out.println("Please, input book's title");
            String title = scanner.nextLine();
            System.out.println("please input book's description");
            String description = scanner.nextLine();
            System.out.println("please input book's price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("please input book's count");
            int count = Integer.parseInt(scanner.nextLine());
            System.out.println("Please, input book's tags separating by ,");
            String tagsStr = scanner.nextLine();
            String[] tags = tagsStr.split(",");

            Book book = new Book(serialID, title, description, price, count, authors, tags);

            bookStorage.add(book);
            System.out.println("Thank you, book was added");
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

    private static void addAuthor() {
            System.out.println("please input author's name,surname,email,gender,age,dateOfBirth[12/12/2021");
            String authorDataStr = scanner.nextLine();
            String[] authorData = authorDataStr.split(",");
            if (authorData.length == 6) {
                int age = Integer.parseInt(authorData[4]);
                Date date;
                try {
                    date = DateUtil.stringToDate(authorData[5]);
                } catch (ParseException e) {
                    System.out.println("Invalid date format");
                    return;
                }
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

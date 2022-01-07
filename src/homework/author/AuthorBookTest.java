package homework.author;

import homework.author.exception.BookNotFoundException;
import homework.author.model.*;
import homework.author.storage.AuthorStorage;
import homework.author.storage.BookStorage;
import homework.author.storage.UserStorage;
import homework.author.util.DateUtil;

import java.text.ParseException;
import java.util.*;


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
                if (byEmail.getType() == UserType.ADMIN) {
                    adminLogin();
                } else if (byEmail.getType() == UserType.USER) {
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
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
            user.setType(UserType.valueOf(type.toUpperCase()));
            userStorage.add(user);
            System.out.println("User was registered!");
        } else {
            System.err.println("user with " + email + " already exists");
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
        Book book;
        try {
            book = bookStorage.getBySerialID(serialID);
            System.out.println("Please, input tags separating with ,");
            String tagsStr = scanner.nextLine();
            String[] tagsToRemove = tagsStr.split(",");
            Set<String> bookTags = book.getTags();
            if (bookTags == null) {
                System.err.println("Book doesn't have any tags to remove!");
            } else {
                bookTags.removeAll(Arrays.asList(tagsToRemove));
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
        Book book;
        try {
            book = bookStorage.getBySerialID(serialID);
            System.out.println("Please, input tags separating with ,");
            String tagsStr = scanner.nextLine();
            String[] tags = tagsStr.split(",");
            Set<String> bookTags = book.getTags();
            if (bookTags == null) {
                book.setTags(new HashSet<>(Arrays.asList(tags)));
                System.out.println("Tags were added!");
            } else {
                bookTags.addAll(Arrays.asList(tags));
                System.out.println("Tags were added!");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initData() {
        authorStorage.initData();
        bookStorage.initData();
        userStorage.initData();
    }

    private static void deleteBook() {
        System.out.println("Please, choose author's email");
        System.out.println("---------");
        bookStorage.print();
        System.out.println("---------");
        String serialID = scanner.nextLine();
        Book book;
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
            System.err.println("Author does not exist");
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
        System.out.println("Please, choose book by serial ID");
        System.out.println("---------");
        bookStorage.print();
        System.out.println("---------");
        String serialID = scanner.nextLine();
        Book book;
        try {
            book = bookStorage.getBySerialID(serialID);
            printAuthorList();
            String emails = scanner.nextLine();
            String[] emailArray = emails.split(",");
            if (emailArray.length == 0) {
                System.err.println("Please, choose authors");
                return;
            }
            Set<Author> authors = new HashSet<>();
            for (String email : emailArray) {
                Author author = authorStorage.getByEmail(email);
                if (author != null) {
                    authors.add(author);
                } else {
                    System.err.println("Please, input correct email!");
                    return;
                }
            }
            book.setAuthors(authors);
            bookStorage.serialize();
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
            System.out.println("Please, input author's surname");
            String surname = scanner.nextLine();
            System.out.println("Please, input author's gender");
            try {
                Gender gender = Gender.valueOf(scanner.nextLine());
                System.out.println("Please, input author's age");
                int age = Integer.parseInt(scanner.nextLine());
                author.setName(name);
                author.setSurname(surname);
                author.setGender(gender);
                author.setAge(age);
                authorStorage.serialize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.err.println("Author doesn't exist");
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
        Set<Author> authors = new HashSet<>();
        for (String email : emailArray) {
            Author author = authorStorage.getByEmail(email);
            if (author != null) {
                authors.add(author);
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

            Book book = new Book(serialID, title, description, price, count, authors, new HashSet<>(Arrays.asList(tags)));

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
                Author author = new Author(authorData[0], authorData[1], authorData[2], age, Gender.valueOf(authorData[3]), date);
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

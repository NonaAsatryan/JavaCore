package homework.education;


import java.util.Scanner;

public class StudentLessonTest {

    static Scanner scanner = new Scanner(System.in);
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();

    private static final String EXIT = "0";
    private static final String ADD_LESSON = "1";
    private static final String PRINT_LESSONS = "2";
    private static final String ADD_STUDENT = "3";
    private static final String PRINT_STUDENTS = "4";
    private static final String PRINT_STUDENTS_BY_LESSON = "5";
    private static final String DELETE_LESSON_BY_NAME = "6";
    private static final String DELETE_STUDENT_BY_EMAIL = "7";

    public static void main(String[] args) {

        studentStorage.add(new Student("poxos", "poxosyan", 22, "poxos@mail.ru", "098767676", "java"));
        studentStorage.add(new Student("petros", "petrosyan", 25, "petros@mail.ru", "098766976", "javaScript"));

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printByLesson();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteByEmail();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void deleteByEmail() {
        System.out.println("Please, choose student's email");
        studentStorage.print();
        System.out.println("---------");
        String email = scanner.nextLine();
        Student student = studentStorage.getByEmail(email);
        if (student != null) {
            studentStorage.delete(student);
            studentStorage.print();
        } else {
            System.err.println("Student with this email doesn't exist.");
        }

    }

    private static void deleteByName() {
        System.out.println("Please, input lesson's name");
        lessonStorage.print();
        System.out.println("---------");
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);
        if (lesson != null) {
            lessonStorage.deleteByName(lesson);
            lessonStorage.print();
        } else {
            System.err.println("Lesson with this name doesn't exist.");
        }
    }

    private static void printByLesson() {
        System.out.println("Please, input lesson's name");
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);
        if (lesson != null) {
            studentStorage.printByLesson(name);
        } else {
            System.err.println("Student does not exist");
        }
    }

    private static void addStudent() {
        System.out.println("Please input student's name,surname,age,email,phone,lesson");
        String studentDataStr = scanner.nextLine();
        String[] studentData = studentDataStr.split(",");
        if (studentData.length == 6) {
            int age = Integer.parseInt(scanner.nextLine());
            Student student = new Student(studentData[0], studentData[1], age, studentData[2],
                                                               studentData[3], studentData[4]);
            if (studentStorage.getByEmail(student.getEmail()) != null) {
                System.err.println("Invalid email. Student with this email already exists.");
            } else {
                studentStorage.add(student);
                System.out.println("Thank you, student was added.");
            }
        } else {
            System.err.println("invalid data");
        }
    }

    private static void addLesson() {
        System.out.println("Please, choose student's email");
        String email = scanner.nextLine();
        Student student = studentStorage.getByEmail(email);
        if (student != null) {
            System.out.println("Please, input lesson's name");
            String name = scanner.nextLine();
            if (lessonStorage.getByName(name) == null) {
                System.out.println("Please, input lesson's duration");
                String duration = scanner.nextLine();
                System.out.println("Please, input lesson's lecturer name");
                String lecturerName = scanner.nextLine();
                System.out.println("Please, input lesson's price");
                double price = Double.parseDouble(scanner.nextLine());
                Lesson lesson = new Lesson(name, duration, lecturerName, price, student);
                lessonStorage.add(lesson);
                System.out.println("Thank you, lesson was added");
            } else {
                System.err.println("Lesson with this name  already exists");
            }
        } else {
            System.err.println("Invalid name! Please, try again");
            addLesson();
        }
    }
    private static void printCommands () {
            System.out.println("Please input " + EXIT + " for EXIT");
            System.out.println("Please input " + ADD_LESSON + " for adding lesson");
            System.out.println("Please input " + PRINT_LESSONS + " for printing lessons");
            System.out.println("Please input " + ADD_STUDENT + " for adding student");
            System.out.println("Please input " + PRINT_STUDENTS + " for printing students");
            System.out.println("Please input " + PRINT_STUDENTS_BY_LESSON + " for printing students by lesson");
            System.out.println("Please input " + DELETE_LESSON_BY_NAME + " for deleting lesson my name");
            System.out.println("Please input " + DELETE_STUDENT_BY_EMAIL + " for deleting student by email");
        }
    }
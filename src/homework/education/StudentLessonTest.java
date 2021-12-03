package homework.education;


import homework.education.model.Lesson;
import homework.education.model.Student;
import homework.education.storage.LessonStorage;
import homework.education.storage.StudentStorage;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class StudentLessonTest implements StudentLessonCommands {

    static Scanner scanner = new Scanner(System.in);
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();

    public static void main(String[] args) throws ParseException {

        boolean isRun = true;
        while (isRun) {
            StudentLessonCommands.printCommands();
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
        String lessonName = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(lessonName);
        if (lesson != null) {
            studentStorage.printByLesson(lesson);
        } else {
            System.err.println("Student does not exist");
        }
    }

    private static void addStudent() throws ParseException {
        System.out.println("Please input student's name,surname,age,email,phone,lesson,date of birth");
        String studentDataStr = scanner.nextLine();
        String[] studentData = studentDataStr.split(",");
        String lessonNameStr = scanner.nextLine();
        String[] lessonName = lessonNameStr.split(",");
        Lesson[] lessons = new Lesson[lessonName.length];
        if (studentData.length == 7) {
            int age = Integer.parseInt(studentData[3]);
            Date date = DateUtil.stringToDate(studentData[6]);
            Student student = new Student(studentData[0], studentData[1], age, studentData[2],
                    studentData[3], lessons, date);
            lessonStorage.print();
            System.out.println("Please, choose lesson's name");
            for (int i = 0; i < lessonName.length; i++) {
                if (lessonStorage.getByName(lessonName[i]) != null) {
                    lessons[i] = lessonStorage.getByName(lessonName[i]);
                } else {
                    System.out.println("Unknown lesson");
                }
            }
            Student newStudent = new Student(studentData[0], studentData[1], age, studentData[2],
                    studentData[3], lessons, date);
        } else {
            System.err.println("Invalid email. Student with this email already exists.");
            addStudent();
        }
    }

        private static void addLesson() {
            System.out.println("Please, choose student's email.");
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
                    System.err.println("Lesson with this email already exists");
                }
            } else {
                System.err.println("Invalid name! Please, try again");
                addLesson();
            }

        }
}
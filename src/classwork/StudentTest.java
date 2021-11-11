package classwork;

public class StudentTest {

    public static void main(String[] args) {

        Student student = new Student("Poxos", "Poxosyan", 23,
                           "098778777", "Java");

        System.out.println(student.getName());
        student.setName("Poxosik");
        System.out.println(student.getName());
        System.out.println(student.getSurname());
        System.out.println(student.getAge());
        System.out.println(student.getPhoneNumber());
        System.out.println(student.getLessonName());
    }
}

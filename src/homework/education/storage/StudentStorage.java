package homework.education.storage;

import homework.education.model.Lesson;
import homework.education.model.Student;

public class StudentStorage {

    private Student[] students = new Student[10];
    private int size;

    public void add(Student student) {
        if (students.length == size) {
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] temp = new Student[students.length + 10];
        System.arraycopy(students, 0, temp, 0, students.length);
        students = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(students[i]);
        }
    }

    public Student getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                return students[i];
            }
        }
        return null;
    }

    public void printByLesson(Lesson lesson) {
        for (int i = 0; i < size; i++) {
            for (Lesson lesson1 :students[i].getLesson() ) {
                if (lesson.equals(lesson1)) {
                    System.out.println(students[i]);
                }
            }
        }
    }

    public void delete(Student student) {
        for (int i = 0; i < size; i++) {
            if (students[i].equals(student)) {
                deleteByIndex(i);
                break;
            }
        }
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            students[i - 1] = students[i];
        }
        size--;
    }
}

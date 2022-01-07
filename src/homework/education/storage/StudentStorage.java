package homework.education.storage;

import homework.education.model.Lesson;
import homework.education.model.Student;
import homework.education.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {

    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
        serialize();
    }

    public void print() {
        for (Student student : students) {
            System.out.print(student);
        }
    }

    public Student getByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    public void printByLesson(Lesson lesson) {
        for (Student student : students) {
                if (lesson.getStudent().equals(lesson)) {
                    System.out.println(student);
                }
        }
    }

    public void delete(Student student) {
        students.remove(student);
        serialize();
    }

    public void initData() {
        List<Student> studentList = FileUtil.deserializeStudents();
        if (studentList != null) {
            students = studentList;
        }
    }

    public void serialize() {
        FileUtil.serializeStudents(students);
    }
}

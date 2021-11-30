package homework.education;


public class LessonStorage {

    private Lesson[] lessons = new Lesson[10];
    private int size = 0;

    public void add(Lesson lesson) {
        if (lessons.length == size) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] temp = new Lesson[lessons.length + 10];
        System.arraycopy(lessons, 0, temp, 0, lessons.length);
        lessons = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(lessons[i]);
        }
    }

    public Lesson getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(name)) {
                return lessons[i];
            }
        }
        return null;
    }

    public void deleteByName(Lesson lesson) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].equals(lesson)) {
                deleteByIndex(i);
                break;
            }
        }
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            lessons[i - 1] = lessons[i];
        }
        size--;
    }
}

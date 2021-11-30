package homework.education;


public class Lesson {

    private String name;
    private String duration;
    private String lecturerName;
    private double price;
    private Student student;

    public Lesson(String name, String duration, String lecturerName, double price, Student student) {
        this.name = name;
        this.duration = duration;
        this.lecturerName = lecturerName;
        this.price = price;
        this.student = student;
    }

    public Lesson() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (Double.compare(lesson.price, price) != 0) return false;
        if (name != null ? !name.equals(lesson.name) : lesson.name != null) return false;
        if (duration != null ? !duration.equals(lesson.duration) : lesson.duration != null) return false;
        if (lecturerName != null ? !lecturerName.equals(lesson.lecturerName) : lesson.lecturerName != null)
            return false;
        return student != null ? student.equals(lesson.student) : lesson.student == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", price=" + price +
                ", student=" + student +
                '}';
    }
}

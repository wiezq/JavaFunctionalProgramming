package module42_SortingDataWIthFunctions;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.reverseOrder;


public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public static void main(String[] args) {
        List<Student> students = new java.util.ArrayList<>(List.of(
                new Student("Antonio", 85),
                new Student("Vladimir", 94),
                new Student("Elizabet", 97),
                new Student("Victoria", 100),
                new Student("Francis", 85),
                new Student("John", 100),
                new Student("Mary", 82)
        ));

        students.sort(Comparator
                .comparing(Student::getGrade, Comparator.reverseOrder())
                .thenComparing(Student::getName));

        System.out.println(students);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", grade=" + grade +
               '}';
    }
}

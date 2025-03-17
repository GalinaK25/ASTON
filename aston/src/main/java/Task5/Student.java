package Task5;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private final int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public static void removeStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);//replaced by IDEA
    }

    public static void moveStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.course++;
            }
        }
    }

    public double getAverageGrade() {
        if (grades == null || grades.length == 0) {//may be NullPointerException
            System.out.println("Grades can't be empty");
            return 0;
        }

        double total = 0;
        for (int grade : grades) {
            total = total + grade;
        }
        return total / grades.length;
    }

    public static void printStudents(Set<Student> students, int course) {
        if(course < 1 || course > 5 ){
            System.out.println("Invalid value for course");
            return;
        }
        System.out.println("Students of " + course + " course:");
        boolean hasStudents = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                hasStudents = true;
            }
        }
        if (!hasStudents) {
            System.out.println("---- no students ----");
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("AAAA", "472305", 2, new int[]{2, 2, 2, 2}));
        students.add(new Student("BBBB", "472305", 2, new int[]{3, 3, 3, 3}));
        students.add(new Student("CCCC", "572305", 1, new int[]{4, 4, 4, 4}));
        students.add(new Student("DDDD", "572305", 1, null));//may be NullPointerException

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        removeStudents(students);
        System.out.println("After remove from course:");
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        moveStudents(students);
        System.out.println("After move to next course:");
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
    }
}

package homework_7.university;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private static int count = 0;

    private final List<Student> STUDENTS = new ArrayList<>();
    private final List<Teacher> TEACHERS = new ArrayList<>();
    private final int ID;
    private final String NAME;

    public Group(List<Student> studentList) {
        this.ID = ++count;
        this.NAME = "Group #" + ID;
        for (Student student : studentList) {
            enroll(student);
        }
    }

    public void enroll(Student student) {
        STUDENTS.add(student);
    }

    public void expel(Student student) {
        STUDENTS.remove(student);
    }

    public String getNAME() {
        return NAME;
    }

    public void assign(Teacher teacher) {
        TEACHERS.add(teacher);
    }

    public void unassign(Teacher teacher) {
        TEACHERS.remove(teacher);
    }

    public List<Teacher> getTeachers() {
        return TEACHERS;
    }

    public List<Student> getStudents() {
        return STUDENTS;
    }
}

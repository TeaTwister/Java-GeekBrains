package homework_7.university;

import java.util.List;

public class Student extends Person {
    private Group group;

    public Student(String name, String surname) {
        super(name, surname);
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public List<Student> getMyClass() {
        return group.getStudents();
    }

    public List<Teacher> getMyTeachers() {
        return group.getTeachers();
    }

    @Override
    public String getNAME() {
        return super.getNAME() + " of " + group.getNAME();
    }
}

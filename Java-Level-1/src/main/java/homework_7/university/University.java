package homework_7.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Teacher> TEACHERS = new ArrayList<>();
    private final List<Student> STUDENTS = new ArrayList<>();
    private final List<Group> GROUPS = new ArrayList<>();

    public Group makeGroup() {
        return makeGroup(new ArrayList<>());
    }

    public Group makeGroup(List<Student> studentList) {
        STUDENTS.addAll(studentList);
        Group group = new Group(studentList);
        for (Student student : studentList) student.setGroup(group);
        GROUPS.add(group);
        return group;
    }

    public void enroll(Student student, Group group) {
        STUDENTS.add(student);
        student.setGroup(group);
    }

    public void expel(Student student) {
        student.getGroup().expel(student);
        student.setGroup(null);
        STUDENTS.remove(student);
    }

    public void move(Student student, Group group) {
        student.getGroup().expel(student);
        group.enroll(student);
        student.setGroup(group);
    }

    public void assign(Teacher teacher, Group group) {
        if (!TEACHERS.contains(teacher)) TEACHERS.add(teacher);
        teacher.assign(group);
        group.assign(teacher);
    }

    public void assign(Teacher teacher, List<Group> groups) {
        if (!TEACHERS.contains(teacher)) TEACHERS.add(teacher);
        for (Group group : groups) {
            teacher.assign(group);
            group.assign(teacher);
        }
    }

    public void unassign(Teacher teacher, Group group) {
        group.unassign(teacher);
        teacher.unassign(group);
        if (!teacher.getGROUPS().isEmpty()) TEACHERS.remove(teacher);
    }

    public void unassign(Teacher teacher) {
        for (Group group : teacher.getGROUPS()) group.unassign(teacher);
        teacher.getGROUPS().clear();
        TEACHERS.remove(teacher);
    }

    public List<Teacher> getTEACHERS() {
        return TEACHERS;
    }

    public List<Student> getSTUDENTS() {
        return STUDENTS;
    }

    public List<Group> getGROUPS() {
        return GROUPS;
    }
}

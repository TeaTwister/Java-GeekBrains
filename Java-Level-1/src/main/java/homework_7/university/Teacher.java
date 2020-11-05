package homework_7.university;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private final String SUBJECT;
    private final List<Group> GROUPS = new ArrayList<>();

    public Teacher(String name, String surname, String subject) {
        super(name, surname);
        this.SUBJECT = subject;
    }

    public void assign(Group group){
        GROUPS.add(group);
    }

    public void unassign(Group group) {
        GROUPS.remove(group);
    }

    public List<Group> getGROUPS() {
        return GROUPS;
    }

    public List<Student> getMyStudents() {
        List<Student> students = new ArrayList<>();
        for (Group group : GROUPS) students.addAll(group.getStudents());
        return students;
    }

    @Override
    public String getNAME() {
        return super.getNAME() + ", " + SUBJECT;
    }
}

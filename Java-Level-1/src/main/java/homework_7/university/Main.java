package homework_7.university;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        University u = new University();
        for (int i = 0; i < 3; i++) {
            List<Student> students = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                students.add(new Student("S" + (j + 1), "G" + (i + 1)));
            }
            u.makeGroup(students);
        }
        List<Group> groups = u.getGROUPS();
        Teacher teacher = new Teacher("THE", "DUDE", "MACROCHELL");
        u.assign(teacher, groups);
        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            System.out.println(group.getNAME());
            for (int j = 0; j < i; j++) {
                u.assign(new Teacher("T" + (j + 1), "G" + (i + 1), "S" + i * j), group);
            }
        }

        List<Teacher> teachers = u.getTEACHERS();
        for (Teacher t : teachers) {
            System.out.println(t.getNAME());
            for (Group group : t.getGROUPS()) {
                System.out.print(group.getNAME() + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (Group g : groups) {
            System.out.println(g.getNAME());
            for (Teacher t : g.getTeachers()) System.out.println(t.getNAME());
        }
        System.out.println();

        u.assign(teacher, u.makeGroup());
        System.out.println(teacher.getNAME());
        for (Group group : teacher.getGROUPS()) {
            System.out.print(group.getNAME() + " ");
        }
        System.out.println(teacher.getNAME());
        u.unassign(teacher, groups.get(0));
        for (Group group : teacher.getGROUPS()) {
            System.out.print(group.getNAME() + " ");
        }
        System.out.println(teacher.getNAME());
        u.unassign(teacher);
        for (Group group : teacher.getGROUPS()) {
            System.out.print(group.getNAME() + " ");
        }
        System.out.println();

        for (Teacher t : teachers) System.out.println(t.getNAME());

        List<Student> students = u.getSTUDENTS();
        for (Student student : students) System.out.println(student.getNAME());
        System.out.println();
        Group newGroup = u.getGROUPS().get(3);
        for (int i = 0; i < students.size(); i += 4) {
            u.move(students.get(i), newGroup);
        }
        for (Student student : students) System.out.println(student.getNAME());
        System.out.println();


        for (Group g : groups) {
            System.out.println(g.getNAME());
            for (Student s : g.getStudents()) {
                System.out.println(s.getNAME());
            }
        }

        System.out.println(students.size());

        for (int i = 0; i < students.size(); i += 3) {
            u.expel(students.get(i));
            i--;
        }

        System.out.println();

        for (Group g : groups) {
            System.out.println(g.getNAME());
            for (Student s : g.getStudents()) {
                System.out.println(s.getNAME());
            }
        }
        System.out.println(students.size());

    }
}

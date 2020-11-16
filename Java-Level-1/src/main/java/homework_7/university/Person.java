package homework_7.university;

public class Person {
    private final String NAME;
    private final String SURNAME;

    public Person(String name, String surname) {
        this.NAME = name;
        this.SURNAME = surname;
    }

    public String getNAME() {
        return NAME + " " + SURNAME;
    }
}

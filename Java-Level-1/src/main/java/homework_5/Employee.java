package homework_5;

public class Employee {
    private String name, jobTitle, email, phoneNumber;
    private int salary, age;

    public Employee(String name, String jobTitle, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("This is here %s, %s in our cool company.%n" +
                "He is of age %d and his salary is %d.%n" +
                "You can contact him by his email: %s, or phone: %s.%n",
                name, jobTitle.toLowerCase(), age, salary, email, phoneNumber);
    }

    public int getAge() {
        return age;
    }
}

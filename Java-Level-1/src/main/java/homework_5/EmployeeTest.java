package homework_5;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employeeJohn = new Employee(
                "John Doe",
                "Machinist",
                "jdoe@coolcompany.com",
                "+18005553535",
                40000,
                32
        );
        employeeJohn.printInfo();
        System.out.println();

        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(
                    String.format("Name %d", i),
                    String.format("Job %d", i),
                    String.format("name%dmail@coolcompany.com", i),
                    String.format("+7%d%d", (int) (Math.random() * 100) + 900,
                            (int) (Math.random() * 9000000) + 1000000),
                    (int) (Math.random() * 90000) + 30000,
                    (int) (Math.random() * 47) + 18
            );
        }

        for (Employee employee : employees) {
            if (employee.getAge() > 40) employee.printInfo();
        }
    }
}

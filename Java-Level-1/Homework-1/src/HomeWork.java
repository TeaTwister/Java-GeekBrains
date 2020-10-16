public class HomeWork {
    public static void main(String[] args) {

        byte verySmallNumber = -128;
        short smallNumber = -32768;
        int number = -2147483648;
        long bigNumber = -9223372036854775808L;

        float floatingPointNumber= 3.1415927f;
        double preciseFloatingPointNumber = 3.141592653589793;

        boolean cakeIsALie = true;

        char character = ' ';


        System.out.println(calculatorABCD(2, 3, 20, 5));


        System.out.println(isSumFrom10To20(5, 4));
        System.out.println(isSumFrom10To20(6, 4));
        System.out.println(isSumFrom10To20(10, 10));
        System.out.println(isSumFrom10To20(10, 11));


        printSign(-1);
        printSign(0);
        printSign(1);


        System.out.println(isNegative(-1));
        System.out.println(isNegative(0));


        greet("Linus");


        printIsLeapYear(1900);
        printIsLeapYear(1999);
        printIsLeapYear(2000);
        printIsLeapYear(2020);
    }


    public static int calculatorABCD(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }


    public static boolean isSumFrom10To20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }


    public static void printSign(int number) {

        if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Positive");
        }
    }


    public static boolean isNegative(int number) {
        return number < 0;
    }


    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }


    public static void printIsLeapYear(int year) {
        boolean divisibleBy4 = year % 4 == 0;
        boolean divisibleBy100 = year % 100 == 0;
        boolean divisibleBy400 = year % 400 == 0;
        boolean leap = divisibleBy4 && !divisibleBy100 || divisibleBy400;

        if (leap) {
            System.out.println(year + " year is a leap year.");
        } else {
            System.out.println(year + " year is a common year.");
        }
    }
}

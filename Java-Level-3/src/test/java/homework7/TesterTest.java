package homework7;

import homework7.annotations.AfterSuite;
import homework7.annotations.BeforeSuite;
import homework7.annotations.MyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TesterTest {

    private final ByteArrayOutputStream content = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(content));
    }

    @After
    public void restoreStream() {
        System.setOut(original);
    }

    @Test
    public void beforeThrowTest() {
        Assert.assertThrows(RuntimeException.class, () -> Tester.start(doubleBeforeClass.class));
    }

    @Test
    public void afterThrowTest() {
        Assert.assertThrows(RuntimeException.class, () -> Tester.start(doubleAfterClass.class));
    }


    @Test
    public void orderTest() {
        String expected = "before05557after";
        Tester.start(orderedClass.class);
        String actual = content.toString();
        Assert.assertEquals(expected, actual);
    }
}

class doubleBeforeClass {
    @BeforeSuite
    void foo() {
        System.out.println("foo");
    }

    @BeforeSuite
    void bar() {
        System.out.println("bar");
    }
}

class doubleAfterClass {
    @BeforeSuite
    void foo() {
        System.out.println("foo");
    }

    @AfterSuite
    void foo1() {
        System.out.println("foo");
    }

    @AfterSuite
    void bar() {
        System.out.println("bar");
    }
}

class orderedClass {
    public orderedClass() {
    }

    @BeforeSuite
    void before() {
        System.out.print("before");
    }

    @MyTest(5)
    void foo1() {
        System.out.print(5);
    }

    @MyTest
    void foo2() {
        System.out.print(0);
    }

    @MyTest(5)
    void foo3() {
        System.out.print(5);
    }

    @MyTest(7)
    void foo4() {
        System.out.print(7);
    }

    @MyTest(5)
    void foo5() {
        System.out.print(5);
    }

    @AfterSuite
    void after() {
        System.out.print("after");
    }
}

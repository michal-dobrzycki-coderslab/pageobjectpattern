package junit;

import org.junit.*;

public class JunitTest {

    @BeforeClass
    public static void setUpOnce(){
        System.out.println("Uruchamiam metodę @BeforeClass");
    }

    @AfterClass
    public static void tearDownOnce(){
        System.out.println("Uruchamiam metodę @AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("Uruchamiam metodę @Before");
    }

    @After
    public void tearDown() {
        System.out.println("Uruchamiam metodę @After");
    }

    @Test
    public void test1() {
        System.out.println("Test 1 - uruchomiony");
    }

    @Ignore
    @Test
    public void test2() {
        System.out.println("Test 2 - uruchomiony");
    }
}

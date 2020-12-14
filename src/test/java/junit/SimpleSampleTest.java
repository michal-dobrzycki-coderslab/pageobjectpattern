package junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleSampleTest {

    @Test
    public void simpleStringTest() {
        String testString = "CodersJava";
        assertTrue(testString.startsWith("Code"));
    }

    @Test
    public void simpleTestList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertEquals(4, list.size());
        assertEquals(list.get(1), Integer.valueOf(2));
        assertEquals(list.get(3), Integer.valueOf(4));
    }
}
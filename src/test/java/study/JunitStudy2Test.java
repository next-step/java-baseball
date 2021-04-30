package study;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class JunitStudy2Test {

    @Before
    public void printBefore() {
        System.out.println("before!");
    }

    @After
    public void printAfter() {
        System.out.println("after!!");
    }

    @Test
    public void assertEqualsTest() {
        assertEquals(true, true);
        System.out.println("test1");
        assertEquals(true, false);
        System.out.println("test2");
        assertEquals(true, true);
        System.out.println("test3");
    }
}

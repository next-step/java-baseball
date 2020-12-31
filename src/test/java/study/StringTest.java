package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void test() {
        System.out.print("test start");
        String str="1,2";
        String[] num=str.split(",");
        assertThat(num).contains("2");
    }
}
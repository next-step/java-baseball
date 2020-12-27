package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MySetTest {
    private MySet set;

    @BeforeEach
    public void setUp() {
        set = new MySet();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void checkSizeWithDuplicateElement() {
        assertThat(set.size()).isEqualTo(3);
    }
}

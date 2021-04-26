package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName(value = "Set Collection 학습테스트")
public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName(value =
            "Set의 size() 메소드를 활용해 " +
                    "Set의 크기를 확인")
    void Requirements1_1(){
        int size = (int) numbers.stream().count();
        assertTrue(numbers.size() == size);
    }

    @Test
    @DisplayName(value =
            "Set의 contains() 메소드를 활용해" +
                    "1, 2, 3의 값이 존재하는지 확인")
    void Requirements2_1(){
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
    }

    @DisplayName(value =
            "junit의 ParameterizedTest를 활용해" +
                    "중복 코드를 제거")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1","2","3"})
    void Requirements2_2(String input) {
        assertNotNull(input);

    }
}

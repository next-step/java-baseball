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

    @DisplayName(value =
            "junit의 ParameterizedTest를 활용해" +
                    "중복 코드를 제거")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1","2","3"})
//    @MethodSource("provideStringsForIsBlank")   //BeforeEach보다 먼저 실행
    void Requirements2_2(String input) {
        assertNotNull(input);

    }

    //numbers null, because this method is faster than @BeforeEach
    //need to static numbers
    private Stream<Arguments> provideStringsForIsBlank() {
        Object arguments[] = numbers.toArray();
        Stream<Arguments> of = Stream.of(Arguments.of(arguments));
        return of;
    }

    @DisplayName(value =
            "입력 값에 따라 결과 값이 다른 경우에 대한 테스트" +
                    "1,2,3 값은 contains 메소드 실행결과 true" +
                    "4,5 값을 넣으면 false가 반환")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"}, delimiter = ',')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(Integer input, String expected) {
        String actualValue = String.valueOf(numbers.contains(input));
        assertEquals(expected, actualValue);
    }
}

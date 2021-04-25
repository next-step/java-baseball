package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BasicTest {


    @ParameterizedTest
    @MethodSource("provideStringForSplitTest")
    public void splitTest(String parameter, String[] expected) {

        // when
        String[] splitted = parameter.split(",");

        // then
        Assertions.assertThat(splitted).contains(expected);
        Assertions.assertThat(splitted).containsExactly(expected);
    }

    private static Stream<Arguments> provideStringForSplitTest() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }
}

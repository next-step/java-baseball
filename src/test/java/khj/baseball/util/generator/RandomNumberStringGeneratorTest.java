package khj.baseball.util.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberStringGeneratorTest {
    RandomStringGenerator generator = new RandomNumberStringGenerator();

    @ParameterizedTest(name = "파라미터로 넘긴 {arguments} 만큼의 랜덤 문자열을 만드는 지 검사")
    @ValueSource(ints = {3, 4, 5})
    void generatorStringLength(int length) {
        String generatorString = generator.generatorString(length);

        assertEquals(length, generatorString.length());
    }

    @DisplayName("중복된 문자가 없는 지 검사")
    @Test
    void generatorStringOverlap() {
        String generatorString = generator.generatorString(3);
        Set<Character> check = new HashSet<>();

        for (int i= 0; i < generatorString.length(); i++) {
            check.add(generatorString.charAt(i));
        }

        assertEquals(3, check.size());
    }
}

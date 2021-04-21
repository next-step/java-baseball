package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set 콜렉션 관련 테스트")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(1,2,3));
    }


    @DisplayName("크기 확인 메서드(size()) 테스트")
    @Test
    void sizeTest() {

    }

    @DisplayName("콜렉션 내부 파라미터 포함여부 확인 메서드(contains()) 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int input) {

    }

    @DisplayName("콜렉션 내부에 존재하지 않는 파라미터 포함여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsByConditionTest(int input, boolean inputBool) {

    }

}

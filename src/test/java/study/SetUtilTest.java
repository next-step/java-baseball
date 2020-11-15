package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetUtilTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기 확인")
    @Test
    void req_1 (){
        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("ParameterizedTest를 이용한 테스트 중복제거")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void req_2 (int input){
        Boolean containYN = numbers.contains(input);
        assertThat(containYN).isTrue();
    }

    @DisplayName("파라미터에 따라 테스트 결과를 달리함")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void req_3 (int input, Boolean expected){
        Boolean containYN = numbers.contains(input);
        assertThat(containYN).isEqualTo(expected);
    }



}
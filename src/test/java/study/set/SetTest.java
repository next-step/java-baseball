package study.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    //Test Case 구현
    @Test
    @DisplayName("요구사항1 Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    public void isSize(){
        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항2 Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트")
    public void contains(int value){
        //when,then
        assertThat(numbers.contains(value)).isTrue();
    }
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false","5,false"})
    @DisplayName("요구사항3  입력 값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 구현")
    public void isContains(int value,boolean checker){
        //when
        boolean isCheker = numbers.contains(value);

        //then
        assertThat(checker).isEqualTo(isCheker);

    }

}

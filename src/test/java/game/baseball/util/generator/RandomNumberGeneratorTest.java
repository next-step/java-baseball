package game.baseball.util.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("1부터 9까지의 랜덤숫자 생성")
    public void getRandomNumber(){
        RandomNumberGenerator rng = new RandomNumberGenerator();
        int randomNumber = rng.getRandomNumber();
        assertThat(randomNumber).isBetween(1,9);
    }

    static Stream<Arguments> provideStringsForIsDuplication() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(9);
        return Stream.of(
                Arguments.of(list, 3, true),
                Arguments.of(list, 2, false),
                Arguments.of(list, 9, true)
        );
    }
    @ParameterizedTest
    @MethodSource("provideStringsForIsDuplication")
    @DisplayName("리스트에 중복된 숫자가 포함되는지 체크")
    public void checkDuplication(ArrayList<Integer> list, int checkNumber,boolean expected){
        RandomNumberGenerator rng = new RandomNumberGenerator();
        boolean duplicationStatus = rng.checkDuplication(list,checkNumber);
        assertThat(duplicationStatus).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("서로 다른 수로 이루어진 size의 리스트 생성")
    public void getRandomNumberList(int size){
        RandomNumberGenerator rng = new RandomNumberGenerator();
        ArrayList<Integer> list = rng.getRandomNumberList(size);

        assertThat(list.size()).isEqualTo(size);
    }
}

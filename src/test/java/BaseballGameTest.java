import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import core.PlayResult;
import util.InputNumberUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @DisplayName("입력 숫자 문자열을 정수 리스트로 반환하는 메소드 테스트")
    @RepeatedTest(100)
    void transNumberStringToArrayListTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);

        String numberString = list.get(0).toString() + list.get(1).toString() + list.get(2).toString();
        
        List<Integer> answer = InputNumberUtil.toIntegerList(numberString);

        assertThat(answer).hasSize(3);
        assertThat(answer.containsAll(list.subList(0, 3))).isTrue();
    }

    @DisplayName("3 스트라이크(해결) 테스트")
    @Test
    void threeStrikeTest() {
        PlayResult playResult = new PlayResult();
        for(int i = 0; i < 3; i++){
            playResult.countPlayResult(Arrays.asList(1, 2, 3), i, Arrays.asList(1, 2, 3));
        }

        assertThat(playResult.getIsStrike()).isEqualTo(3);
        assertThat(playResult.getIsBall()).isEqualTo(0);
        assertThat(playResult.isNothing()).isFalse();
        assertThat(playResult.isSolved()).isTrue();

    }    

    @DisplayName("3 볼 테스트")
    @Test
    void threeBallTest() {
        PlayResult playResult = new PlayResult();
        for(int i = 0; i < 3; i++){
            playResult.countPlayResult(Arrays.asList(1, 2, 3), i, Arrays.asList(3, 1, 2));
        }

        assertThat(playResult.getIsStrike()).isEqualTo(0);
        assertThat(playResult.getIsBall()).isEqualTo(3);
        assertThat(playResult.isNothing()).isFalse();
        assertThat(playResult.isSolved()).isFalse();

    }    

    @DisplayName("Nothing 테스트")
    @Test
    void nothingTest() {
        PlayResult playResult = new PlayResult();
        for(int i = 0; i < 3; i++){
            playResult.countPlayResult(Arrays.asList(1, 2, 3), i, Arrays.asList(4, 5, 6));
        }

        assertThat(playResult.getIsStrike()).isEqualTo(0);
        assertThat(playResult.getIsBall()).isEqualTo(0);
        assertThat(playResult.isNothing()).isTrue();
        assertThat(playResult.isSolved()).isFalse();

    }    
}

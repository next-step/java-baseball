package baseballgame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameNumberTest {

    @DisplayName("GameNumber를 랜덤으로 생성 할 수 있다.")
    @Test
    public void generateGameNumberRandomlyTest() {
        // when
        final GameNumber gameNumber = GameNumber.generateRandomly();
        // then
        assertThat(gameNumber).extracting("numberList").isNotNull();
    }

    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 가진 리스트로 GameNumber를 생성 할 수 있다.")
    @Test
    public void generateGameNumberByNumberListSuccessTest() {
        // given
        final List<Integer> numberList = createNumberList(1,2,3);
        // when
        final GameNumber gameNumber = GameNumber.of(numberList);
        //then
        assertThat(gameNumber).isNotNull();
    }

    @DisplayName("numberList의 요소의 수가 3이 아니면 예외가 발생한다.")
    @Test
    public void generateGameNumberByNumberListFailTest() {
        // given
        final List<Integer> numberList1 = createNumberList(1,2,3,4);
        final List<Integer> numberList2 = createNumberList(1,2);
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> GameNumber.of(numberList1));
        assertThatIllegalArgumentException().isThrownBy(() -> GameNumber.of(numberList2));
    }

    @DisplayName("numberList에 1에서 9사이의 값이 아닌 값이 있으면 예외가 발생한다.")
    @Test
    public void generateGameNumberByNumberListFailTest2() {
        // given
        final List<Integer> numberList = createNumberList(1,2,10);
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> GameNumber.of(numberList));
    }

    @DisplayName("numberList에 동일한 값이 존재하면 예외가 발생한다.")
    @Test
    public void generateGameNumberByNumberListFailTest3() {
        // given
        final List<Integer> numberList = createNumberList(1,1,2);
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> GameNumber.of(numberList));
    }

    public List<Integer> createNumberList(int... numbers) {
        final List<Integer> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(number);
        }
        return numberList;
    }

}
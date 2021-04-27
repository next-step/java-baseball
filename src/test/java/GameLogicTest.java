import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GameLogicTest {
    GameLogic gameLogic = new GameLogic();

    @Test()
    void assertSameIndex() {
        List standardList = Lists.newArrayList(1, 2, 3);

        List longList = Lists.newArrayList(1, 2, 3, 4, 5);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            gameLogic.compareSameIndex(standardList, longList);
        }).withMessage("동일한 자리수의 List만 비교가 가능합니다.");

        List someSameList = Lists.newArrayList(1, 3, 2);
        assertThat(gameLogic.compareSameIndex(standardList, someSameList)).isEqualTo(1);
        List noSameList = Lists.newArrayList(4, 5, 6);
        assertThat(gameLogic.compareSameIndex(standardList, noSameList)).isEqualTo(0);
        List sameList = Lists.newArrayList(1, 2, 3);
        assertThat(gameLogic.compareSameIndex(standardList, sameList)).isEqualTo(3);
    }

}
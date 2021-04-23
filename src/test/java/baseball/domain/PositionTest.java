package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;


public class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,Integer.MAX_VALUE})
    public void 양수만_가질_수_있다(int position) {
        assertThatNoException().isThrownBy(() -> new Position(position));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,Integer.MIN_VALUE})
    public void 음수를_가지면_Exception_발생(int position) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(position));
    }
}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {
    @Test
    @DisplayName("서로 같은 문자열을 입력받았을 때 1, 다른 문자를 입력받았을 때 0을 반환하는지 검사한다")
    void checkEqualCharTest(){
        assertThat(Util.checkEqualChar('c', 'a')).isZero();
        assertThat(Util.checkEqualChar('c', 'c')).isEqualTo(1);
    }
}

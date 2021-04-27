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

    @Test
    @DisplayName("2개의 문자열을 입력받아 두번째 문자가 첫번째 문자에 포함되는 경우 1, 아닌경우 0을 반환하는지 검사한다")
    void checkContains(){
        String sampleStr = "abc";
        String sampleWord1 = "c";
        assertThat(Util.checkContains(sampleStr, sampleWord1)).isEqualTo(1);

        String sampleWord2 = "z";
        assertThat(Util.checkContains(sampleStr, sampleWord2)).isZero();
    }

    @Test
    @DisplayName("비어있는 문자열을 입력받는 경우 그대로, 비어있지 않은 문자열을 입력받는 경우 공백이 한칸 추가된 결과값을 반환하는지 검사한다")
    void setEmptyMsgTest() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder test = stringBuilder.append("test");
        assertThat(Util.setEmptyMsg(test).toString()).hasToString("test ");

        StringBuilder stringBuilderEmpty = new StringBuilder();
        assertThat(Util.setEmptyMsg(stringBuilderEmpty).toString()).isEmpty();
    }
}

package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumbersTest {
    @Test
    @DisplayName("야구번호 담긴 갯수가 세개를 초과하면 IllegalArgumentException를 리턴한다.")
    public void threeOverSize() {
        List<Integer> baseballNumbers = new ArrayList<>();
        for(int i = 1; i < 5; i++) {
            baseballNumbers.add(i);
        }

        expectIllegalArgumentException(baseballNumbers);
    }

    @Test
    @DisplayName("야구번호 담긴 갯수가 세개 미만이면 IllegalArgumentException를 리턴한다.")
    public void threeUnderSize() {
        List<Integer> baseballNumbers = new ArrayList<>();
        for(int i = 1; i < 2; i++) {
            baseballNumbers.add(i);
        }

        expectIllegalArgumentException(baseballNumbers);
    }

    @Test
    @DisplayName("야구번호에 문자가 들어가면 NumberFormatException를 리턴한다.")
    public void inputUnexpectedString() {
        String numberInput = "2f3";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            BaseballNumbers.of(numberInput);
        });
    }

    @Test
    @DisplayName("중복된 숫자가 들어가면 IllegalArgumentException를 리턴한다.")
    public void inputDuplicateNumber() {
        String duplicationInput = "233";
        expectIllegalArgumentException(duplicationInput);
    }

    @Test
    @DisplayName("야구번호에 0을 입력하면 IllegalArgumentException를 리턴한다.")
    public void inputZero() {
        String zeroInput = "230";
        expectIllegalArgumentException(zeroInput);
    }

    @Test
    @DisplayName("야구번호가 3자리를 초과하면 IllegalArgumentException를 리턴한다.")
    public void oversizeInputString() {
        String oversizeInput = "1463";
        expectIllegalArgumentException(oversizeInput);
    }

    @Test
    @DisplayName("야구번호에 null값이 입력되면 NullPointerException를 리턴한다.")
    public void inputNull() {
        String nullInput = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            BaseballNumbers.of(nullInput);
        });
    }

    private void expectIllegalArgumentException(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumbers.of(input);
        });
    }

    private void expectIllegalArgumentException(List<Integer> input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumbers.of(input);
        });
    }

    @Test
    @DisplayName("리스트로 담긴 야구게임 결과가 1스트라이크 1볼인지 비교한다.")
    public void matchListType(){
        BaseballNumbers answer = BaseballNumbers.of(new ArrayList<>(Arrays.asList(7,6,5)));
        BaseballNumbers user = BaseballNumbers.of(new ArrayList<>(Arrays.asList(8,6,7)));
        BaseballResult result = answer.match(user);

        assertThat(result.getStrike().toString()).isEqualTo("1");
        assertThat(result.getBall().toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("문자열로 입력된 야구게임 결과가 0스트라이크 1볼인지 비교한다.")
    public void matchStringType(){
        BaseballNumbers answer = BaseballNumbers.of("456");
        BaseballNumbers user = BaseballNumbers.of("125");
        BaseballResult result = answer.match(user);

        assertThat(result.getStrike().toString()).isEqualTo("0");
        assertThat(result.getBall().toString()).isEqualTo("1");
    }
}

package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameDigitRepositoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"0000", "0123", "123", "12", "9182", "9990", "99999"})
    @DisplayName("숫자로 된 문자열을 받아서 한 자리 게임 숫자(GameDigit) 리스트를 반환한다.")
    void getDigitTest(String raw) {
        List<Integer> splitInt = convertRawToIntegers(raw);
        List<GameDigit> digitsByRaw = GameDigitRepository.getDigitsByRaw(raw);

        assertThat(digitsByRaw).hasSize(raw.length());
        assertThat(digitsByRaw).extracting("digit")
                .isEqualTo(splitInt);

    }

    private List<Integer> convertRawToIntegers(String raw) {
        String[] split = raw.split("");
        List<Integer> splitInt = new ArrayList<>();
        for (String s : split) {
            splitInt.add(Integer.parseInt(s));
        }
        return splitInt;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 9, 10})
    @DisplayName("입력한 개수 만큼의 중복 되지 않는 한 자리 게임 숫자(GameDigit) 를 제공한다.")
    void getNotDupDigitsTest(int length) {
        List<GameDigit> notDuplicateGameDigits = GameDigitRepository.getNotDuplicateGameDigits(length);

        Set<GameDigit> set = new HashSet<>(notDuplicateGameDigits);

        assertThat(set).hasSize(length);
    }
}

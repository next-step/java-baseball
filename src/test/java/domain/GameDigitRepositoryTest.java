package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameDigitRepositoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"0000", "0123", "123", "12", "9182", "9990", "99999"})
    @DisplayName("숫자로 된 문자열을 받아서 한 자리 게임 숫자 리스트를 반환한다.")
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
}
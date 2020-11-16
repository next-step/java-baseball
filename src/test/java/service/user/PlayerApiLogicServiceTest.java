package service.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class PlayerApiLogicServiceTest {

    @DisplayName("4자리 이상 숫자 입력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1", "1111"})
    void inputNumberLengthCheck(String input) {
        if(input.length() > 3)
            throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("숫자 중복 입력 확인")
    public void duplicateCheckNumber() {
        String input = "233";

        boolean flag = true;
        char[] inputArr = new char[3];
        for(int i=0; i<input.length(); i++) {
            inputArr[i] = input.charAt(i);
        }

        if(inputArr[0] == inputArr[1] || inputArr[0] == inputArr[2] || inputArr[1] == inputArr[2]) {
            flag = false;
        }

        assertThat(flag).isFalse();
    }
}
package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class SetUtilTest {

    @Test
    @DisplayName("Set -> List 변환 테스트")
    public void transferSetToListTest() {
        // given
        List<Object> expected = Arrays.asList(1,2,3);
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);

        // when
        ArrayList<Integer> integerArrayList = SetUtil.transferSetToList(integerSet);

        // then
        assertThat(integerArrayList).isEqualTo(expected);
        
    }
}
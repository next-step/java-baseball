package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayAsListTest {
    @Test
    @DisplayName("VarArgs를 ArrayAsList를 할 경우 길이가 VarArgs와 같아야한다")
    public void VarArgs를_ArrayAsList를_할_경우_길이가_VarArgs와_같아야한다() {
        assertThat(varArgsConvertToArrayASList(1,2,3,4,5).size())
                .isEqualTo(5);
    }

    private List<Integer> varArgsConvertToArrayASList(Integer ...vars) {
        return Arrays.asList(vars);
    }
}

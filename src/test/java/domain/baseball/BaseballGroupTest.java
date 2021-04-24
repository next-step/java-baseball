package domain.baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballGroupTest {

    private List<Baseball> baseballList;

    @ParameterizedTest
    @ValueSource(longs = {0,10,11,12})
    void baseball_group_validate_number_size(){
        baseballList = new ArrayList<>();
        baseballList.add(new Baseball((long) 2));
        baseballList.add(new Baseball((long)3));
        baseballList.add(new Baseball((long)1));
        baseballList.add(new Baseball((long)4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BaseballGroup.validateNumberSize(baseballList));
    }

    @Test
    void validate_duplicate_number_value(){
        baseballList = new ArrayList<>();
        baseballList.add(new Baseball((long)2));
        baseballList.add(new Baseball((long)2));
        baseballList.add(new Baseball((long)3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> BaseballGroup.validateDuplicateNumberValue(baseballList));
    }

    @Test
    void create_baseball_group(){
        baseballList = new ArrayList<>();
        baseballList.add(new Baseball((long)1));
        baseballList.add(new Baseball((long)2));
        baseballList.add(new Baseball((long)3));

        BaseballGroup baseballGroup = new BaseballGroup(baseballList);

        assertThat(baseballGroup.baseballValueSize()).isEqualTo(3);

    }
}

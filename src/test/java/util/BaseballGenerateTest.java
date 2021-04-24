package util;

import domain.baseball.BaseballGroup;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGenerateTest {

    @Test
    void player_create_baseball_number(){
        BaseballGroup baseballGroup = BaseballGenerate.createBaseballGroup();
        assertThat(baseballGroup.baseballValueSize()).isEqualTo(3);
    }
}

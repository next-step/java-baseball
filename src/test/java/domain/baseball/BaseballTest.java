package domain.baseball;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballTest {

    @ParameterizedTest
    @ValueSource(longs = {0,10,11,12})
    void validate_number_nalue(long input){
        Long baseballNumber = input;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Baseball.validateNumberValue(baseballNumber));
    }

    @Test
    void create_baseball(){
        Baseball baseball = Baseball.valueOf((long)3);
        assertThat(baseball).isEqualTo(Baseball.valueOf((long)3));
    }
}

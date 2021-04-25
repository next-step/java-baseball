package baseball;

import baseball.entity.SelectNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectNumberGeneratorTest {
    @Test
    @DisplayName("세 자리수 선택 번호 생성")
    public void createSelectedNumber(){

        SelectNumberGenerator selectNumber = new SelectNumberGenerator();

        assertThat(selectNumber.getGenerateNumber().length() == 3).isTrue();
    }
}

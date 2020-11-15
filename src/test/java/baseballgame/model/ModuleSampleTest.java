package baseballgame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleSampleTest {

    ModuleSample sample = new ModuleSample(1, "I'm one");

    @Test
    @DisplayName("샘플 모델 기본 테스트")
    void getInfoTest() {
        assertEquals("1I'm one", sample.getInfo());
    }
}

package baseball.repository;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberFactory;
import baseball.domain.BaseballNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberRepositoryTest {

    private BaseballNumberRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BaseballNumberRepository();
    }

    @Test
    @DisplayName("저장 및 조회")
    void saveAndFind() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> numbersBase = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbersBase);

        // when
        repository.save(baseballNumbers);

        // then
        assertThat(baseballNumbers).isEqualTo(repository.find());
    }
}
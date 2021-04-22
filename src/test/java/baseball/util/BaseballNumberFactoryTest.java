package baseball.util;

import baseball.domain.BaseballNumbers;
import baseball.util.BaseballNumberFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class BaseballNumberFactoryTest {
    private BaseballNumberFactory baseballNumberFactory;

    BaseballNumberFactoryTest() {
    }

    @BeforeEach
    void setUp() {
        this.baseballNumberFactory = new BaseballNumberFactory();
    }

    @Test
    @DisplayName("[야구번호_생성_테스트]야구번호_수가_세_개인지_테스트")
    void verifyThreeBaseballNumbersGenerated() {
        BaseballNumbers baseballNumbers = this.baseballNumberFactory.generateNumbers();
        Assertions.assertEquals(3, baseballNumbers.size());
    }

    @Test
    @DisplayName("[야구번호_생성_테스트]야구번호_수의_범위가_1~9인지_테스트")
    void verifyBaseballNumbersBoundary() {
        BaseballNumbers baseballNumbers = this.baseballNumberFactory.generateNumbers();
        Iterator var2 = baseballNumbers.getValues().iterator();

        while(var2.hasNext()) {
            String baseballNumber = (String)var2.next();
            Assertions.assertTrue(Integer.parseInt(baseballNumber) >= 1);
            Assertions.assertTrue(Integer.parseInt(baseballNumber) <= 9);
        }

    }

    @Test
    @DisplayName("[야구번호_생성_테스트]야구번호가_중복되지_않았는지_테스트")
    void verifyBaseballNumbersNonRedundant() {
        BaseballNumbers baseballNumbers = this.baseballNumberFactory.generateNumbers();
        Set<String> baseballNumbersSet = new HashSet<String>(baseballNumbers.getValues());
        Assertions.assertEquals(baseballNumbers.size(), baseballNumbersSet.size());
    }
}

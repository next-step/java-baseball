package baseball.domain;

import org.junit.jupiter.api.Test;

public class BaseballGeneratorTest {
    @Test
    public void generateRandomNo() throws Exception {
        Baseball baseballAnswer1 = BaseballGenerator.generateRandomNo();
        Baseball baseballAnswer2 = BaseballGenerator.generateRandomNo();
        System.out.println(baseballAnswer1.toString());
        System.out.println(baseballAnswer2.toString());
    }

}

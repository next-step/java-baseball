package baseball.service;

import baseball.enums.MatchType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import static org.junit.jupiter.api.Assertions.assertTrue;;

public class ResultCheckerTest {

    @DisplayName("GoalNumbers 정상 생성 테스트")
    @Test
    public void goalnumbers_generate_success() throws Exception {
        ResultChecker resultChecker = new ResultChecker();

        List<Integer> goalNumbers = resultChecker.getGoalNumbers();
        Assertions.assertNotNull(goalNumbers);
        Assertions.assertTrue(goalNumbers.size() == 3);
    }

    @DisplayName("GoalNumbers 매칭 결과 계산 정상 테스트")
    @Test
    public void calculate_match_result_success() throws Exception {
        ResultChecker resultChecker = new ResultChecker();

        resultChecker.setGoalNumbers(Arrays.asList(1, 2, 3));
        resultChecker.setUserNumbers(Arrays.asList(1, 3, 2));

        resultChecker.calculateMatchType();

        assertTrue(resultChecker.getStrikeCount() == 1);
        assertTrue(resultChecker.getBallCount() == 2);
    }

}

package baseball.judge;

import java.util.List;

public interface JudgeService {
	Judge judgeQuestion(List<Integer> answer, List<String> question);
}

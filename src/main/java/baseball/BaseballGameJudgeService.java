package baseball;

import baseball.dto.BaseballGameJudgeDto;

public class BaseballGameJudgeService {

    BaseballGameJudgeDto judge(String computerNumber, String inputNumber) {
        BaseballGameJudgeDto result = new BaseballGameJudgeDto(0, 0);

        for (int i = 0 ; i < 3 ; i++) {
            int strike = checkStrike(i, computerNumber.charAt(i), inputNumber);
            int boll = checkBoll(i, computerNumber.charAt(i), inputNumber);
            BaseballGameJudgeDto dto = new BaseballGameJudgeDto(strike, boll);
            result.merge(dto);
        }

        return result;
    }

    public boolean isEnd(BaseballGameJudgeDto judgeDto) {
        return judgeDto.getStrike() == 3;
    }

    private int checkBoll(int index, char target, String inputNumber) {
        int bollCount = 0;
        index = nextIndex(index);
        if (target == inputNumber.charAt(index)) {
            bollCount ++;
        }
        index = nextIndex(index);
        if (target == inputNumber.charAt(index)) {
            bollCount ++;
        }
        return bollCount;
    }

    private int nextIndex(int index) {
        return (index + 1) % 3;
    }

    private int checkStrike(int index, char target, String inputNumber) {
        if (target == inputNumber.charAt(index)) {
            return 1;
        }

        return 0;
    }
}

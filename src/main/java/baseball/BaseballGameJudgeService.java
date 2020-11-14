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

    public void printJudgeResult(BaseballGameJudgeDto judgeDto) {
        int strike = judgeDto.getStrike();
        if (strike > 0) {
            System.out.printf("%d 스트라이크 ", strike);
        }

        int boll = judgeDto.getBoll();
        if (boll > 0) {
            System.out.printf("%d 볼 ", boll);
        }

        if (strike == 0 && boll == 0) {
            System.out.println("낫싱");
        }

        System.out.print("\n");
    }

    private int checkBoll(int index, char target, String inputNumber) {
        int checkIndex2 = (index + 1) % 3;
        int checkIndex3 = (index + 2) % 3;

        int bollCount = 0;

        if (target == inputNumber.charAt(checkIndex2)) {
            bollCount++;
        }

        if (target == inputNumber.charAt(checkIndex3)) {
            bollCount++;
        }

        return bollCount;
    }

    private int checkStrike(int index, char target, String inputNumber) {
        if (target == inputNumber.charAt(index)) {
            return 1;
        }

        return 0;
    }
}

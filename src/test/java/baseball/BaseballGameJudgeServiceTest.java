package baseball;

import baseball.dto.BaseballGameJudgeDto;
import org.junit.Assert;
import org.junit.Test;


public class BaseballGameJudgeServiceTest {

    private BaseballGameJudgeService judgeService = new BaseballGameJudgeService();


    @Test
    public void TEST_judge() {
        String computer = "713";

        BaseballGameJudgeDto judge1 = judgeService.judge(computer, "123");
        Assert.assertEquals(1, judge1.getStrike());
        Assert.assertEquals(1, judge1.getBoll());

        BaseballGameJudgeDto judge2 = judgeService.judge(computer, "145");
        Assert.assertEquals(0, judge2.getStrike());
        Assert.assertEquals(1, judge2.getBoll());

        BaseballGameJudgeDto judge3 = judgeService.judge(computer, "671");
        Assert.assertEquals(0, judge3.getStrike());
        Assert.assertEquals(2, judge3.getBoll());

        BaseballGameJudgeDto judge4 = judgeService.judge(computer, "216");
        Assert.assertEquals(1, judge4.getStrike());
        Assert.assertEquals(0, judge4.getBoll());

        BaseballGameJudgeDto judge5 = judgeService.judge(computer, "713");
        Assert.assertEquals(3, judge5.getStrike());
        Assert.assertEquals(0, judge5.getBoll());
    }

}
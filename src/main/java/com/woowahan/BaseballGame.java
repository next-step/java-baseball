package com.woowahan;

import com.woowahan.service.BaseballGameService;
import com.woowahan.vo.Result;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;

import static com.woowahan.constants.MessageConstants.*;
import static com.woowahan.enums.EndType.END;
import static com.woowahan.enums.EndType.RETRY;
import static com.woowahan.enums.PlayType.*;

public class BaseballGame {

    public static Set<Integer> computerSet;

    public static void main(String[] args) {
        System.out.println(GREETING_MESSAGE);
        boolean isContinue = true;
        BaseballGameService.init();
        computerSet = BaseballGameService.getComputerSet();
        while (isContinue) {
            isContinue = !BaseballGameService.playGame();
        }
        BaseballGameService.destory();
    }
}

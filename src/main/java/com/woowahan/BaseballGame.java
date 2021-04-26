package com.woowahan;

import com.woowahan.vo.ResultVo;

import java.util.*;

import static com.woowahan.constants.MessageConstants.*;
import static com.woowahan.enums.EndType.END;
import static com.woowahan.enums.EndType.RETRY;
import static com.woowahan.enums.PlayType.*;

public class BaseballGame {

    static Scanner scanner;

    public static void main(String[] args) {
        System.out.println(GREETING_MESSAGE);
        scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
        }
        System.out.println(END_MESSAGE);
        scanner.close();
    }

}

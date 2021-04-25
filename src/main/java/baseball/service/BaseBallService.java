package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import baseball.type.ResultType;
import baseball.view.UserInputView;

import java.util.ArrayList;

public class BaseBallService {

    ArrayList<Integer> resultList;

    public BaseBallService() {
        init();
    }

    private void init() {
        resultList = Computer.createNumbers();
    }

    public void start() {
        String inputStr = UserInputView.inputNumbers();

        ResultType resultType = resultCheck(inputStr);
        resultConfirm(resultType);
        String restartStr = restartCheck();
        restartConfirm(restartStr);

        System.exit(0);
    }

    private ResultType resultCheck(String inputStr) {
        Result result = null;
        ResultType resultType = null;
        try {
            result = new Result(resultList, User.inputStrToList(inputStr));
            resultType = result.getResultType();
            UserInputView.resultConfirm(resultType);
        } catch (IllegalArgumentException e) {
            start();
        }
        return resultType;
    }

    private void resultConfirm(ResultType resultType) {
        if(!resultType.isResult()) {
            start();
        }
    }

    private String restartCheck() {
        String restartStr = "";
        try {
            restartStr = UserInputView.inputRestart();
            User.validateRestart(restartStr);
        } catch (IllegalArgumentException e) {
            restartStr = restartCheck();
        }

        return restartStr;
    }

    private void restartConfirm(String restartStr) {
        if("1".equals(restartStr)) {
            init();
            start();
        }
    }
}

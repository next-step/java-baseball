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
        resultList.forEach(System.out::print);
    }

    public void start() {
        Result result = null;
        ResultType resultType = null;
        String inputStr = UserInputView.inputNumbers();
        String restartStr;

        try {
            result = new Result(resultList, User.inputStrToList(inputStr));
            resultType = result.getResultType();
            UserInputView.resultConfirm(resultType);
        } catch (IllegalArgumentException e) {
            start();
        }

        if(!resultType.isResult()) start();

        restartStr = UserInputView.inputRestart();

        if(restartStr.equals("1")) {
            init();
            start();
        }

        System.exit(0);
    }
}

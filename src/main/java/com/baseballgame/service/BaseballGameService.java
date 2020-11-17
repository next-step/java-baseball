package com.baseballgame.service;

import com.baseballgame.util.ComUtil;
import com.baseballgame.util.GameUtil;
import com.baseballgame.util.UserUtil;

import java.util.List;
import java.util.Map;

public class BaseballGameService implements GameService{

    private ComUtil comUtil;
    private GameUtil gameUtil;
    private UserUtil userUtil;

    public BaseballGameService() {
        comUtil  = new ComUtil();
        gameUtil = new GameUtil();
        userUtil = new UserUtil();
    }


    @Override
    public List<String> generateTargetNum() {
        return comUtil.generateTargetNum();
    }

    @Override
    public boolean matchNumber(List<String> userNumber, List<String> comNumber) {
        return gameUtil.matchNumber(userNumber,comNumber);
    }

    @Override
    public Map<String, Object> assignBallType(List<String> userNumber, List<String> comNumber) {
        return gameUtil.assignBallType(userNumber , comNumber);
    }

    @Override
    public List<String> changeStringToArray(String inputNumber) {
        return userUtil.changeStringToArray(inputNumber);
    }

}

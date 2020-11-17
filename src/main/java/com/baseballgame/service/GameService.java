package com.baseballgame.service;

import java.util.List;
import java.util.Map;

public interface GameService {
    public List<String> generateTargetNum();
    public boolean matchNumber(List<String> userNumber , List<String> comNumber);
    public Map<String, Object> assignBallType(List<String> userNumber , List<String> comNumber);
    public List<String> changeStringToArray(String inputNumber);

}

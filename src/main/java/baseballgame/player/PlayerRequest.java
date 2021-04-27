package baseballgame.player;

import baseballgame.constant.BallCount;

public class PlayerRequest {
    public static Player requestCreatePlayer(String input){
        if(input.length() > BallCount.COUNT){
            throw new IllegalArgumentException();
        }
        Integer[] integerArray = stringToIntegerArray(input);
        if (!Player.isValid(integerArray)) {
            throw new IllegalArgumentException();
        }
        return Player.createPlayer(integerArray);
    }

    private static Integer[] stringToIntegerArray(String input) {
        String[] temp = input.split("");
        Integer[] integerArray = new Integer[temp.length];
        for (int i = 0; i < temp.length; i++) {
            integerArray[i] = Integer.parseInt(temp[i]);
        }
        return integerArray;
    }
}

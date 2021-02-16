package utils;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    private Validator() {}

    public static void OneToNineNumberValidation(int number){
        if(number < 1 || number > 9){
            throw new IllegalArgumentException("1~9의 숫자만 입력할 수 있습니다.");
        }
    }

    public static void threeLengthNumberValidation(int number){
        if(String.valueOf(number).length() != 3){
            throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
        }
    }

    public static void duplicatedThreeNumberValidation(int number){
        String[] splitStringNumbers = String.valueOf(number).split("");
        int uniqueNumberSize = new HashSet<>(Arrays.asList(splitStringNumbers)).size();
        if (uniqueNumberSize != 3){
            throw new IllegalArgumentException("중복된 숫자를 입력하면 안됩니다.");
        }
    }
}

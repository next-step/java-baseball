package utils;

public class Validator {
    private Validator() {}

    public static void OneToNineNumberValidation(int number){
        if(number < 1 || number > 9){
            throw new IllegalArgumentException("1~9의 숫자만 입력할 수 있습니다.");
        }
    }
}

package exception;

import java.util.HashSet;
import java.util.Set;

public class MessageException {

    public static void throwsCheck(String input)  {
        lengthCheck(input);
        numberCheck(input);
        duplicateCheck(input);
    }

    private static void duplicateCheck(String input) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < input.length(); i++){
            System.out.println(input.charAt(i)-'0');
            set.add(input.charAt(i)-'1');
        }
        if(set.size() != 3){
            System.out.println("3개의 문자열 중 중복 되는 숫자가 존재 합니다.");
            throw new IllegalStateException();
        }
    }

    private static void lengthCheck(String input){
        if(input.length() == 0 || input.length() < 3){
            System.out.println("숫자 길이가 올바르지 않습니다 3개의 숫자를 입력 해주세요.");
            throw new IllegalStateException();
        }
    }
    private static void numberCheck(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.println("숫자만 입력 가능 합니다.");
            e.getStackTrace();
        }
    }

}

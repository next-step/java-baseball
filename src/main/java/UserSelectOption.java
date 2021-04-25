public class UserSelectOption {
    public static boolean selectOption(String input) {

        if(input.equals("1") ){
            return true;
        }

        if(input.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("입력하신 " + input + "는 유효하지 않은 값입니다.");
    }
}

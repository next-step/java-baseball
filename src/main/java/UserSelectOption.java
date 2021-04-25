public class UserSelectOption {
    public boolean selectOption(String input) {
        if(input == "1"){
            return true;
        }
        if(input == "2"){
            return false;
        }
        throw new IllegalArgumentException("입력하신 " + input + "는 유효하지 않은 값입니다.");
    }
}

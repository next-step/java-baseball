package validators;

import game.BaseballGame;

public class BaseballNumberValidator implements Validator {

    @Override
        public void checkValid(String input) throws Exception{
            checkLengthCorrect(input);
            checkNotNumberExist(input);
            checkDuplicateExist(input);
        }
        void checkLengthCorrect(String input) throws Exception{
            if(input.length() != BaseballGame.NUMBER_LENGTH){
                throw new Exception("길이가 맞지 않습니다. 총 길이는 " + BaseballGame.NUMBER_LENGTH + " 이어야 합니다.");
            }
        }
        void checkDuplicateExist(String input) throws Exception{
            boolean[] chars = new boolean[400];
            for (int i = 0; i < input.length(); i++) {
                checkDuplicate(chars, input.charAt(i));
                chars[input.charAt(i)] = true;
            }
        }
        void checkDuplicate(boolean[] chars, char c) throws Exception{
            if(chars[c])
                throw new Exception("중복된 숫자가 존재하면 안됩니다.");
        }
        void checkNotNumberExist(String input) throws Exception{
            for (int i = 0; i < input.length(); i++) {
                checkNotNumber(input.charAt(i));
            }
        }
        void checkNotNumber(char c) throws Exception{
            if(c < '0' || c > '9')
                throw new Exception("숫자만 입력해 주세요.");
        }
}

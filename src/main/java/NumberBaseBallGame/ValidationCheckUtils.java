package NumberBaseBallGame;

import java.util.HashSet;
import java.util.Set;

public class ValidationCheckUtils {
	private static final int GAMENUMBERS_LENGTH= 3;

	public static void checkInputNumber(String clientNumber){
		if(!clientNumber.matches("^[1-9]*$")){
			throw new IllegalArgumentException("1~9사이의 숫자만 입력해주세요. example : 123, 456 ");
		}

		if(clientNumber.length() != GAMENUMBERS_LENGTH){
			throw new IllegalArgumentException(GAMENUMBERS_LENGTH+"글자만 입력해주세요. example : 123, 456 ");
		}

		char[] chars = clientNumber.toCharArray();
		Set set = new HashSet();
		for(char item:chars){
			set.add(item);
		}
		if(set.size() != GAMENUMBERS_LENGTH){
			throw new IllegalArgumentException("숫자가 중복되면 안됩니다.");
		}
	}
}

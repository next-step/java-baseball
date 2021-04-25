package NumberBaseBallGame;

import java.util.HashSet;
import java.util.Set;

public class ValidationCheckUtils {
	private static final int GAMENUMBERS_LENGTH= 3;
	public static void checkValidation(String clientNumber){
		if(clientNumber.length() != GAMENUMBERS_LENGTH){
			throw new IllegalArgumentException("중복되지 않는 숫자 "+GAMENUMBERS_LENGTH+"자리를 입력해야합니다.");
		}

		if(!clientNumber.matches("^[0-9]*$")){
			throw new IllegalArgumentException("중복되지 않는 숫자 "+GAMENUMBERS_LENGTH+"자리를 입력해야합니다.");
		}
		char[] chars = clientNumber.toCharArray();
		Set set = new HashSet();
		for(char item:chars){
			set.add(item);
		}
		if(set.size() != GAMENUMBERS_LENGTH){
			throw new IllegalArgumentException("중복되지 않는 숫자 "+GAMENUMBERS_LENGTH+"자리를 입력해야합니다.");
		}
	}
}

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseballGameGo {
	private final int numnCreateCnt = 3;
	BaseballGameGo(){
		
	}
	
	public static void main(String[] args) {
		BaseballGameGo bg = new BaseballGameGo();
		bg.startBaseballGame();
	}

	public void startBaseballGame() {
		String rNumStr = createRandomNum();
//		System.out.println(rNumStr);
	}
	
	public String createRandomNum() {
		Set<Integer> distinctNumSet = new LinkedHashSet<>();
		while(distinctNumSet.size() < numnCreateCnt) {
			distinctNumSet.add(new Random().nextInt(9) + 1);
		}
		return convertSetToStr(distinctNumSet);
	}
	
	public String convertSetToStr(Set<Integer> distinctNumSet) {
		StringBuilder returnStrBd = new StringBuilder();
		for (Integer num : distinctNumSet) {
			returnStrBd.append(num.toString());
		}
		return returnStrBd.toString();
	}
}

import java.util.Arrays;

public class JunitString {

	public static void main(String[] args) {
		// System.out.println(subStringParenthesis("(1,2)"));
	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	// String 요구사항1
	// "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	// 1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	public int[] splitIntArray(String str) {
		return Arrays.stream(str.split(",")).sorted().mapToInt(Integer::parseInt).toArray();
	}

	// String 요구사항2
	// "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
	public String subStringParenthesis(String str) {
		int index = str.indexOf("(");
		str = str.substring(index + 1, str.length());
		index = str.indexOf(")");
		str = str.substring(0, index);

		return str;
	}

}

import java.util.ArrayList;
import java.util.List;

public class Input {
	private List<Integer> list = new ArrayList<>();
	private String item;

	public Input(String item) {
		this.item = item;
	}

	public List<Integer> convertInput() {
		int length = item.length();
		for (int i = 0 ; i < length ; i++) {
			char c = item.charAt(i);
			int number = Character.digit(c, 10);
			list.add(number);
		}

		return list;
	}
}

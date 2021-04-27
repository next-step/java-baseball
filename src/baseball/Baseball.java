package baseball;

import baseball.util.TypeConverter;

public class Baseball {
	
	private int[] Baseball;

	public Baseball(int[] numbers) {
		this.Baseball = numbers;
	}

	public Baseball(String numbers) {
		this.Baseball = TypeConverter.stringToIntAarray(numbers);
	}
	
	public int getBaseballSize() {
		return Baseball.length;
	}
	
	public int getNumber(int i) {
		return Baseball[i];
	}

	public int[] getBaseball() {
		return Baseball;
	}

	public void setBaseball(int[] baseball) {
		Baseball = baseball;
	}
	
}

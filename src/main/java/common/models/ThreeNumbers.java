package common.models;

public class ThreeNumbers {
	public static final int NUMBERS_SIZE = 3;
	private int[] numbers;
	
	public ThreeNumbers(int numbers) {
		this.numbers = new int[3];
		this.numbers[0] = numbers/100;
		this.numbers[1] = (numbers%100)/10;
		this.numbers[2] = numbers%10;
	}
	
	public ThreeNumbers(int number1,int number2,int number3) {
		this.numbers = new int[3];
		this.numbers[0] = number1;
		this.numbers[1] = number2;
		this.numbers[2] = number3;
	}
	
	public int getNumber(int index) {
		return numbers[index];
	}
}

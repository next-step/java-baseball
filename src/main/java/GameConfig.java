public class GameConfig {
	private int lengthDigit;
	private int maxOptionNum;
	private int minOptionNum;

	public void setLengthDigit(int num){
		this.lengthDigit = num;
	}

	public int getLengthDigit(){
		return this.lengthDigit;
	}

	public void setMinOptionNum(int min) {
		this.minOptionNum = min;
	}

	public int getMinOptionNum(){
		return this.minOptionNum;
	}

	public void setMaxOptionNum(int maxOptionNum){
		this.maxOptionNum = maxOptionNum;
	}

	public int getMaxOptionNum(){
		return this.maxOptionNum;
	}
}

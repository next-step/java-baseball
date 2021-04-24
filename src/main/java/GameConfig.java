public class GameConfig {
	private int lengthDigit;
	private int minOptionNum;
	private int maxOptionNum;

	public GameConfig(int lengthDigit, int minOptionNum, int maxOptionNum ){
		this.lengthDigit = lengthDigit;
		this.minOptionNum = minOptionNum;
		this.maxOptionNum = maxOptionNum;
	}

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

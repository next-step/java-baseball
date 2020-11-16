public class PlayBaseBall {

	public static void main(String[] args) {
		int number = getRandomNumber();

		PlayBaseBall playBaseBall = new PlayBaseBall();
		String computerNumber = playBaseBall.getThreeDifferentNumber(number, "");
	}

	public String getThreeDifferentNumber(int number, String resultNumber) {
		int reNumber = getRandomNumber();
		System.out.println("resultNumber" + resultNumber);
		if (resultNumber.length() > 2) {
			return resultNumber;
		}

		if (number < 1) {
			getThreeDifferentNumber(reNumber, resultNumber);
		}

		int index = resultNumber.indexOf(String.valueOf(number));

		if (index > -1) {
			getThreeDifferentNumber(reNumber, resultNumber);
		}

		if (index < 0) {
			resultNumber += number;
		}

		return getThreeDifferentNumber(reNumber, resultNumber);
	}

	public static int getRandomNumber() {
		return (int)(Math.random() * 10); // 0 ~ 9 까지
	}

}

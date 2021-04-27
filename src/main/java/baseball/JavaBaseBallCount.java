package baseball;

public class JavaBaseBallCount {

	public int strikeCount;
	public int ballCount;

	/**
	 * strike�� ball ������ �����Ѵ�.
	 */
	public void resetCount() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	/**
	 * �÷��̾�� ������ ��Ʈ �޼����� �����.
	 * 
	 * @return
	 */
	public String makeResultMessage() {
		String resultMessage = "";
		resultMessage += strikeCount > 0 && strikeCount < 3 ? String.format("%d ��Ʈ����ũ", strikeCount) : "";
		resultMessage += ballCount > 0 ? String.format("%d ��", ballCount) : "";
		resultMessage += strikeCount == 0 && ballCount == 0 ? "����" : "";
		return resultMessage;
	}
}

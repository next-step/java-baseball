package common.models;

public class PlayResultModel {
	
	private boolean isFinish;
	private String resultMessage;
	
	public PlayResultModel(boolean isFinish, String resultMessage) {
		this.isFinish = isFinish;
		this.resultMessage = resultMessage;
	}
	
	public boolean isFinish() {
		return isFinish;
	}
	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
}

package view;

public class RerunControllerImpl implements RerunController {
	private final String rerunFlag;
	private final String endFlag;

	public RerunControllerImpl(String rerunFlag, String endFlag) {
		this.rerunFlag = rerunFlag;
		this.endFlag = endFlag;
	}

	@Override
	public boolean isRerun(String input) {
		return input.equals(rerunFlag);
	}

	@Override
	public String getRerunFlag() {
		return rerunFlag;
	}

	@Override
	public String getEndFlag() {
		return endFlag;
	}
}

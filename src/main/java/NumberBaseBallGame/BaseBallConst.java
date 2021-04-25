package NumberBaseBallGame;

public class BaseBallConst {
	public static final int GAMENUMBERS_LENGTH = 3;
	public static final int INPUT_RANGE_MIN = 1;
	public static final int INPUT_RANGE_MAX = 9;

	public enum GAME_STATUS{
		STRIKE("STRIKE", "스트라이크"),
		BALL("BALL", "볼"),
		NOTHING("NOTHING", "낫싱");
		private String code;
		private String name;

		GAME_STATUS(String code, String name) {
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}
}

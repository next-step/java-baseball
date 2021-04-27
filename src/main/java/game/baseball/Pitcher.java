package game.baseball;

public class Pitcher {
	private String pitch;

	private Integer[] pitches = new Integer[3];

	public void setPiches() {
		for (int i = 0; i < pitches.length; i++){
			pitches[i] = Integer.parseInt(pitch.split("")[i]);
		}
	}

	public void setPitch(String pitch) {
		this.pitch = pitch;
	}

	public Integer[] getPitches() {
		return pitches;
	}
}

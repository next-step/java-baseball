package game.baseball;

import java.util.Scanner;

public class Pitcher {
	private String pitch;

	private Integer[] pitches = new Integer[3];

	public void setPitch() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		pitch = sc.nextLine();
	}

	public void splitPitches() {
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

package player;

import display.Display;

public class Player {
	private boolean participant;

	public Player() {
		this.participant = true;
	}

	public int answer(Display display) {
		return display.input();
	}

	public void exitNumberBaseball() {
		this.participant = false;
	}

	public boolean isParticipant() {
		return participant;
	}
}

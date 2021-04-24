package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private Umpire umpire;
	private DefensePlayer defensePlayer;
	private OffensePlayer offensePlayer;

	private Status status;

	public Game(){
		createParticipants();
		setGameStatus(Status.ONGOING);
	}

	public void setGameStatus(Status ongoing) {
		this.status = ongoing;
	}

	private void createParticipants() {
		this.umpire = new Umpire();
		this.defensePlayer = new DefensePlayer();
		this.offensePlayer = new OffensePlayer();
	}

	public void play(){
		Numbers answer = defensePlayer.decideAnswerNumber();
		System.out.println(answer.getDigits().toString());
		while (umpire.getStrike() != Numbers.MAX_SIZE){
			umpire.requestInput();
			Numbers guess = offensePlayer.makeGuess();
			umpire.makeJudgement(answer, guess);
		}
		//임의로 3스트라이크 맞으면 게임 중단
		status = Status.FINISHED;
	}

	public enum Status{
		ONGOING(1),
		FINISHED(2);

		private int code;

		Status(int code){
			this.code = code;
		}
		public int getCode() {
			return code;
		}
	}


	public Umpire getUmpire(){
		return this.umpire;
	}

	public DefensePlayer getDefensePlayer() {
		return this.defensePlayer;
	}

	public OffensePlayer getOffensePlayer() {
		return this.offensePlayer;
	}

	public Status getStatus() {
		return this.status;
	}
}
